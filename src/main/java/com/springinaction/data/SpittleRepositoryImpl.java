package com.springinaction.data;

import com.springinaction.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by 1 on 28.03.2017.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    private List<Spittle> repository = new ArrayList<>();

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return repository;
    }

    @Override
    public Optional<Spittle> findOne(long spittleId) {
        return repository.stream().filter(sptl -> sptl.getId() == spittleId).findFirst();
    }

    @Override
    public void save(Spittle spittle) {
        repository.add(spittle);
    }
}
