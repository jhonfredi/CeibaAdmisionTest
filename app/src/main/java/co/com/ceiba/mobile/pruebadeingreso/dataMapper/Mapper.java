package co.com.ceiba.mobile.pruebadeingreso.dataMapper;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.PostEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.UserEntity;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;

public class Mapper {

    /*
    * mappUserToUserEntity
    * Mapea un listado de User a UserEntity
    * */
    public static List<UserEntity> mappUserToUserEntity(List<User> users){

        ArrayList<UserEntity> usersEntity= new ArrayList<>();

        for(int i=0;i<users.size();i++){
            User user=users.get(i);
            String jsonUser= user.toJson();
            UserEntity userEntity= UserEntity.fromGson(jsonUser);
            usersEntity.add(userEntity);
        }

        return usersEntity;
    }
    /*
      mappUserEntityToUser
      Mapea un listado de UserEntity a User
    */
    public static List<User> mappUserEntityToUser(List<UserEntity> usersEntity){

        ArrayList<User> users= new ArrayList<>();

        for(int i=0;i<usersEntity.size();i++){
            UserEntity user=usersEntity.get(i);
            String jsonUser= user.toJson();

            users.add(User.fromGson(jsonUser));
        }
        return users;
    }

    /*
     mappPostToPostEntity
     Mapea un listado de Post a PostEntity
   */
    public static List<PostEntity> mappPostToPostEntity(List<Post> post){

        ArrayList<PostEntity> postEntities= new ArrayList<>();

        for(int i=0;i<post.size();i++){
            Post postItem=post.get(i);
            String jsonPost= postItem.toJson();
            postEntities.add(PostEntity.fromGson(jsonPost));
        }
        return postEntities;
    }

    /*
     mappPostEntityToPost
     Mapea un listado de PostEntity a Post
   */
    public static List<Post> mappPostEntityToPost(List<PostEntity> postEntities){

        ArrayList<Post> post= new ArrayList<>();

        for(int i=0;i<postEntities.size();i++){
            PostEntity postEntity=postEntities.get(i);
            String jsonPost= postEntity.toJson();
            post.add(Post.fromGson(jsonPost));
        }
        return post;
    }
}
