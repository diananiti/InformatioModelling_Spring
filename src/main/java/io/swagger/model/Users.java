package io.swagger.model;

import java.util.List;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @JacksonXmlProperty(localName = "User")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("users")
    protected List<User> users = null;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}