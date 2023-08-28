package com.service.creditcardservice.repository;

import com.service.creditcardservice.entity.ApplicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationInfoRepository extends JpaRepository<ApplicationInfo, Integer>,
    CrudRepository<ApplicationInfo, Integer> {

    /**
     * @param applicationId
     * @param applicationStatus
     */
    @Modifying
    @Query("UPDATE ApplicationInfo ai "
        + "SET ai.applicationStatus = :applicationStatus "
        + "WHERE ai.applicationId = :applicationId")
    void updateApplicationStatusByApplicationId(
        @Param(value = "applicationId") int applicationId,
        @Param(value = "applicationStatus") String applicationStatus);

    /**
     * @param applicationStatus
     * @return
     */
    @Query("SELECT ai "
        + "FROM ApplicationInfo ai "
        + "WHERE ai.applicationStatus = :applicationStatus ")
    List<ApplicationInfo> getApplicationListByApplicationStatus(
        @Param(value = "applicationStatus") String applicationStatus);

}
