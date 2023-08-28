package com.service.creditcardservice.serviceimpl;

import com.service.creditcardservice.entity.ApplicationInfo;
import com.service.creditcardservice.entity.User;
import com.service.creditcardservice.repository.ApplicationInfoRepository;
import com.service.creditcardservice.repository.UserRepository;
import com.service.creditcardservice.service.ApplicationInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Validated
@Component
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    private final Logger logger = LoggerFactory.getLogger(ApplicationInfoServiceImpl.class);

    @Autowired
    private ApplicationInfoRepository repository;

    @Autowired
    private UserRepository userRepository;

    // TODO: Move below properties to application properties file

    private final static String PROTOCAL = "smtp";

    private final static Integer PORT = 587;

    private final static String HOST = "smtp.gmail.com";

    private final static String USER_NAME = "itotestmail01@gmail.com";

    private final static String PASSWORD = "ito123456";

    private final static String PENDING_STATUS = "pending";

    /**
     * Controller Method to add {@link ApplicationInfo}
     *
     * @param applicationInfo {@link ApplicationInfo} to be saved
     * @return ApplicationInfoId of @link {@link ApplicationInfo}} Created
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public ApplicationInfo createApplicationInfo(
        ApplicationInfo applicationInfo) throws Exception {

        logger.info("Method to create a new application ");

        ApplicationInfo application = repository.save(applicationInfo);

        logger.info("Created application #{} ", application.getApplicationId());
        return application;
    }

    /**
     * Method to Update {@link ApplicationInfo}
     *
     * @param applicationInfo value for Update {@link ApplicationInfo}
     * @return Updated {@link ApplicationInfo}
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public ApplicationInfo updateApplicationInfo(
        ApplicationInfo applicationInfo) throws Exception {

        logger.info("Method to update the application {}", applicationInfo.getApplicationId());

        ApplicationInfo application = repository.save(applicationInfo);
        logger.info("Updated application details #{}", application.getApplicationId());
        return application;
    }

    /**
     * Method to update the {@link ApplicationInfo} status
     *
     * @param userId value to get user details {@link Integer}
     * @param applicationInfoId value to get {@link ApplicationInfo}
     * @param status to update application
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public String updateStatusById(int userId, int applicationInfoId, String status)
        throws Exception {

        logger.info("Method to update the application status {} "
            + "for application #{}", status, applicationInfoId);

        repository.updateApplicationStatusByApplicationId(applicationInfoId, status);

        Optional<User> user = userRepository.findByUserId(userId);

        if (user.isPresent()) {
            this.sendNotificationToUser(user.get(), status, applicationInfoId);
        }
        logger.info("Updated the status for application #{}", applicationInfoId);
        return null;
    }

    /**
     * Method to Retrieve List of {@link ApplicationInfo}
     *
     * @return List of {@link ApplicationInfo}
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    @Transactional
    public List<ApplicationInfo> getAllApplicationInfo() throws Exception {

        logger.info("Method to retrieve all application");

        List<ApplicationInfo> applicationInfoList = null;
        repository.getApplicationListByApplicationStatus(PENDING_STATUS);

        logger.info("Retrieved application list of {} records", applicationInfoList.size());
        return applicationInfoList;
    }

    /**
     * Method to Retrieve {@link ApplicationInfo}
     *
     * @param applicationInfoId value for retrieving {@link ApplicationInfo}
     * @return {@link ApplicationInfo}
     * @throws Exception Exception to be thrown on Failure
     */
    @Override
    public Optional<ApplicationInfo> getApplicationInfoById(int applicationInfoId) throws Exception {

        logger.info("Method to retrieve applicationInfo by {} id", applicationInfoId);

        Optional<ApplicationInfo> applicationInfo = repository.findById(applicationInfoId);

        if (!applicationInfo.isPresent()) {
            throw new Exception("Application not found");
        }
        logger.info("Retrieved application info");

        return applicationInfo;
    }

    /**
     * Method to create a session for sending mail
     *
     * @return {@link Session}
     */
    private Session setProperties() {

        logger.info("To Create Mail Mime Properties.");

        Properties props = new Properties();
        props.put("mail.smtp.host", HOST); // SMTP Host
        props.put("mail.smtp.port", PORT); // TLS Port
        props.put("mail.smtp.auth", "true"); // enable authentication
        props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
        props.put("mail.mime.multipart.allowempty", "true");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.protocol", PROTOCAL);

        logger.info("Created Mail Mime Properties.");

        return Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER_NAME, PASSWORD);
                }
            });

    }

    /**
     * Method to send notification to user
     *
     * @param status Application Status
     * @param user {@link User}
     */
    @Async
    private void sendNotificationToUser(User user, String status, int applicationNumber)
        throws MessagingException, UnsupportedEncodingException {

        logger.info("Method to send notification to customer {}", user.getFirstName());

        MimeMessage mimeMessage = new MimeMessage(this.setProperties());
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        MimeMultipart mimeMultiPart = new MimeMultipart();
        MimeBodyPart emailBody = new MimeBodyPart();

        // Setting email from & to
        messageHelper.setFrom(new InternetAddress(USER_NAME, "ABC-Bancking"));
        messageHelper.setTo(user.getEmail());

        // Adding email subject & Email content
        String subject = "Status update for ApplicationNo : #" + applicationNumber;
        messageHelper.setSubject(subject);

        String emailBodyContent = "Good day! \\n Your Application #" + applicationNumber
            + " for credit card has been " + status;

        emailBody.setContent(emailBodyContent, "text/plain");
        mimeMultiPart.addBodyPart(emailBody);

        // Sending mail
        logger.info("Sending...");
        Transport.send(mimeMessage);
        logger.info("Sent email to the customer {}", user.getFirstName());

    }
}
