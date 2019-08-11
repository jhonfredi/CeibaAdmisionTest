package co.com.ceiba.mobile.pruebadeingreso.contracts;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.model.User;

public interface IUserDomain {

    List<User> getAllUsers();
    User getUserByName(String name);
}
