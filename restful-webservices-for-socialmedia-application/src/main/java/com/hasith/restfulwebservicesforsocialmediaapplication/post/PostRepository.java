package com.hasith.restfulwebservicesforsocialmediaapplication.post;

import com.hasith.restfulwebservicesforsocialmediaapplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
