package co.com.ceiba.mobile.pruebadeingreso.dagger.modules;

import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessLocalDB;
import dagger.Module;
import dagger.Provides;


@Module
public class DataAccessLocalDBModule {

    @Provides
    DataAccessLocalDB provideDataAccessLocalDB(){
        return new DataAccessLocalDB();
    }
}
