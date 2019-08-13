package co.com.ceiba.mobile.pruebadeingreso.domain;

import java.util.List;
import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IUserDomain;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessLocalDB;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessWebServices;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.PostEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.UserEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataMapper.Mapper;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.model.User;

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

        List<User> allUsers =null;

        allUsers = dataAccessLocalDB.getAllUsers();

        //Si no hay datos en local se consume el webservice
        if(allUsers==null){
            allUsers=dataAccessWebServices.getAllUsers();

            //Se valida que no sigan siendo null ya que pueden tener problemas de conexión
            if(allUsers!=null){
                //Al no haber datos en la db local se procede a guardarlos
                saveUsersCache(allUsers);
            }
        }
        return  allUsers;
    }

    /*
    * saveUsersCache
    * Guarda en base de datos local los usuarios obtenidos del webservices
    * */
    @Override
    public boolean saveUsersCache(List<User> users) {

        List<UserEntity> usersEntity = Mapper.mappUserToUserEntity(users);
        return dataAccessLocalDB.saveUsersCache(usersEntity);
    }

    /*
     * getPostByUser
     *
     * Obtiene el listado de todos los post de la base de datos local,
     * de un usuario, si no hay datos en local utiliza el webservice
     *
     * */
    @Override
    public List<Post> getPostByUser(int userId) {
        List<Post> postByUser =null;

        postByUser = dataAccessLocalDB.getPostByUser(userId);

        //Si no hay datos en local se consume el webservice
        if(postByUser==null) {
            postByUser = dataAccessWebServices.getPostByUser(userId);

            //Se valida que no sea nulo porque puede que no tenga acceso a la red
            if(postByUser!=null){
                //Al no haber datos en la db local se procede a guardarlos
                savePostCache(postByUser);
            }
        }
        return  postByUser;
    }

    /*
     * savePostCache
     * Guarda en base de datos local los post del usuario
     * obtenidos del webservices
     * */
    private boolean savePostCache(List<Post> postByUser) {
        List<PostEntity> postEntities = Mapper.mappPostToPostEntity(postByUser);
        return dataAccessLocalDB.savePostUserCache(postEntities);
    }

    public DataAccessWebServices getDataAccessWebServices() {
        return dataAccessWebServices;
    }

    public DataAccessLocalDB getDataAccessLocalDB() {
        return dataAccessLocalDB;
    }
}
