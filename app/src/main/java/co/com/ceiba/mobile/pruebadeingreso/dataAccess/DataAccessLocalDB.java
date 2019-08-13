package co.com.ceiba.mobile.pruebadeingreso.dataAccess;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IDataAccessManager;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.PostEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.UserEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataMapper.Mapper;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;
import io.realm.Realm;
import io.realm.RealmResults;

public class DataAccessLocalDB implements IDataAccessManager {

    private Realm realm;

    @Inject
    public DataAccessLocalDB() {
        this.realm=Realm.getDefaultInstance();
    }

    /*
    * getAllUsers
    * Obtiene todos los usuarios de la base de datos local (cache)
    * en caso de ser la primera vez que se consulta no habria caché
    * y retorna nulo
    * */
    @Override
    public List<User> getAllUsers() {

        ArrayList<UserEntity> usersEntity = new ArrayList<>();
        RealmResults<UserEntity> results= realm.
                                        where(UserEntity.class)
                                        .findAll();
        if(results.size()==0){
            return  null;
        }else{
            usersEntity.addAll(realm.copyFromRealm(results));
        }
        //No deberia de acceder al Mapper desde acá creo yo
        //pero no veo otra forma, ya que si retorno la lista de
        //UserEntity deberia cambiar la interface IDataAccessManager
        //Pero no quedaria consistente con el retorno de
        //la de  obtener usuarios del web services
        return Mapper.mappUserEntityToUser(usersEntity);
    }

    /*
     * getPostByUser
     * Obtiene todos los post de un usuario de la base de datos local (cache)
     * en caso de ser la primera vez que se consulta no habria caché
     * y retorna nulo
     * */
    @Override
    public List<Post> getPostByUser(int userId) {

        ArrayList<PostEntity> postEntities = new ArrayList<>();
        RealmResults<PostEntity> results= realm.
                where(PostEntity.class)
                .equalTo("userId",userId)
                .findAll();
        if(results.size()==0){
            return  null;
        }else{
            postEntities.addAll(realm.copyFromRealm(results));
        }

        return Mapper.mappPostEntityToPost(postEntities);
    }

    /*
    * saveUsersCache
    * realiza un insert masivo a la bd local de los usuarios
    * */
    public boolean saveUsersCache(List<UserEntity> users) {

        try {
            realm.beginTransaction();
            realm.insertOrUpdate(users);

            realm.commitTransaction();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     * savePostByUserCache
     * realiza un insert masivo a la bd local de los post
     * */
    public boolean savePostUserCache(List<PostEntity> post) {

        try {
            realm.beginTransaction();
            realm.insertOrUpdate(post);
            realm.commitTransaction();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }
}

