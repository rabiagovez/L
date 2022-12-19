package com.example.l;

public class Users {

    private String memberName;
    private String surname;
    private String membershipDate;
    private String memberMail;
    private String memberPhone;


    public Users(String memberName, String membershipDate, String memberMail, String memberPhone){
        this.memberName = memberName;
        this.membershipDate = membershipDate;
        this.memberMail = memberMail;
        this.memberPhone = memberPhone;
        this.surname = surname;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(String membershipDate) {
        this.membershipDate = membershipDate;
    }

    public String getMemberMail() {
        return memberMail;
    }

    public void setMemberMail(String memberMail) {
        this.memberMail = memberMail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
