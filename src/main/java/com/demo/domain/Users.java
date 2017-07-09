package com.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private int cardExpirationMonth;

    @Column(nullable = false)
    private int cardExpirationYear;

    @Column(nullable = false)
    private String cardNameOnCard;

    @Column(nullable = false)
    private int flightId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public void setCardExpirationMonth(int cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public int getCardExpirationYear() {
        return cardExpirationYear;
    }

    public void setCardExpirationYear(int cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }

    public String getCardNameOnCard() {
        return cardNameOnCard;
    }

    public void setCardNameOnCard(String cardNameOnCard) {
        this.cardNameOnCard = cardNameOnCard;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
