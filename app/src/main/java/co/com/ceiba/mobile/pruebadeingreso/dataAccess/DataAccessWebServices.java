package co.com.ceiba.mobile.pruebadeingreso.dataAccess;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.contracts.IDataAccessManager;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
* DataAccessWebServices
* Se encarga de consumir el webrservice
* */
public class DataAccessWebServices implements IDataAccessManager {

    public DataAccessWebServices() {
    }

    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = null;
        String urlGetUsers = Endpoints.URL_BASE+Endpoints.GET_USERS;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                            .url(urlGetUsers)
                            .build();

        Response responses = null;
        try {
            responses = client.newCall(request).execute();
            String jsonData = responses.body().string();

            //Se obtienen todos los usuarios
            User [] users = new Gson().fromJson(jsonData,User[].class);
            //Genero el resultado a partir del arreglo obtenido por del webservice
            allUsers= Arrays.asList(users);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return allUsers;
    }

    @Override
    public List<Post> getPostByUser(int userId) {
        return null;
    }
}
