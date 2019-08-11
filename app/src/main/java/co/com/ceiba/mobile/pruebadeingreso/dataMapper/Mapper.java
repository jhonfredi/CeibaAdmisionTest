package co.com.ceiba.mobile.pruebadeingreso.dataMapper;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.GeoEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.UserEntity;
import co.com.ceiba.mobile.pruebadeingreso.model.Address;
import co.com.ceiba.mobile.pruebadeingreso.model.Geo;
import co.com.ceiba.mobile.pruebadeingreso.model.User;

public class Mapper {


    public List<UserEntity> mappUserToUserEntity(List<User> users){

        ArrayList<UserEntity> usersEntity= new ArrayList<>();

        for(int i=0;i<users.size();i++){
            User user=users.get(i);

            String jsonUser= new Gson().toJson(user);
            UserEntity userEntity= new Gson().fromJson(jsonUser,UserEntity.class);
            usersEntity.add(userEntity);
        }

        return usersEntity;

    }
}
