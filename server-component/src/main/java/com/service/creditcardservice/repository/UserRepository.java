package com.service.creditcardservice.repository;

import com.service.creditcardservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>,
    CrudRepository<User, Integer> {

    /**
     * Method to check whether user name already exists in {@link User}
     *
     * @param emailAddress value of user email address to be checked for existence
     * @return true if email exists, false otherwise
     */
    boolean existsByEmail(String emailAddress);

    /**
     * Method to check user exists in {@link User}
     *
     * @param userId value of user id to be checked for existence
     * @return true if email exists, false otherwise
     */
    boolean existsByUserId(Integer userId);

    /**
     * Method to return {@link User} by User Id
     *
     * @param userId value of Id whose {@link User} to be retrieved
     * @return {@link User}
     */
    Optional<User> findByUserId(int userId);

}
