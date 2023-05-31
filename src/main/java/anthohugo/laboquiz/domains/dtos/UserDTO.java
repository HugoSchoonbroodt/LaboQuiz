package anthohugo.laboquiz.domains.dtos;

import anthohugo.laboquiz.domains.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private String username;

    public static UserDTO fromEntity(User a){
        return new UserDTO(a.getUsername());
    }
}