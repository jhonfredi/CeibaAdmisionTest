package co.com.ceiba.mobile.pruebadeingreso.contracts;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.PostEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.UserEntity;

public interface IDataAccessManager {

    List<UserEntity> getAllUsers();
    List<PostEntity> getPostByUser(int userId);
}
