package phase1ToPhase2;

import java.util.ArrayList;
import java.util.Date;

public interface SkinConsultationManager {
    void addDoctor(Doctor doctor);
    void removeDoctor(Doctor doctor);
    ArrayList<Doctor> getDoctors();
    Doctor getDoctorById(String id);
    ArrayList<Doctor> getDoctorsBySpecialization(String specialization);
    void bookConsultation(Patient patient, Doctor doctor, Date date, String timeSlot, double cost, String notes);
    void cancelConsultation(Consultation consultation);

}


