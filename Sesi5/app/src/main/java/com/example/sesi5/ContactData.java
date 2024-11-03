package com.example.sesi5;

public class ContactData {
    private String name, phoneNumber;

    public ContactData(String inputName, String inputNumber){
        name = inputName;
        phoneNumber = inputNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
