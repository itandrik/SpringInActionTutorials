package com.springinaction.data;

import com.springinaction.Spitter;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Created by 1 on 28.03.2017.
 */
@Component
public class SpitterRepositoryImpl implements SpitterRepository{
    private HashSet<Spitter> repository;
    private long counter;

    public SpitterRepositoryImpl() {
        repository = new HashSet<>();
    }

    @Override
    public Spitter save(Spitter spitter) {
        spitter.setId(++counter);
        repository.add(spitter);
        return spitter;
    }
}
