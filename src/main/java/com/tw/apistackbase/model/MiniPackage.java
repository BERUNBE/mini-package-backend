package com.tw.apistackbase.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MiniPackage {
    @Id
    private Long packageNumber;

    private String receiver;

    private Long phone;

    private String status;

    private String bookingTime;

    public Long getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(long packageNumber) {
        this.packageNumber = packageNumber;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }
}
