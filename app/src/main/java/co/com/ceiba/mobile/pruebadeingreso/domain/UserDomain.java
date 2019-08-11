package co.com.ceiba.mobile.pruebadeingreso.domain;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IUserDomain;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessLocalDB;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessWebServices;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import io.realm.Realm;

public class UserDomain implements IUserDomain {

    private DataAccessWebServices dataAccessWebServices;
    private DataAccessLocalDB dataAccessLocalDB;

    @Inject
    public UserDomain(DataAccessWebServices dataAccessWebServices, DataAccessLocalDB dataAccessLocalDB) {
        this.dataAccessWebServices = dataAccessWebServices;
        this.dataAccessLocalDB = dataAccessLocalDB;
    }

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
        return this.dataAccessWebServices.getAllUsers();
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

    @Override
    public boolean saveUsersCache(List<User> users) {

        for(int i=0;i<users.size();i++){

        }
        return false;
    }
}
