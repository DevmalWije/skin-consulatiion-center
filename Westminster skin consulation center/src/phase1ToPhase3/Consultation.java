package phase1ToPhase3;

import java.io.Serializable;
import java.util.Date;

public class Consultation implements Serializable {
    public static final long serialVersionUID = 1L;
    //Defining consultation class arguments
    private Doctor doctor;
    private Patient patient;
    private String date;
    private String timeSlot;
    private double consultationCost;
    private String consultationNotes;

    //Creating consultation class constructor
    public Consultation(Doctor doctor, Patient patient, String date, String timeSlot, double consultationCost, String consultationNotes) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.timeSlot = timeSlot;
        this.consultationCost = consultationCost;
        this.consultationNotes = consultationNotes;
    }
    //Creating getters and setters for consultation class arguments
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getConsultationDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConsultationTime() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public double getConsultationFee() {
        return consultationCost;
    }

    public void setConsultationCost(double consultationCost) {
        this.consultationCost = consultationCost;
    }

    public String getConsultationNotes() {
        return consultationNotes;
    }

    public void setConsultationNotes(String consultationNotes) {
        this.consultationNotes = consultationNotes;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "doctor=" + doctor +
                ", patient=" + patient +
                ", date='" + date + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", consultationCost=" + consultationCost +
                ", consultationNotes='" + consultationNotes + '\'' +
                '}';
    }
}
