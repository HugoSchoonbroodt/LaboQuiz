package anthohugo.laboquiz.domains.dtos;
import anthohugo.laboquiz.domains.entities.User;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class UserLoginForm {

    private String username;

    private String password;

    public User toEntity(){
        return User.builder()
                .username(this.getUsername())
                .password(this.getPassword())
                .build();
    }
}