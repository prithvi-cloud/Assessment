package com.service.creditcardservice.controller;

import com.service.creditcardservice.entity.User;
import com.service.creditcardservice.service.UserService;
import com.service.creditcardservice.util.LogMarker;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * UserController
 *
 * @author Prithvi
 */
@RestController
@RequestMapping("/service/users/")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Controller Method to add {@link User}
     *
     * @param user {@link User} to be saved
     * @return userId of @link {@link User}} Created
     * @throws Exception Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to save Memo ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Memo is created")
    })
    @PostMapping
    public ResponseEntity<Integer> createUser(@Validated @RequestBody User user) throws Exception {

        logger.info(LogMarker.ENTRY, "Creating User with email {}", user.getEmail());

        User userDetails = userService.createUser(user);

        logger.info(LogMarker.EXIT, "Created used with id {}", userDetails.getUserId());

        return new ResponseEntity<Integer>(userDetails.getUserId(), HttpStatus.CREATED);

    }

    /**
     * Method to Update {@link User}
     *
     * @param user value for Update {@link User}
     * @return Updated {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to save Memo ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Memo is created")
    })
    @PutMapping
    public ResponseEntity<Integer> updateUser(@RequestBody User user) throws Exception {

        logger.info(LogMarker.ENTRY, "Updating User with Id {}", user.getUserId());

        User userDetails = userService.updateUser(user);

        logger.info(LogMarker.EXIT, "Updated User with ID {}", user.getUserId());

        return new ResponseEntity<Integer>(user.getUserId(), HttpStatus.OK);
    }

    /**
     * Method to Delete {@link User}
     *
     * @param userId value for Deleting {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to save Memo ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Memo is created")
    })
    @DeleteMapping
    public void deleteUser(@RequestParam int userId) throws Exception {

        logger.info(LogMarker.ENTRY, "Delete User with User Id {}", userId);

        userService.deleteUser(userId);

        logger.info(LogMarker.EXIT, "Deleted User with User Id {}", userId);

    }

    /**
     * Method to Retrieve List of {@link User}
     *
     * @return List of {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to save Memo ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Memo is created")
    })
    @PostMapping("/all")
    public List<User> getAllUsers() throws Exception {

        logger.info(LogMarker.ENTRY, "Retrieving All User");

        List<User> userList = userService.getAllUsers();

        logger.info(LogMarker.EXIT, "Retrieved {} User", userList.size());

        return userList;
    }

    /**
     * Method to Retrieve {@link User}
     *
     * @param userId value for retrieving {@link User}
     * @return {@link User}
     * @throws Exception Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to save Memo ")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Memo is created")
    })
    @GetMapping
    public Optional<User> getUserById(@RequestParam int userId) throws Exception {

        logger.info(LogMarker.ENTRY, "Retrieve User with id : {}", userId);

        Optional<User> user = userService.getUserById(userId);

        logger.info(LogMarker.EXIT, "Retrieved {} User", userId);
        return user;
    }
}
