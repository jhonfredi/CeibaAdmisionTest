package co.com.ceiba.mobile.pruebadeingreso.dagger.modules;

import co.com.ceiba.mobile.pruebadeingreso.dataAccess.DataAccessWebServices;
import dagger.Module;
import dagger.Provides;

@Module
public class DataAccessWebServicesModule {

    @Provides
    DataAccessWebServices provideDataAccessWebServices(){
        return new DataAccessWebServices();
    }
}
