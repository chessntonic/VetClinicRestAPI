package dev.patika.core.config.mapper;

import dev.patika.dto.request.AvailableDateRequest;
import dev.patika.dto.response.standard.AvailableDateResponse;
import dev.patika.entity.AvailableDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IAvailableDateMapperImpl implements IAvailableDateMapper {

    @Override
    public AvailableDate asEntity(AvailableDateRequest request) {
        if ( request == null ) {
            return null;
        }

        AvailableDate availableDate = new AvailableDate();

        availableDate.setDate( request.getDate() );
        availableDate.setDoctor( request.getDoctor() );

        return availableDate;
    }

    @Override
    public AvailableDateResponse asOutput(AvailableDate availableDate) {
        if ( availableDate == null ) {
            return null;
        }

        AvailableDateResponse availableDateResponse = new AvailableDateResponse();

        availableDateResponse.setId( availableDate.getId() );
        availableDateResponse.setDate( availableDate.getDate() );
        availableDateResponse.setDoctor( availableDate.getDoctor() );

        return availableDateResponse;
    }

    @Override
    public List<AvailableDateResponse> asOutput(List<AvailableDate> availableDates) {
        if ( availableDates == null ) {
            return null;
        }

        List<AvailableDateResponse> list = new ArrayList<AvailableDateResponse>( availableDates.size() );
        for ( AvailableDate availableDate : availableDates ) {
            list.add( asOutput( availableDate ) );
        }

        return list;
    }

    @Override
    public void update(AvailableDate entity, AvailableDateRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setDate( request.getDate() );
        entity.setDoctor( request.getDoctor() );
    }
}
