package org.ergea.authapp.dto;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {
    @NotEmpty(message = "Must not empty")
    private String username;
    @NotEmpty(message = "Must not empty")
    private String password;
}
