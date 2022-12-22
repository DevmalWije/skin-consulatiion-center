package phase1ToPhase2;

public class Consultation {
    //Defining consultation class arguments
    private Doctor doctor;
    private Patient patient;
    private String date;
    private String timeSlot;
    private double consultationCost;
    private String consulationNotes;

    //Creating consultation class constructor
    public Consultation(Doctor doctor, Patient patient, String date, String timeSlot, double consultationCost, String consulationNotes) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.timeSlot = timeSlot;
        this.consultationCost = consultationCost;
        this.consulationNotes = consulationNotes;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public double getConsultationCost() {
        return consultationCost;
    }

    public void setConsultationCost(double consultationCost) {
        this.consultationCost = consultationCost;
    }

    public String getConsulationNotes() {
        return consulationNotes;
    }

    public void setConsulationNotes(String consulationNotes) {
        this.consulationNotes = consulationNotes;
    }

    
}
