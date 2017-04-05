package com.springinaction.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by 1 on 05.04.2017.
 */
@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = "Spittle not found")
public class SpittleNotFoundException extends RuntimeException {
}
