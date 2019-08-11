package co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities;


import io.realm.RealmObject;

public class AddressEntity extends RealmObject {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public GeoEntity geo;

    public AddressEntity() {
    }

    public AddressEntity(String street, String suite, String city, String zipcode, GeoEntity geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public GeoEntity getGeo() {
        return geo;
    }

    public void setGeo(GeoEntity geo) {
        this.geo = geo;
    }

}
