package com.example.aws.myblogapptn.Models;

public class User {
    public String  name , phone, blood, add,pickedImgUri;

    public User() {
    }

    public User(String name, String phone, String blood, String add, String pickedImgUri) {
        this.name = name;
        this.phone = phone;
        this.blood = blood;
        this.add = add;
        this.pickedImgUri = pickedImgUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPickedImgUri() {
        return pickedImgUri;
    }

    public void setPickedImgUri(String pickedImgUri) {
        this.pickedImgUri = pickedImgUri;
    }
}

