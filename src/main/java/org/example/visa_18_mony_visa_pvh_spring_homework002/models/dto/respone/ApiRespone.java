package org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiRespone<T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime time;
}
