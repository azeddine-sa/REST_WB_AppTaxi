package be.azsa.apptaxi.service.impl;

import be.azsa.apptaxi.exception.ResourceNotFoundException;
import be.azsa.apptaxi.model.User;
import be.azsa.apptaxi.repository.UserRepository;
import be.azsa.apptaxi.service.UserService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        } else{
            throw new ResourceNotFoundException("User", "Id", id);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        } else{
            throw new ResourceNotFoundException("User", "Email", email);
        }
    }

    @Override
    public User updateUser(User user, long id) {
       User existingUser = userRepository.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("User","Id",id));

       existingUser.setFirstname(user.getFirstname());
       existingUser.setLastname(user.getLastname());
       existingUser.setEmail(user.getEmail());
       existingUser.setPassword(user.getPassword());
       existingUser.setPhone(user.getPhone());

       //save existing user to DB
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {

        userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id",id));

        userRepository.deleteById(id);
    }
}
