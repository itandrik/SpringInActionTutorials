package com.springinaction.data;

import com.springinaction.Spitter;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by 1 on 28.03.2017.
 */
@Component
public class SpitterRepositoryImpl implements SpitterRepository{
    private HashMap<String, Spitter> repository;
    private long counter;

    public SpitterRepositoryImpl() {
        repository = new HashMap<>();
    }

    @Override
    public Spitter save(Spitter spitter) {
        spitter.setId(++counter);
        repository.put(spitter.getUsername(), spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return repository.get(username);
    }
}
