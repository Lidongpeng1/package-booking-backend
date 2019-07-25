package com.oocl.packagebooking.entity;

import javax.persistence.*;

@Entity
public class Pakeage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String recipient;

    @Column
    private String phoneNum;

    @Column
    private Integer state;

    @Column
    private String Appointment;

    @Column
    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAppointment() {
        return Appointment;
    }

    public void setAppointment(String appointment) {
        Appointment = appointment;
    }

    public Pakeage(String recipient, String phoneNum, String weight) { //包裹入库构造函数
        this.recipient = recipient;
        this.phoneNum = phoneNum;
        this.state = 1;
        this.Appointment = "";
        this.weight = weight;
    }

    public Pakeage() {
        this.state = 1;
        this.Appointment = "";
    }
}
