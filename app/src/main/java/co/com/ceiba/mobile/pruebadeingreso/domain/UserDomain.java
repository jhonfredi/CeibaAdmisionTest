package co.com.ceiba.mobile.pruebadeingreso.domain;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IUserDomain;
import co.com.ceiba.mobile.pruebadeingreso.model.User;

public class UserDomain implements IUserDomain {

    /*
    * getAllUsers
    *
    * Obtiene el listado de todos los usuarios de la base de datos local,
    * si no hay datos en local utiliza el webservice
    *
    * */
    @Override
    public List<User> getAllUsers() {

        ArrayList<User> allUsers =null;

        //Se obtiene la información de la bd local

        return null;
    }

    /*
     * getUserByName
     *
     * Obtiene un usuario por su nombre
     *
     * */
    @Override
    public User getUserByName(String name) {
        return null;
    }
}
