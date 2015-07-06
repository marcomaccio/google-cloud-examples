package name.marmac.tutorials.gce;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import name.marmac.tutorials.gce.model.Customer;

import javax.inject.Named;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "CustomerProvisioning",
     version = "v1",
     namespace = @ApiNamespace(ownerDomain = "gce.tutorials.marmac.name",
                                ownerName = "gce.tutorials.marmac.name",
                                packagePath=""))
public class CustomerProvisioning {

    /**
     *
     * @param firstname
     * @param lastname
     * @return
     */
    @ApiMethod(name = "getCustomer")
    public Customer getCustomer(@Named("firstname") String firstname,
                                @Named("lastname") String lastname) {

        Customer customer = new Customer();

        customer.setFirstname(firstname);
        customer.setLastname(lastname);

        return customer;
    }


}
