package phase1ToPhase3;

public class Doctor extends Person {

    //Defining doctor class arguments
    private String specialization;
    private String medicalLicenseNumber;

    //Creating doctor class constructor
    public Doctor(String name, String surName, String mobileNumber, String dateOfBirth, String NIC, String specialization, String medicalLicenseNumber) {
        super(name, surName, mobileNumber, dateOfBirth, NIC);
        this.specialization = specialization;
        this.medicalLicenseNumber = medicalLicenseNumber;
    }


    //Creating getters and setters for doctor class arguments

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }
}
