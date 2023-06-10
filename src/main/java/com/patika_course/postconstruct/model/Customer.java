package com.patika_course.postconstruct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Builder
@AllArgsConstructor
public class Customer {
    private String fullName;
    private int id;
}
