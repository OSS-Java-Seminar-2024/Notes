package com.smb.theatre.repository;

import com.smb.theatre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where email like '%email%'", nativeQuery = true)
    User findByEmail (String email);

    @Query(value = "select * from user where username like '%username%'", nativeQuery = true)
    User findByUserName (String username);
}
