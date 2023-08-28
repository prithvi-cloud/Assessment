package com.service.creditcardservice.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ApplicationInfo")
@NamedQuery(name = "ApplicationInfo.findAll", query = "SELECT ai FROM  ApplicationInfo  ai")
@Data
public class ApplicationInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "dob")
    private LocalDate applicationDate;

    @NotNull
    @Column(name = "application_status")
    private String applicationStatus;

    @NotNull
    @Column(name = "card_type")
    private String cardType;

    @Column(name = "income")
    private long income;

    @Column(name = "remarks", length = 250)
    private String remarks;
}
