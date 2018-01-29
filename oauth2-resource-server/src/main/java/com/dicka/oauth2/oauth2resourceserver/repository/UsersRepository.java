package com.dicka.oauth2.oauth2resourceserver.repository;

import com.dicka.oauth2.oauth2resourceserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    Optional<Users> findByName(String username);

}
