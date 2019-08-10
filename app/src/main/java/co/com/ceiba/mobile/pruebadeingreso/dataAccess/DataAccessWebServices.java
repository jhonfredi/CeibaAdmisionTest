package co.com.ceiba.mobile.pruebadeingreso.dataAccess;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IDataAccessManager;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.PostEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.UserEntity;

public class DataAccessWebServices implements IDataAccessManager {


    @Override
    public List<UserEntity> getAllUsers() {
        return null;
    }

    @Override
    public List<PostEntity> getPostByUser(int userId) {
        return null;
    }
}
