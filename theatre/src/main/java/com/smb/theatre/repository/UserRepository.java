package com.smb.theatre.repository;

import com.smb.theatre.dto.UserDto;
import com.smb.theatre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(UserDto userDto);

    User finByEmail(String email);
}
