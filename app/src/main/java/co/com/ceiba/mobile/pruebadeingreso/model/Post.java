package co.com.ceiba.mobile.pruebadeingreso.model;

import com.google.gson.Gson;

import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.PostEntity;

public class Post {

    public Integer userId;
    public Integer id;
    public String title;
    public String body;


    public Post(Integer userId, Integer id, String title, String body) {
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

    public String toJson(){
        return new Gson().toJson(this);
    }

    public static Post fromGson(String json){
        return new Gson().fromJson(json, Post.class);
    }
}
