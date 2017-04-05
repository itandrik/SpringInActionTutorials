package com.springinaction.data;


import com.springinaction.Spittle;

import java.util.List;
import java.util.Optional;

/**
 * Created by 1 on 26.03.2017.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Optional<Spittle> findOne(long spittleId);
    void save(Spittle spittle);
}
