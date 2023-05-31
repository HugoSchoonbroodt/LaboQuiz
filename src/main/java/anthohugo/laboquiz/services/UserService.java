package anthohugo.laboquiz.services;

import anthohugo.laboquiz.domains.dtos.UserDTO;
import anthohugo.laboquiz.domains.dtos.UserLoginForm;
import anthohugo.laboquiz.domains.entities.User;
import anthohugo.laboquiz.domains.forms.UserRegisterForm;

import java.util.List;
import java.util.Optional;


public interface UserService {

    void add(UserRegisterForm a);

    Optional<UserDTO> getOne(Long id);

    List<UserDTO> getAll();

    void update(Long id);

    void delete(Long id);

    UserDTO authenticate(UserLoginForm userForm);
}