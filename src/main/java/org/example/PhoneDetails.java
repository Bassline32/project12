package org.example;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "phone_details")

public class PhoneDetails {

    private OperatorStatus operatorStatus;
    @Column(name = "region")
    private String region;
    @Column(name = "utc")
    private String utc;

}
