package com.service.creditcardservice.service;

import com.service.creditcardservice.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Service class for user service
 */
@Component
public interface UserService {

    /**
     * Controller Method to add {@link User}
     *
     * @param user {@link User} to be saved
     * @return userId of @link {@link User}} Created
     * @throws Exception Exception to be thrown on Failure
     */
    User createUser(@Validated User user) throws Exception;

    /**
     * Method to Update {@link User}
     *
     * @param user value for Update {@link User}
     * @return Updated {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    User updateUser(@Validated User user) throws Exception;

    /**
     * Method to Delete {@link User}
     *
     * @param UserId value for Deleting {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    void deleteUser(int UserId) throws Exception;

    /**
     * Method to Retrieve List of {@link User}
     *
     * @return List of {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    List<User> getAllUsers() throws Exception;

    /**
     * Method to Retrieve {@link User}
     *
     * @param userId value for retrieving {@link User}
     * @return {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    Optional<User> getUserById(@RequestParam int userId) throws Exception;

}
