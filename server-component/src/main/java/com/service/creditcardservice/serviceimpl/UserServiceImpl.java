package com.service.creditcardservice.serviceimpl;

import com.service.creditcardservice.entity.User;
import com.service.creditcardservice.repository.UserRepository;
import com.service.creditcardservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * Controller Method to add {@link User}
     *
     * @param user {@link User} to be saved
     * @return userId of @link {@link User}} Created
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public User createUser(User user) throws Exception {

        logger.info("Method to create new user with email {}", user.getEmail());

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("User already exist");
        }

        User userDetails = userRepository.save(user);

        logger.info("Created used with id {}", userDetails.getUserId());
        return userDetails;
    }

    /**
     * Method to Update {@link User}
     *
     * @param user value for Update {@link User}
     * @return Updated {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public User updateUser(User user) throws Exception {

        logger.info("Method to update the user {}", user.getUserId());

        if (!userRepository.existsByUserId(user.getUserId())) {
            throw new Exception("User does not exist");
        }
        User userDetails = userRepository.save(user);

        logger.info("Updated the user details {}", userDetails.getUserId());
        return userDetails;
    }

    /**
     * Method to Delete {@link User}
     *
     * @param userId value for Deleting {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public void deleteUser(int userId) throws Exception {

        logger.info("Method to delete user {}", userId);

        if (!userRepository.existsByUserId(userId)) {
            throw new Exception("User does not exist");
        }
        userRepository.deleteById(userId);

        logger.info("Deleted the user");

    }

    /**
     * Method to Retrieve List of {@link User}
     *
     * @return List of {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public List<User> getAllUsers() throws Exception {

        logger.info("Method retrieve all the user");

        List<User> userList = userRepository.findAll();

        logger.info("Retrieved {} user records", userList.size());

        return userList;
    }

    /**
     * Method to Retrieve {@link User}
     *
     * @param userId value for retrieving {@link User}
     * @return {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public Optional<User> getUserById(int userId) throws Exception {

        logger.info("Method to retrieve user by id", userId);

        Optional<User> user = userRepository.findByUserId(userId);

        if(!user.isPresent()) {
            throw new Exception("User does not exist");
        }
        logger.info("Retrieved user details");
        return user;
    }
}
