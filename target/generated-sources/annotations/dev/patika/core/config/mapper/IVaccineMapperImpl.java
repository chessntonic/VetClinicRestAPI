package dev.patika.core.config.mapper;

import dev.patika.dto.request.VaccineRequest;
import dev.patika.dto.response.global.GlobalAnimalResponse;
import dev.patika.dto.response.standard.VaccineResponse;
import dev.patika.entity.Animal;
import dev.patika.entity.Vaccine;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IVaccineMapperImpl implements IVaccineMapper {

    @Override
    public Vaccine asEntity(VaccineRequest request) {
        if ( request == null ) {
            return null;
        }

        Vaccine vaccine = new Vaccine();

        vaccine.setName( request.getName() );
        vaccine.setCode( request.getCode() );
        vaccine.setProtectionStartDate( request.getProtectionStartDate() );
        vaccine.setProtectionFinishDate( request.getProtectionFinishDate() );
        vaccine.setAnimal( request.getAnimal() );
        vaccine.setReport( request.getReport() );

        return vaccine;
    }

    @Override
    public VaccineResponse asOutput(Vaccine vaccine) {
        if ( vaccine == null ) {
            return null;
        }

        VaccineResponse vaccineResponse = new VaccineResponse();

        vaccineResponse.setId( vaccine.getId() );
        vaccineResponse.setName( vaccine.getName() );
        vaccineResponse.setCode( vaccine.getCode() );
        vaccineResponse.setProtectionStartDate( vaccine.getProtectionStartDate() );
        vaccineResponse.setProtectionFinishDate( vaccine.getProtectionFinishDate() );
        vaccineResponse.setAnimal( animalToGlobalAnimalResponse( vaccine.getAnimal() ) );

        return vaccineResponse;
    }

    @Override
    public List<VaccineResponse> asOutput(List<Vaccine> vaccineList) {
        if ( vaccineList == null ) {
            return null;
        }

        List<VaccineResponse> list = new ArrayList<VaccineResponse>( vaccineList.size() );
        for ( Vaccine vaccine : vaccineList ) {
            list.add( asOutput( vaccine ) );
        }

        return list;
    }

    @Override
    public void update(Vaccine entity, VaccineRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setName( request.getName() );
        entity.setCode( request.getCode() );
        entity.setProtectionStartDate( request.getProtectionStartDate() );
        entity.setProtectionFinishDate( request.getProtectionFinishDate() );
        entity.setAnimal( request.getAnimal() );
        entity.setReport( request.getReport() );
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
}
