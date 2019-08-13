package co.com.ceiba.mobile.pruebadeingreso.contracts;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;

public interface IUserDomain {

    List<User> getAllUsers();
    boolean saveUsersCache(List<User> users);
    List<Post> getPostByUser(int userId);
}
