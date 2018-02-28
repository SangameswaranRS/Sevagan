package com.example.sangameswaran.sevagan.Entities;

import com.android.volley.VolleyError;

/**
 * Created by Sangameswaran on 28-02-2018.
 */

public class DonorRegistrationEntity {
    String name;
    String age;
    int gender;
    String email;
    String password;
    String phone;
    String address;
    String location;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    String weight;
    int bloodgroup,period;

    public DonorRegistrationEntity() {
    }

    public DonorRegistrationEntity(String name, String age, int gender, String email, String password, String phone, String address, String location, int bloodgroup, int period) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.location = location;
        this.bloodgroup = bloodgroup;
        this.period = period;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(int bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public interface SevaganRestClientInterface{
        public void onRegisterEntitySubmit(DonorRegistrationActualEntity entity, VolleyError error);
    }
}
