package co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities;

import io.realm.RealmObject;

public class CompanyEntity extends RealmObject {

    public String name;
    public String catchPhrase;
    public String bs;

    public CompanyEntity() {
    }

    public CompanyEntity(String name, String catchPhrase, String bs) {
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

}
