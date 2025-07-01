package com.klef.ep.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="event_table")
public class Event implements Serializable
{
    @Id
    private Long id;
    @Column(name="event_name",length=50,nullable = false)
    private String name;
    @Column(name="event_description",length=100,nullable = false)
    private String description;
    @Column(name="event_startdate",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    
    @Column(name = "event_enddate",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)

    private Date endDate;
    @Column(name="event_registrationdeadline",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)

    private Date registrationDeadline;
    @Column(name="event_venu",length=50,nullable = false)
    private String venu;
    
    @Lob
    @Column(name="event_image",nullable = false)  //Large Object (Lob)
    private byte[] image; 
    
    @Column(name="event_payment",nullable=false)
    private double payment;
    

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public String getVenu() {
        return venu;
    }

    public void setVenu(String venu) {
        this.venu = venu;        
    }

  
}