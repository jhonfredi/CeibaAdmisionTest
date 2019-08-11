package co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities;

import io.realm.RealmObject;

public class PostEntity extends RealmObject {

    public Integer userId;
    public Integer id;
    public String title;
    public String body;

    public PostEntity() {
    }

    public PostEntity(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
