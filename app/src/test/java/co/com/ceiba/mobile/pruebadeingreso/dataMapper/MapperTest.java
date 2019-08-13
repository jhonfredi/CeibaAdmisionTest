package co.com.ceiba.mobile.pruebadeingreso.dataMapper;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessWebServices;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.PostEntity;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.entities.UserEntity;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.model.User;

import static org.junit.Assert.*;

public class MapperTest {

    private DataAccessWebServices dataAccessWebServices;
    private Mapper mapper;
    @Before
    public void setUp() throws Exception {
        dataAccessWebServices = new DataAccessWebServices();
        mapper = new Mapper();
    }

    @Test
    public void mappUserToUserEntity() {

        //Arrange
        List<User> users;
        List<UserEntity> userEntityList;

        //Act
        users = dataAccessWebServices.getAllUsers();
        userEntityList = mapper.mappUserToUserEntity(users);

        //Assert
        assertEquals(users.get(0).getEmail(),userEntityList.get(0).getEmail());
    }

    @Test
    public void mappPostToPostEntity() {

        //Arrange
        List<Post> postList;
        List<PostEntity> postEntityList;

        //Act
        postList = dataAccessWebServices.getPostByUser(2);
        postEntityList = mapper.mappPostToPostEntity(postList);

        //Assert
        assertEquals(postList.get(0).getBody(),postEntityList.get(0).getBody());
    }
}