package co.com.ceiba.mobile.pruebadeingreso.dagger.components;

import co.com.ceiba.mobile.pruebadeingreso.dagger.modules.DataAccessLocalDBModule;
import co.com.ceiba.mobile.pruebadeingreso.dagger.modules.DataAccessWebServicesModule;
import co.com.ceiba.mobile.pruebadeingreso.domain.UserDomain;
import dagger.Component;

@Component(modules={
        DataAccessWebServicesModule.class,
        DataAccessLocalDBModule.class
})
public interface UserDomainComponent {

    UserDomain getUserDomain();
}
