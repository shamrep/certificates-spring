package org.certspring.model;

import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

//@Component
public record Customer(@Id Long id, String email, String password) {
}
