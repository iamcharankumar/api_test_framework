package io.backend.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEmployeeRequest {
    String name;
    String salary;
    String age;
}