package com.hasith.restfulwebservicesforsocialmediaapplication.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hasith.restfulwebservicesforsocialmediaapplication.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private  Integer id;

    @Size(min = 10, message = "Post should have minimum of 10 characters")
    private  String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
    }

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
