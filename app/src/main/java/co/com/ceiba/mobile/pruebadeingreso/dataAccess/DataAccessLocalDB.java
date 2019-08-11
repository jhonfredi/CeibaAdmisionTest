package co.com.ceiba.mobile.pruebadeingreso.dataAccess;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IDataAccessManager;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;
import io.realm.Realm;

public class DataAccessLocalDB implements IDataAccessManager {

    private Realm realm;

    @Inject
    public DataAccessLocalDB() {
        this.realm=Realm.getDefaultInstance();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<Post> getPostByUser(int userId) {
        return null;
    }
}

