package com.patika_course.core.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware  {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("amalj");
    }

//    public Optional getAuditor(String user){
//        return Optional.ofNullable(user);
//    }
}
