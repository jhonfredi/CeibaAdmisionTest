package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.configuration.ThreadPolicy;
import co.com.ceiba.mobile.pruebadeingreso.dagger.components.DaggerUserDomainComponent;
import co.com.ceiba.mobile.pruebadeingreso.dagger.components.UserDomainComponent;
import co.com.ceiba.mobile.pruebadeingreso.domain.UserDomain;
import co.com.ceiba.mobile.pruebadeingreso.model.User;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpDefaultConfiguration();

        UserDomainComponent userDomainComponent = DaggerUserDomainComponent
                .builder()
                .build();

        UserDomain userDomain=userDomainComponent.getUserDomain();

        List<User> users= userDomain.getAllUsers();



    }

    private void setUpDefaultConfiguration() {

        //Establecemos la politica de hilos
        ThreadPolicy.permitAll();
        // Initialize Realm (just once per application)
        Realm.init(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}