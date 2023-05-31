package anthohugo.laboquiz.domains.forms;

import anthohugo.laboquiz.domains.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor @ToString
public class UserRegisterForm {

    @NotBlank(message = "Required Field")
    @Size(max = 50, message = "Max size set to 50")
    private String username;

    @NotBlank(message = "Required Field")
    @Size(max = 100, message = "Max size set to 50")
    private String email;

    @NotBlank(message = "Required Field")
    @Size(max = 100, message = "Max size set to 50")
    private String password;

    @NotBlank(message = "Required Field")
    @Size(max = 100, message = "Max size set to 50")
    private String confirmPassword;


    public User toEntity(){

        return User.builder()
                .username(getUsername())
                .email(getEmail())
                .password(getPassword())
                .build();
    }
}