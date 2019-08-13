package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.common.StringUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.adapters.UserAdapter;
import co.com.ceiba.mobile.pruebadeingreso.configuration.ThreadPolicy;
import co.com.ceiba.mobile.pruebadeingreso.contracts.ViewPostListener;
import co.com.ceiba.mobile.pruebadeingreso.dagger.components.DaggerUserDomainComponent;
import co.com.ceiba.mobile.pruebadeingreso.dagger.components.UserDomainComponent;
import co.com.ceiba.mobile.pruebadeingreso.domain.UserDomain;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements ViewPostListener {

    //RecyclerView para moestrar el listado de usuarios o usuario buscado
    private RecyclerView recyclerView;
    //EditText para buscar usuarios po nombre
    private EditText etSearchUser;
    //Barra de progreso mientras se listan los usuarios
    private ProgressBar progressBar;
    //Label a mostrar cuando la lista de usuarios al buscar está vacía
    private TextView tvListIsEmtpy;
    //Listado de usuarios
    private List<User> users;
    //Adaptador de usuarios
    private  UserAdapter usersAdapter;
    //Dominio para gestion de usuarios
    private UserDomain userDomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpDefaultConfiguration();
        bindUI();
        dependencyInjection();
        listAllusers();
    }

    /*
    dependencyInjection
    * Se realiza la inyección de dependencias con dagger
    * */
    private void dependencyInjection() {

        UserDomainComponent userDomainComponent = DaggerUserDomainComponent
                .builder()
                .build();
        userDomain = userDomainComponent.getUserDomain();
    }
    /*
    * listAllusers
    * Lista todos los usuarios en el recycler view
    * */
    private void listAllusers() {

        progressBar.setVisibility(View.VISIBLE);
        users= userDomain.getAllUsers();

        //Validamos que la lista no este vacía, ya que puede ser la primera vez que consulte
        //Y no tenga acceso a internet, entonces el webservice va a retornar nulo
        if(users!=null && users.size()>0){
            recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

            usersAdapter = new UserAdapter(users, R.layout.user_list_item,this);
            recyclerView.setAdapter(usersAdapter);
            progressBar.setVisibility(View.INVISIBLE);
            //Siempre se estavblece este texto debido a que la priemra vez que entre puede
            //tener un error d econexión, y se muestra el error R.string.net_error
            tvListIsEmtpy.setText(getResources().getString(R.string.list_is_empty));
        }else{
            tvListIsEmtpy.setText(getResources().getString(R.string.net_error));
        }
    }

    private void bindUI() {
        this.recyclerView = findViewById(R.id.recyclerViewSearchResults);
        this.etSearchUser = findViewById(R.id.editTextSearch);
        this.progressBar = findViewById(R.id.progressBarId);
        this.tvListIsEmtpy = findViewById(R.id.textViewListIsEMpty);
        this.etSearchUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchUser(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    /*
    * searchUser
    * Busca en la lista de usuarios los nombres que coincidan
    * con la cadena de búsqueda y los va listando en el RecyclerView
    * */
    private void searchUser(CharSequence userName) {

        List<User> matchUsersSearch = new ArrayList<>();
        //En caso de que el nombre a buscar sea vacio se envia la lista completa de usuarios
        //Y ademas se debe establecer el recycler en visible, en caso de que la consulta anterior
        //no haya arrojado nigún usuario, y si borra y el query de busqueda es vacio no se va a mostrar
        if(userName.length()==0){
            recyclerView.setVisibility(View.VISIBLE);
            tvListIsEmtpy.setVisibility(View.INVISIBLE);
            usersAdapter.updateUsersList(users);

        }else{
            userName= userName.toString().toLowerCase();

            //Recorro la lista de usuarios en memoria y si el nombre
            //coincide lo agrego a la neuva lista del adaptador
            for(User user:users){
                //Se pasa a minúscula tanto el nombre d eusuario como el query
                if(user.getName().toLowerCase().contains(userName)){
                    matchUsersSearch.add(user);
                }
            }
            if(matchUsersSearch.size()==0){
                recyclerView.setVisibility(View.INVISIBLE);
                tvListIsEmtpy.setVisibility(View.VISIBLE);
            }else{
                recyclerView.setVisibility(View.VISIBLE);
                tvListIsEmtpy.setVisibility(View.INVISIBLE);
            }
            usersAdapter.updateUsersList(matchUsersSearch);
        }
    }

    private void setUpDefaultConfiguration() {

        //Establecemos la politica de hilos
        ThreadPolicy.permitAll();
        // Initialize Realm (just once per application)
        Realm.init(this);
    }

    /*Listener*/
    /*
    * onClickListener
    * Evento que escucha cuando se presiona sobre el botón ver publicaciones
    * */
    @Override
    public void onClickListener(User user, int position) {
        Intent intent = new Intent(MainActivity.this,PostActivity.class);
        intent.putExtra("id",user.getId());
        intent.putExtra("name",user.getName());
        intent.putExtra("phone",user.getPhone());
        intent.putExtra("email",user.getEmail());
        startActivity(intent);
    }
}