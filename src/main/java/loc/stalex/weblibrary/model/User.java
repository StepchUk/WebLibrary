package loc.stalex.weblibrary.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
