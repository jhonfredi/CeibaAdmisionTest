package co.com.ceiba.mobile.pruebadeingreso.dataAccess;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IDataAccessManager;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;

public class DataAccessLocalDB implements IDataAccessManager {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<Post> getPostByUser(int userId) {
        return null;
    }
}

