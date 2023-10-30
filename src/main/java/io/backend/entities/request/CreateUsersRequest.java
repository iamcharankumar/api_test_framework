package io.backend.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUsersRequest {
    private String name;
    private String job;
}
