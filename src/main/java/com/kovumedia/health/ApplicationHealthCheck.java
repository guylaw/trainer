package com.kovumedia.health;

import com.codahale.metrics.health.HealthCheck;

public class ApplicationHealthCheck extends HealthCheck {
    private final String template;

    public ApplicationHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
