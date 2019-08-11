package co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities;

import co.com.ceiba.mobile.pruebadeingreso.model.Address;
import co.com.ceiba.mobile.pruebadeingreso.model.Company;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserEntity extends RealmObject {

    public Integer id;
    public String name;
    public String username;
    public String email;
   // public Address address;
    public String phone;
    public String website;
  //  public Company company;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        //this.address = address;
        this.phone = phone;
        this.website = website;
        //this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }



}
