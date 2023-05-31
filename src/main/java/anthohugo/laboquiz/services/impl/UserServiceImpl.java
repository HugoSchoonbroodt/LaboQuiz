package anthohugo.laboquiz.services.impl;

import anthohugo.laboquiz.domains.dtos.UserDTO;
import anthohugo.laboquiz.domains.dtos.UserLoginForm;
import anthohugo.laboquiz.domains.entities.User;
import anthohugo.laboquiz.domains.forms.UserRegisterForm;
import anthohugo.laboquiz.exceptions.EntityNotFoundException;
import anthohugo.laboquiz.exceptions.InvalidPasswordUserException;
import anthohugo.laboquiz.repositories.UserRepository;
import anthohugo.laboquiz.services.UserService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
@SessionScoped
public class UserServiceImpl implements UserService, Serializable {

    @Inject
    private UserRepository userRepository;

    @Override
    public void add(UserRegisterForm a) {
        User user = a.toEntity();
        userRepository.add(user);
    }

    @Override
    public Optional<UserDTO> getOne(Long id) {
        Optional<User> user = userRepository.getOne(User.class, id);
        return user.map(UserDTO::fromEntity);
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.getAll(User.class);

        for (User user : users) {
            UserDTO userDTO = UserDTO.fromEntity(user);
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

    @Override
    public void update(Long id) {
        Optional<User> userToUpdateOptional = userRepository.getOne(User.class, id);
        if (userToUpdateOptional.isPresent()) {
            User userToUpdate = userToUpdateOptional.get();

            userRepository.update(User.class, id, userToUpdate);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<User> userToDeleteOptional = userRepository.getOne(User.class, id);
        if (userToDeleteOptional.isPresent()) {
            User userToDelete = userToDeleteOptional.get();
            userRepository.delete(User.class, id);
        }
    }

    public UserDTO authenticate(UserLoginForm userForm) throws EntityNotFoundException, InvalidPasswordUserException {
        User user = userRepository.findByUsername(userForm.getUsername());
        if (user == null) {
            throw new EntityNotFoundException("Nom d'utilisateur non valide");
        }
        if (!user.getPassword().equals(userForm.getPassword())) {
            throw new InvalidPasswordUserException("Mot de passe non valide");
        }

        return UserDTO.fromEntity(user);
    }

}