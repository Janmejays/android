package com.example.janmejay.meete.helper;


public class User {
    private String name;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public User(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }


    public User() {
    }




}
