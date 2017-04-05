package com.springinaction.web;

import com.springinaction.Spitter;
import com.springinaction.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Created by 1 on 27.03.2017.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            /*@RequestPart("profilePicture") byte[] profilePicture,
            @Valid Spitter spitter,*/
            @Valid Spitter spitter,
            Errors errors) throws IOException {
        if(errors.hasErrors()){
            return "registerForm";
        }

        spitterRepository.save(spitter);
        saveFile(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    private void saveFile(@Valid Spitter spitter)
            throws IOException {
        MultipartFile file = spitter.getProfilePicture();
        String contentType = file.getContentType();
        File tempFile = new File("C:/springinaction/" + spitter.getUsername() + "." +
                contentType.substring(contentType.indexOf("/") + 1));
        file.transferTo(tempFile);
    }

    @RequestMapping(value="/{username}",method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username,Model model){
        Spitter result = spitterRepository.findByUsername(username);
        model.addAttribute(result);

        return "profile";
    }
}
