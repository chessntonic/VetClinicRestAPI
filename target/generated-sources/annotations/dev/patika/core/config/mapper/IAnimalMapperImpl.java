package dev.patika.core.config.mapper;

import dev.patika.dto.request.AnimalRequest;
import dev.patika.dto.response.global.GlobalCustomerResponse;
import dev.patika.dto.response.standard.AnimalResponse;
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
public class IAnimalMapperImpl implements IAnimalMapper {

    @Override
    public Animal asEntity(AnimalRequest request) {
        if ( request == null ) {
            return null;
        }

        Animal animal = new Animal();

        animal.setName( request.getName() );
        animal.setSpecies( request.getSpecies() );
        animal.setBreed( request.getBreed() );
        animal.setGender( request.getGender() );
        animal.setColor( request.getColor() );
        animal.setDateOfBirth( request.getDateOfBirth() );
        animal.setCustomer( request.getCustomer() );

        return animal;
    }

    @Override
    public AnimalResponse asOutput(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        AnimalResponse animalResponse = new AnimalResponse();

        animalResponse.setId( animal.getId() );
        animalResponse.setName( animal.getName() );
        animalResponse.setSpecies( animal.getSpecies() );
        animalResponse.setBreed( animal.getBreed() );
        animalResponse.setGender( animal.getGender() );
        animalResponse.setColor( animal.getColor() );
        animalResponse.setDateOfBirth( animal.getDateOfBirth() );
        animalResponse.setCustomer( customerToGlobalCustomerResponse( animal.getCustomer() ) );

        return animalResponse;
    }

    @Override
    public List<AnimalResponse> asOutput(List<Animal> animals) {
        if ( animals == null ) {
            return null;
        }

        List<AnimalResponse> list = new ArrayList<AnimalResponse>( animals.size() );
        for ( Animal animal : animals ) {
            list.add( asOutput( animal ) );
        }

        return list;
    }

    @Override
    public void update(Animal entity, AnimalRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setName( request.getName() );
        entity.setSpecies( request.getSpecies() );
        entity.setBreed( request.getBreed() );
        entity.setGender( request.getGender() );
        entity.setColor( request.getColor() );
        entity.setDateOfBirth( request.getDateOfBirth() );
        entity.setCustomer( request.getCustomer() );
    }

    protected GlobalCustomerResponse customerToGlobalCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        GlobalCustomerResponse globalCustomerResponse = new GlobalCustomerResponse();

        globalCustomerResponse.setId( customer.getId() );
        globalCustomerResponse.setName( customer.getName() );

        return globalCustomerResponse;
    }
}
