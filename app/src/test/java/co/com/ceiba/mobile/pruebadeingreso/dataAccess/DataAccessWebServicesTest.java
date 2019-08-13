package co.com.ceiba.mobile.pruebadeingreso.dataAccess;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;

import static org.junit.Assert.*;

/*
* Pruebas unitarias para el webservices
* se utilizará el patron AAA
*
* - Arrange (Organizar/Inicializa) =>
* inicializa los objetos y establece los valores de los datos
* que vamos a utilizar en el Test que lo contiene.
* - Act (Actuar) => realiza la llamada al método
* a probar con los parámetros preparados para tal fin.
* - Assert (Confirmar/Comprobar) => comprueba que el método
* de pruebas ejecutado se comporta tal y como
* teníamos previsto que lo hiciera.
*
* */
public class DataAccessWebServicesTest {

    private DataAccessWebServices dataAccessWebServices;

    @Before
    public void setUp() throws Exception {
        dataAccessWebServices = new DataAccessWebServices();
    }

    @Test
    public void getAllUsers() {

        //Arrange
        int totalExpectedUsers=10;
        List<User> users;

        //Act
        users = dataAccessWebServices.getAllUsers();

        //Assert
        assertEquals(totalExpectedUsers,users.size());
    }

    @Test
    public void getFirstUserName() {

        //Arrange
        List<User> users;
        String userName="Leanne Graham";

        //Act
        users = dataAccessWebServices.getAllUsers();

        //Assert
        assertEquals(userName,users.get(0).getName());
    }

    @Test
    public void getPostByUser() {

        //Arrange
        int totalExpectedPost=10;
        List<Post> post;

        //Act
        post = dataAccessWebServices.getPostByUser(1);

        //Assert
        assertEquals(totalExpectedPost,post.size());
    }


    @Test
    public void getLastPostTitle() {

        //Arrange
        String postTitle="optio molestias id quia eum";
        List<Post> post;

        //Act
        post = dataAccessWebServices.getPostByUser(1);

        //Assert
        assertEquals(postTitle,post.get(post.size()-1).getTitle());
    }
}