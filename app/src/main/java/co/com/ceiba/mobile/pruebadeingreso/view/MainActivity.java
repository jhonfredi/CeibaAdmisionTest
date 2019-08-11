package co.com.ceiba.mobile.pruebadeingreso.view;

import android.app.Activity;
import android.os.Bundle;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.configuration.ThreadPolicy;
import co.com.ceiba.mobile.pruebadeingreso.contracts.IDataAccessManager;
import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessWebServices;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establecemos la politica de hilos
        ThreadPolicy.permitAll();

        IDataAccessManager dataAccessManager= new DataAccessWebServices();

        dataAccessManager.getAllUsers();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


}