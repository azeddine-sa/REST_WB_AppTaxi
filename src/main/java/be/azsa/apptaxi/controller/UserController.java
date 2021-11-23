package be.azsa.apptaxi.controller;

import be.azsa.apptaxi.model.User;
import be.azsa.apptaxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public JavaMailSender emailSender;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //POST
    // build create user REST API
    @PostMapping("user/add")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());
        message.setSubject("Confirmation d'inscription à AzTaxi");
        message.setText("Vous avez reçu ce courriel parque vous vous êtes récemment inscrit sur notre Application Taxi. Merci");

        // Send Message!
        this.emailSender.send(message);


        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    //GET
    //build get all users REST API
    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //build get user by id REST API
    //localhost:8080/api/users/1
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long idUser){

        return new ResponseEntity<>(userService.getUserById(idUser), HttpStatus.OK);
    }

    //build get user by email REST API
    //localhost:8080/api/users/saouti.azeddine@gmail.com
    @GetMapping("/user/bymail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    //PUT
    //build update user REST API
    //localhost:8080/api/users/1
    @PutMapping("user/{id}/edit")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    //DELETE
    //build deleter user REST API
    @DeleteMapping("user/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);

        return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
    }

}
