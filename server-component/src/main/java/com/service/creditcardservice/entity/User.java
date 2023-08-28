package com.service.creditcardservice.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * The persistent class for the User database table.
 *
 * @author Prithvi
 */

@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM  User  u")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_no")
    private Integer phoneNo;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "user_type")
    private String userType;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "address")
    private String address;

    @Column(name = "nationality")
    private String nationality;

    @OneToMany(mappedBy = "applicationId")
    private List<ApplicationInfo> applicationInfoList;

    public User(Integer userId, String firstName, String lastName, LocalDate dob, String gender, Integer phoneNo,
        String email, String userType, String password, boolean isAdmin, String address, String nationality,
        List<ApplicationInfo> applicationInfoList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.isAdmin = isAdmin;
        this.address = address;
        this.nationality = nationality;
        this.applicationInfoList = applicationInfoList;
    }
}