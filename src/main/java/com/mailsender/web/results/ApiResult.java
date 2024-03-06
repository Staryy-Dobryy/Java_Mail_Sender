package com.mailsender.web.results;

import org.springframework.util.Assert;

import java.util.HashMap;

public class ApiResult extends HashMap<String, Object> {
    public ApiResult add(String key, Object value) {
        Assert.hasText(key, "Parameter `key` must not be empty");
        Assert.notNull(value, "Parameter `value` must not be null");

        this.put(key, value);
        return this;
    }
}
