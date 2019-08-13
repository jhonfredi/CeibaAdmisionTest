package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.adapters.PostAdapter;
import co.com.ceiba.mobile.pruebadeingreso.dagger.components.DaggerUserDomainComponent;
import co.com.ceiba.mobile.pruebadeingreso.dagger.components.UserDomainComponent;
import co.com.ceiba.mobile.pruebadeingreso.domain.UserDomain;
import co.com.ceiba.mobile.pruebadeingreso.model.Post;

public class PostActivity extends Activity {

    //RecyclerView donde se muestra el listado de post por usuario
    private RecyclerView recyclerView;
    //Barra de progreso mientras se listan los post
    private ProgressBar progressBar;
    //Datos del usuario
    private TextView tvName, tvPhone, tvEmail;
    //TextView de error de red
    private TextView tvNetError;
    //Dominio para gestion de usuarios
    private UserDomain userDomain;
    //Adaptador de los post del usuario
    private PostAdapter postAdapter;
    //Usuario actual
    private int currentUserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Bundle bundle= getIntent().getExtras();
        String name="",phone="",email="";

        dependencyInjection();
        if(bundle!=null){
            currentUserId = bundle.getInt("id");
            name= bundle.getString("name");
            phone= bundle.getString("phone");
            email= bundle.getString("email");
        }
        bindUI(name,phone,email);
    }

    @Override
    protected void onStart() {
        listPostByUser(currentUserId);
        super.onStart();
    }

    /*
    * listPostByUser
    * Lista todos los post del usuario obtenido por parámetro
    * puede que no se visualice el progressbar al ser una petición sincrona
    * */
    private void listPostByUser(int userId) {

        List<Post> postByUser=userDomain.getPostByUser(userId);

        if(postByUser!=null){
            this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

            this.postAdapter = new PostAdapter(R.layout.post_list_item,postByUser);

            this.recyclerView.setAdapter(postAdapter);

            tvNetError.setVisibility(View.GONE);
        }else{
            tvNetError.setVisibility(View.VISIBLE);
        }
        progressBar.setVisibility(View.GONE);
    }

    private void bindUI(String name,String phone, String email) {
        this.recyclerView=findViewById(R.id.recyclerViewPostsResults);
        this.tvName  = findViewById(R.id.name);
        this.tvPhone = findViewById(R.id.phone);
        this.tvEmail = findViewById(R.id.email);
        this.tvNetError = findViewById(R.id.tvNetErrror);
        this.progressBar = findViewById(R.id.progressBarId);

        this.tvName.setText(name);
        this.tvPhone.setText(phone);
        this.tvEmail.setText(email);
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



}
