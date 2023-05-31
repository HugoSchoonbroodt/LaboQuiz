package anthohugo.laboquiz.domains.dtos;

import anthohugo.laboquiz.domains.entities.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConnectedUserDTO {

    private Long id;

    private String username;

    private String email;

    public static ConnectedUserDTO fromEntity(User user){

        return ConnectedUserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}