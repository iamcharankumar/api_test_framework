package io.backend.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUsersRequest {
    String name;
    String job;
}
