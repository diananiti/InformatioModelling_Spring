package io.swagger.api;

import io.swagger.model.User;
import io.swagger.model.Users;
import io.swagger.service.UserRepository;
import io.swagger.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-05T09:10:50.989Z")

@Controller
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

   // private final ArrayList<User> Users=new ArrayList<>();
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request, UserService userService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.userService = userService;
    }

    public ResponseEntity<User> createUser(@ApiParam(value = "Created user object" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        body.getEmail();

        if (accept != null && accept.contains("application/xml")) {


            return ResponseEntity.ok(userService.addUser(body));

        }
        if (accept != null && accept.contains("application/json")) {

            return ResponseEntity.ok(userService.addUser(body));

        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> deleteUser(@ApiParam(value = "The name that needs to be deleted",required=true) @PathVariable("id") long id) {
        String accept = request.getHeader("Accept");



        if (accept != null && accept.contains("application/json")) {

            return ResponseEntity.ok(userService.deleteUserById(id));

        }
        if (accept != null && accept.contains("application/xml")) {

            return ResponseEntity.ok(userService.deleteUserById(id));
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);



    }

    public ResponseEntity<User> getUserByName(@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ",required=true) @PathVariable("username") String username) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("<User>  <id>123456789</id>  <username>aeiou</username>  <password>aeiou</password>  <email>aeiou</email></User>", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{  \"password\" : \"password\",  \"id\" : 0,  \"email\" : \"email\",  \"username\" : \"username\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Users> findAllUsers() {
        // public ResponseEntity<List<Student>> findAllStudents() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            // try {
            // return new ResponseEntity<List<Student>>(objectMapper.readValue(" <Student>
            // <rollNo>123456789</rollNo> <name>John</name> <surname>Kowalski</surname>
            // </Student>", List.class), HttpStatus.NOT_IMPLEMENTED);
            // } catch (IOException e) {
            // log.error("Couldn't serialize response for content type application/xml", e);
            // return new ResponseEntity<List<Student>>(HttpStatus.INTERNAL_SERVER_ERROR);
            // }
            Users sts = new Users();
            sts.setUsers(userService.findAllUsers());
            return ResponseEntity.ok(sts);
        }

        if (accept != null && accept.contains("application/json")) {
            // try {
            // return new ResponseEntity<List<Student>>(objectMapper.readValue("[ {
            // \"surname\" : \"Kowalski\", \"name\" : \"John\", \"rollNo\" : 0}, {
            // \"surname\" : \"Kowalski\", \"name\" : \"John\", \"rollNo\" : 0} ]",
            // List.class), HttpStatus.NOT_IMPLEMENTED);
            // } catch (IOException e) {
            // log.error("Couldn't serialize response for content type application/json",
            // e);
            // return new ResponseEntity<List<Student>>(HttpStatus.INTERNAL_SERVER_ERROR);
            // }
            Users sts = new Users();
            sts.setUsers(userService.findAllUsers());
            List<User> a = userRepository.findAll();
            sts.setUsers(a);
            return ResponseEntity.ok(sts);
        }

        return new ResponseEntity<Users>(HttpStatus.NOT_IMPLEMENTED);
        // return new ResponseEntity<List<Student>>(HttpStatus.NOT_IMPLEMENTED);
    }



    public ResponseEntity<Void> loginUser(@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username,@NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> logoutUser() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> updateUser(@ApiParam(value = "name that need to be updated",required=true) @PathVariable("username") String username, @ApiParam(value = "Updated user object" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/xml")) {

            return ResponseEntity.ok(userService.updateUser(body));
        }
        if (accept != null && accept.contains("application/json")) {

            return ResponseEntity.ok(userService.updateUser(body));
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

}
