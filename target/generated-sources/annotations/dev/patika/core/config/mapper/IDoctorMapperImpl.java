package dev.patika.core.config.mapper;

import dev.patika.dto.request.DoctorRequest;
import dev.patika.dto.response.global.GlobalAvailableDateResponse;
import dev.patika.dto.response.standard.DoctorResponse;
import dev.patika.entity.AvailableDate;
import dev.patika.entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IDoctorMapperImpl implements IDoctorMapper {

    @Override
    public Doctor asEntity(DoctorRequest request) {
        if ( request == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setName( request.getName() );
        doctor.setPhone( request.getPhone() );
        doctor.setMail( request.getMail() );
        doctor.setAddress( request.getAddress() );
        doctor.setCity( request.getCity() );

        return doctor;
    }

    @Override
    public DoctorResponse asOutput(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorResponse doctorResponse = new DoctorResponse();

        doctorResponse.setId( doctor.getId() );
        doctorResponse.setName( doctor.getName() );
        doctorResponse.setPhone( doctor.getPhone() );
        doctorResponse.setMail( doctor.getMail() );
        doctorResponse.setAddress( doctor.getAddress() );
        doctorResponse.setCity( doctor.getCity() );
        doctorResponse.setAvailableDateList( availableDateListToGlobalAvailableDateResponseList( doctor.getAvailableDateList() ) );

        return doctorResponse;
    }

    @Override
    public List<DoctorResponse> asOutput(List<Doctor> doctors) {
        if ( doctors == null ) {
            return null;
        }

        List<DoctorResponse> list = new ArrayList<DoctorResponse>( doctors.size() );
        for ( Doctor doctor : doctors ) {
            list.add( asOutput( doctor ) );
        }

        return list;
    }

    @Override
    public void update(Doctor entity, DoctorRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setName( request.getName() );
        entity.setPhone( request.getPhone() );
        entity.setMail( request.getMail() );
        entity.setAddress( request.getAddress() );
        entity.setCity( request.getCity() );
    }

    protected GlobalAvailableDateResponse availableDateToGlobalAvailableDateResponse(AvailableDate availableDate) {
        if ( availableDate == null ) {
            return null;
        }

        GlobalAvailableDateResponse globalAvailableDateResponse = new GlobalAvailableDateResponse();

        globalAvailableDateResponse.setDate( availableDate.getDate() );

        return globalAvailableDateResponse;
    }

    protected List<GlobalAvailableDateResponse> availableDateListToGlobalAvailableDateResponseList(List<AvailableDate> list) {
        if ( list == null ) {
            return null;
        }

        List<GlobalAvailableDateResponse> list1 = new ArrayList<GlobalAvailableDateResponse>( list.size() );
        for ( AvailableDate availableDate : list ) {
            list1.add( availableDateToGlobalAvailableDateResponse( availableDate ) );
        }

        return list1;
    }
}
