package name.marmac.tutorials.gce;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.NotFoundException;
import name.marmac.tutorials.gce.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
@Api(name = "customerProvisioning",
        version = "v1",
        description = "Customer Provisioning",
        scopes = {Constants.EMAIL_SCOPE},
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE},
        namespace = @ApiNamespace(ownerDomain = "gce.tutorials.marmac.name",
                                    ownerName = "gce.tutorials.marmac.name",
                                    packagePath=""))
public class CustomerProvisioning {

    private static final transient Logger LOGGER = LoggerFactory.getLogger(CustomerProvisioning.class);

    private static final List<Customer> customers = new ArrayList<Customer>();

    /**
     *
     * @param firstname
     * @param lastname
     * @return
     */
    @ApiMethod(name = "getCustomer", httpMethod = "GET")
    public Customer getCustomer(@Named("firstname") String firstname,
                                @Named("lastname") String lastname) throws NotFoundException {

        LOGGER.debug("Method getCustomer has been called");
        Customer customer = new Customer();

        customer.setFirstname(firstname);
        customer.setLastname(lastname);

        LOGGER.debug("returning " + customer.toString());
        return customer;
    }

    /**
     *
     * @return
     */
    @ApiMethod(name = "getCustomers", httpMethod = "GET")
    public List<Customer> listCustomer() {

        LOGGER.debug("Method getCustomers has been called");

        return customers;
    }


    @ApiMethod(name = "addCustomer", httpMethod = "POST")
    public Customer addCustomer(@Named("firstname") String firstname,
                                @Named("lastname") String lastname,
                                @Named("customerId") String customerId) throws NotFoundException {

        LOGGER.debug("Method addCustomer has been called");

        Customer customer = new Customer();
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setCustomerId(customerId);
        return customer;

    }

    /**
     *
     * @param id
     * @throws NotFoundException
     */
    @ApiMethod(name = "deleteCustomer", httpMethod = "DELETE")
    public void deleteCustomer(@Named("id") Long id) throws NotFoundException {
        LOGGER.debug("Method deleteCustomer has been called");

    }
}
