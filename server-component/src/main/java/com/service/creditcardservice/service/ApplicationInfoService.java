package com.service.creditcardservice.service;

import com.service.creditcardservice.entity.ApplicationInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Service class for ApplicationInfo Service
 */
@Component
public interface ApplicationInfoService {

    /**
     * Controller Method to add {@link ApplicationInfo}
     *
     * @param applicationInfo {@link ApplicationInfo} to be saved
     * @return ApplicationInfoId of @link {@link ApplicationInfo}} Created
     * @throws Exception Exception to be thrown on Failure
     */
    ApplicationInfo createApplicationInfo(ApplicationInfo applicationInfo) throws Exception;

    /**
     * Method to Update {@link ApplicationInfo}
     *
     * @param applicationInfo value for Update {@link ApplicationInfo}
     * @return Updated {@link ApplicationInfo}
     * @throws Exception Exception to be thrown on Failure
     */
    ApplicationInfo updateApplicationInfo(ApplicationInfo applicationInfo) throws Exception;

    /**
     * Method to update the {@link ApplicationInfo} status
     *
     * @param userId value to get user details {@link Integer}
     * @param applicationInfoId value to get {@link ApplicationInfo}
     * @param status to update application
     * @throws Exception Exception to be thrown on Failure
     */
    String updateStatusById(int userId, int applicationInfoId, String status) throws Exception;

    /**
     * Method to Retrieve List of {@link ApplicationInfo}
     *
     * @param status values of application status {@link String}
     * @return List of {@link ApplicationInfo}
     * @throws Exception Exception to be thrown on Failure
     */
    List<ApplicationInfo> getAllApplicationInfo(String status) throws Exception;

    /**
     * Method to Retrieve {@link ApplicationInfo}
     *
     * @param ApplicationInfoId value for retrieving {@link ApplicationInfo}
     * @return {@link ApplicationInfo}
     * @throws Exception Exception to be thrown on Failure
     */
    Optional<ApplicationInfo> getApplicationInfoById(@RequestParam int ApplicationInfoId) throws Exception;
}

