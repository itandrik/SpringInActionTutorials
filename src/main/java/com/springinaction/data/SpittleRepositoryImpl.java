package com.springinaction.data;

import com.springinaction.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 28.03.2017.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return new ArrayList<>();
    }
}
