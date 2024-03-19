package dev.patika.core.config.mapper;

import dev.patika.dto.request.AppointmentRequest;
import dev.patika.dto.response.global.GlobalAnimalResponse;
import dev.patika.dto.response.global.GlobalDoctorResponse;
import dev.patika.dto.response.standard.AppointmentResponse;
import dev.patika.entity.Animal;
import dev.patika.entity.Appointment;
import dev.patika.entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IAppointmentMapperImpl implements IAppointmentMapper {

    @Override
    public Appointment asEntity(AppointmentRequest request) {
        if ( request == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setAppointmentDate( request.getAppointmentDate() );
        appointment.setAnimal( request.getAnimal() );
        appointment.setDoctor( request.getDoctor() );

        return appointment;
    }

    @Override
    public AppointmentResponse asOutput(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentResponse appointmentResponse = new AppointmentResponse();

        appointmentResponse.setId( appointment.getId() );
        appointmentResponse.setAppointmentDate( appointment.getAppointmentDate() );
        appointmentResponse.setAnimal( animalToGlobalAnimalResponse( appointment.getAnimal() ) );
        appointmentResponse.setDoctor( doctorToGlobalDoctorResponse( appointment.getDoctor() ) );

        return appointmentResponse;
    }

    @Override
    public List<AppointmentResponse> asOutput(List<Appointment> appointmentList) {
        if ( appointmentList == null ) {
            return null;
        }

        List<AppointmentResponse> list = new ArrayList<AppointmentResponse>( appointmentList.size() );
        for ( Appointment appointment : appointmentList ) {
            list.add( asOutput( appointment ) );
        }

        return list;
    }

    @Override
    public void update(Appointment entity, AppointmentRequest request) {
        if ( request == null ) {
            return;
        }

        entity.setAppointmentDate( request.getAppointmentDate() );
        entity.setAnimal( request.getAnimal() );
        entity.setDoctor( request.getDoctor() );
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

    protected GlobalDoctorResponse doctorToGlobalDoctorResponse(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        GlobalDoctorResponse globalDoctorResponse = new GlobalDoctorResponse();

        globalDoctorResponse.setId( doctor.getId() );
        globalDoctorResponse.setName( doctor.getName() );

        return globalDoctorResponse;
    }
}
