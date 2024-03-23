package dev.patika.core.config.mapper;

import dev.patika.dto.request.ReportRequest;
import dev.patika.dto.response.global.GlobalAnimalResponse;
import dev.patika.dto.response.global.GlobalDoctorResponse;
import dev.patika.dto.response.global.GlobalReportResponse;
import dev.patika.dto.response.global.GlobalVaccineResponse;
import dev.patika.dto.response.standard.AppointmentResponse;
import dev.patika.dto.response.standard.ReportResponse;
import dev.patika.entity.Animal;
import dev.patika.entity.Appointment;
import dev.patika.entity.Doctor;
import dev.patika.entity.Report;
import dev.patika.entity.Vaccine;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public Report convertToReport(ReportRequest request) {
        if ( request == null ) {
            return null;
        }

        Report report = new Report();

        report.setTitle( request.getTitle() );
        report.setDiagnosis( request.getDiagnosis() );
        report.setPrice( request.getPrice() );
        report.setAppointment( request.getAppointment() );

        return report;
    }

    @Override
    public ReportResponse convertToReportResponse(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportResponse reportResponse = new ReportResponse();

        reportResponse.setId( report.getId() );
        reportResponse.setTitle( report.getTitle() );
        reportResponse.setDiagnosis( report.getDiagnosis() );
        reportResponse.setPrice( report.getPrice() );
        reportResponse.setAppointment( appointmentToAppointmentResponse( report.getAppointment() ) );
        reportResponse.setVaccineList( vaccineListToGlobalVaccineResponseList( report.getVaccineList() ) );

        return reportResponse;
    }

    @Override
    public List<ReportResponse> convertToReportResponseList(List<Report> reportList) {
        if ( reportList == null ) {
            return null;
        }

        List<ReportResponse> list = new ArrayList<ReportResponse>( reportList.size() );
        for ( Report report : reportList ) {
            list.add( convertToReportResponse( report ) );
        }

        return list;
    }

    @Override
    public void update(Report report, ReportRequest request) {
        if ( request == null ) {
            return;
        }

        report.setTitle( request.getTitle() );
        report.setDiagnosis( request.getDiagnosis() );
        report.setPrice( request.getPrice() );
        report.setAppointment( request.getAppointment() );
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

    protected AppointmentResponse appointmentToAppointmentResponse(Appointment appointment) {
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

    protected GlobalReportResponse reportToGlobalReportResponse(Report report) {
        if ( report == null ) {
            return null;
        }

        GlobalReportResponse globalReportResponse = new GlobalReportResponse();

        globalReportResponse.setId( report.getId() );
        globalReportResponse.setTitle( report.getTitle() );

        return globalReportResponse;
    }

    protected GlobalVaccineResponse vaccineToGlobalVaccineResponse(Vaccine vaccine) {
        if ( vaccine == null ) {
            return null;
        }

        GlobalVaccineResponse globalVaccineResponse = new GlobalVaccineResponse();

        globalVaccineResponse.setId( vaccine.getId() );
        globalVaccineResponse.setName( vaccine.getName() );
        globalVaccineResponse.setCode( vaccine.getCode() );
        globalVaccineResponse.setProtectionStartDate( vaccine.getProtectionStartDate() );
        globalVaccineResponse.setProtectionFinishDate( vaccine.getProtectionFinishDate() );
        globalVaccineResponse.setAnimal( animalToGlobalAnimalResponse( vaccine.getAnimal() ) );
        globalVaccineResponse.setReport( reportToGlobalReportResponse( vaccine.getReport() ) );

        return globalVaccineResponse;
    }

    protected List<GlobalVaccineResponse> vaccineListToGlobalVaccineResponseList(List<Vaccine> list) {
        if ( list == null ) {
            return null;
        }

        List<GlobalVaccineResponse> list1 = new ArrayList<GlobalVaccineResponse>( list.size() );
        for ( Vaccine vaccine : list ) {
            list1.add( vaccineToGlobalVaccineResponse( vaccine ) );
        }

        return list1;
    }
}
