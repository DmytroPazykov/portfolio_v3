package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class User {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
