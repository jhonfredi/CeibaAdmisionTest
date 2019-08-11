package co.com.ceiba.mobile.pruebadeingreso.configuration;

import android.os.StrictMode;

public class ThreadPolicy {

    /*
     *Politica de conexión
     * Aunque no es recomendable hacer peticiones a red desde el hilo principal
     * debido a que es una consulta pequeña la hacemos en el hilo pricipal,
     * para ello debemos agregar dicha politica
     *
     * */
    public static void permitAll(){

        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}
