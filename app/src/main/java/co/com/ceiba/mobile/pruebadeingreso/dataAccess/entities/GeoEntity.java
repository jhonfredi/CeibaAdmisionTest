package co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities;


import io.realm.RealmObject;

public class GeoEntity extends RealmObject {

    public String lat;
    public String lng;

    public GeoEntity() {
    }

    public GeoEntity(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
