package com.springinaction.web;

import com.springinaction.Spittle;
import com.springinaction.data.SpittleRepository;
import com.springinaction.web.exception.DuplicateSpittleException;
import com.springinaction.web.exception.SpittleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Optional;

/**
 * Created by 1 on 26.03.2017.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository mockRepository) {
        this.spittleRepository = mockRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }

    @RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable long spittleId,
            Model model){
        Optional<Spittle> spittle = spittleRepository.findOne(spittleId);
        spittle.orElseThrow(SpittleNotFoundException::new);
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String saveSpittle(Spittle form, Model model) {
        spittleRepository.save(
                new Spittle(null, form.getMessage(), new Date(),
                        form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle(){
        return "error/duplicate";
    }
}
