package phase1ToPhase3;

public class Patient extends Person {
    private String patientID;

    public Patient(String name, String surName, String mobileNumber, String dateOfBirth, String NIC, String patientID) {
        super(name, surName, mobileNumber, dateOfBirth, NIC);
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
}
