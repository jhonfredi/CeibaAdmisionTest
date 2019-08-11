package co.com.ceiba.mobile.pruebadeingreso.app;

import android.app.Application;
import java.util.concurrent.atomic.AtomicInteger;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseApplication extends Application{

    public static AtomicInteger CityId=new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        setUpConfiguration();
        Realm realm = Realm.getDefaultInstance();
        realm.close();
    }

    private void setUpConfiguration(){
        Realm.init(this);
        RealmConfiguration config=new RealmConfiguration.Builder().
                deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }
}
