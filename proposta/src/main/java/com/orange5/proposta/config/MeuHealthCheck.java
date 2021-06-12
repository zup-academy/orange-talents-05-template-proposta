package com.orange5.proposta.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MeuHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status(Status.UP).build();
    }
    
}
