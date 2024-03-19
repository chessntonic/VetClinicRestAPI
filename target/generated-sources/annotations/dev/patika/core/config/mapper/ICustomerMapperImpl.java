package dev.patika.core.config.mapper;

import dev.patika.dto.request.CustomerRequest;
import dev.patika.dto.response.global.GlobalAnimalResponse;
import dev.patika.dto.response.standard.CustomerResponse;
import dev.patika.entity.Animal;
import dev.patika.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public Customer asEntity(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( request.getName() );
        customer.setPhone( request.getPhone() );
        customer.setMail( request.getMail() );
        customer.setAddress( request.getAddress() );
        customer.setCity( request.getCity() );

        return customer;
    }

    @Override
    public CustomerResponse asOutput(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId( customer.getId() );
        customerResponse.setName( customer.getName() );
        customerResponse.setPhone( customer.getPhone() );
        customerResponse.setMail( customer.getMail() );
        customerResponse.setAddress( customer.getAddress() );
        customerResponse.setCity( customer.getCity() );
        customerResponse.setAnimalList( animalListToGlobalAnimalResponseList( customer.getAnimalList() ) );

        return customerResponse;
    }

    @Override
    public List<CustomerResponse> asOutput(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerResponse> list = new ArrayList<CustomerResponse>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( asOutput( customer ) );
        }

        return list;
    }

    @Override
    public void update(Customer entity, CustomerRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setName( request.getName() );
        entity.setPhone( request.getPhone() );
        entity.setMail( request.getMail() );
        entity.setAddress( request.getAddress() );
        entity.setCity( request.getCity() );
    }

    protected GlobalAnimalResponse animalToGlobalAnimalResponse(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        GlobalAnimalResponse globalAnimalResponse = new GlobalAnimalResponse();

        globalAnimalResponse.setId( animal.getId() );
        globalAnimalResponse.setName( animal.getName() );

        return globalAnimalResponse;
    }

    protected List<GlobalAnimalResponse> animalListToGlobalAnimalResponseList(List<Animal> list) {
        if ( list == null ) {
            return null;
        }

        List<GlobalAnimalResponse> list1 = new ArrayList<GlobalAnimalResponse>( list.size() );
        for ( Animal animal : list ) {
            list1.add( animalToGlobalAnimalResponse( animal ) );
        }

        return list1;
    }
}
