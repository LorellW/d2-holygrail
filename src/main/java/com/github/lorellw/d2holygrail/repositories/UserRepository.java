package com.github.lorellw.d2holygrail.repositories;

import com.github.lorellw.d2holygrail.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
