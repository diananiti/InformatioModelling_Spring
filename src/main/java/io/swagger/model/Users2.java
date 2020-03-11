package io.swagger.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonValue;

public class Users2 extends Users{


    private static final long serialVersionUID = 1L;

    @JsonValue
    public List<User> getUsers() {
        return users;
    }

}