package com.service.creditcardservice.controller;

import com.service.creditcardservice.entity.ApplicationInfo;
import com.service.creditcardservice.service.ApplicationInfoService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * ApplicationInfoController
 *
 * @author Prithvi
 */
@Validated
@RestController
@RequestMapping("/service/applicationinfo/")
public class ApplicationInfoController {

    private final Logger logger = LoggerFactory.getLogger(ApplicationInfoController.class);

    @Autowired
    private ApplicationInfoService applicationInfoService;

    /**
     * Controller Method to add {@link ApplicationInfo}
     *
     * @param applicationInfo {@link ApplicationInfo} to be saved
     * @return ApplicationInfoId of @link {@link ApplicationInfo}} Created
     * @throws Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to Create Credit Request")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created credit card Request")
    })
    @PostMapping
    public ResponseEntity<Integer> createApplicationInfo(
        @Valid @RequestBody ApplicationInfo applicationInfo) throws Exception {

        logger.info(LogMarker.ENTRY, "Creating ApplicationInfo");

        ApplicationInfo application = applicationInfoService.createApplicationInfo(applicationInfo);

        logger.info(LogMarker.EXIT, "Created used with id {}", application.getApplicationId());

        return new ResponseEntity<Integer>(application.getApplicationId(), HttpStatus.CREATED);

    }

    /**
     * Method to Update {@link ApplicationInfo}
     *
     * @param applicationInfo value for Update {@link ApplicationInfo}
     * @return Updated {@link ApplicationInfo}
     * @throws Exception Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to Update Credit Request")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Updated credit card Request")
    })
    @PutMapping
    public ResponseEntity<Integer> updateApplicationInfo(
        @Valid @RequestBody ApplicationInfo applicationInfo) throws Exception {

        logger.info(LogMarker.ENTRY, "Updating ApplicationInfo with Id {}", applicationInfo.getApplicationId());

        ApplicationInfo application = applicationInfoService.updateApplicationInfo(applicationInfo);

        logger.info(LogMarker.EXIT, "Updated ApplicationInfo with ID {}", application.getApplicationId());

        return new ResponseEntity<Integer>(application.getApplicationId(), HttpStatus.OK);
    }

    /**
     * Method to update the {@link ApplicationInfo} status
     *
     * @param userId value to get user details {@link Integer}
     * @param applicationInfoId value to get {@link ApplicationInfo}
     * @param status to update application {@link String}
     * @throws Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to update the status of the application")
    @GetMapping("status")
    public String updateStatusById(@RequestParam int userId,
        @RequestParam int applicationInfoId, @RequestParam String status) throws Exception {

        logger.info(LogMarker.ENTRY, "Method to update application status"
            + " {} for ApplicationInfo Id {}", status, applicationInfoId);

        String statusMessage = applicationInfoService.
            updateStatusById(userId, applicationInfoId, status);

        logger.info(LogMarker.EXIT, "Updated status for application id {}", applicationInfoId);
        return statusMessage;
    }

    /**
     * Method to Retrieve List of {@link ApplicationInfo}
     *
     * @param status values of application status {@link String}
     * @return List of {@link ApplicationInfo}
     * @throws Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to retrieve all the applications based on the status")
    @PostMapping("all")
    public List<ApplicationInfo> getAllApplicationInfo(String status) throws Exception {

        logger.info(LogMarker.ENTRY, "Retrieving All ApplicationInfo");

        List<ApplicationInfo> applicationInfoList = applicationInfoService.getAllApplicationInfo(status);

        logger.info(LogMarker.EXIT, "Retrieved {} ApplicationInfo", applicationInfoList.size());

        return applicationInfoList;
    }

    /**
     * Method to Retrieve {@link ApplicationInfo}
     *
     * @param applicationInfoId value for retrieving {@link ApplicationInfo}
     * @return {@link ApplicationInfo}
     * @throws Exception to be thrown on Failure
     */
    @ApiOperation(value = "Method to retrieve application by applicationId")
    @GetMapping
    public Optional<ApplicationInfo> getApplicationInfoById(
        @RequestParam int applicationInfoId) throws Exception {

        logger.info(LogMarker.ENTRY, "Retrieve ApplicationInfo with id : {}", applicationInfoId);

        Optional<ApplicationInfo> applicationInfo =
            applicationInfoService.getApplicationInfoById(applicationInfoId);

        logger.info(LogMarker.EXIT, "Retrieved {} ApplicationInfo", applicationInfoId);
        return applicationInfo;
    }
}

