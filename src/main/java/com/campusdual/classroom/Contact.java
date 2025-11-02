package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {
    private String name;
    private String lastName;
    private String phoneNumber;

    public Contact(String name, String lastname, String phoneNumber) {
        this.name = name;
        this.lastName = lastname;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return lastName;
    }

    public void setSurnames(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode(){
        String[] lastNames = this.lastName.split(" ");
        StringBuilder sb = new StringBuilder();
        String newCleanCode;

        sb.append(this.name.charAt(0));

        if (lastNames.length > 1) {
            sb.append(lastNames[0].charAt(0));
            for (int i = 1; i < lastNames.length; i++) {
                sb.append(lastNames[i]);
            }
        } else {
            sb.append(this.lastName);
        }

        newCleanCode = cleanCode(sb.toString());

        return newCleanCode;
    }

    public String cleanCode(String nameCode){
        nameCode = Normalizer.normalize(nameCode, Normalizer.Form.NFD);
        nameCode = nameCode.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        nameCode = nameCode.toLowerCase();
        return nameCode;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Action denied: you're calling yourself " + this.name + " " + this.lastName +
                " to number " + this.phoneNumber);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Dialing " + this.name + " " + this.lastName + " at number " + number);
    }

    @Override
    public void showContactDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(this.name);
        sb.append("\nLast Name: ").append(this.lastName);
        sb.append("\nPhone: ").append(this.phoneNumber);
        sb.append("\nIdentifier: ").append(getCode());

        System.out.println(sb);
    }
}
