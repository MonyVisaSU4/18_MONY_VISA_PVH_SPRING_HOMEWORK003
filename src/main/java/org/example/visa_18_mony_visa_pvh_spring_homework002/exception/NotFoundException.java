package org.example.visa_18_mony_visa_pvh_spring_homework002.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
