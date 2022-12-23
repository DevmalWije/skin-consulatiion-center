package phase1ToPhase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    static ArrayList<Doctor> doctorArray = new ArrayList<Doctor>();
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String Fname,Sname,Mobile,DOB,NIC,Specialization,LicenseNumber,PatientID;
        doctorArray.add(new Doctor("John", "Smith", "0777777777", "01/01/1990", "123456789V", "Dermatologist", "123456"));
        doctorArray.add(new Doctor("Jane", "Doe", "0777777777", "01/01/1990", "123456789V", "Dermatologist", "123456"));
        doctorArray.add(new Doctor("John", "Smith", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));

        while (true){
System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. Get Doctors");
            System.out.println("4. Get Doctor By Id");
            System.out.println("5. Get Doctors By Specialization");
            System.out.println("6. Book Consultation");
            System.out.println("7. Cancel Consultation");
            System.out.println("8. Exit");
            System.out.print("choice--->>> ");
            String OptionChoice = sc.next();
            switch (OptionChoice){
                case "1":
                    System.out.println("Enter First Name");
                    Fname=sc.next();
                    System.out.println("Enter surname");
                    Sname=sc.next();
                    System.out.println("Enter Mobile Number");
                    Mobile=sc.next();
                    System.out.println("Enter Date of Birth");
                    DOB=sc.next();
                    System.out.println("Enter NIC");
                    NIC=sc.next();
                    System.out.println("Enter Specialization");
                    Specialization=sc.next();
                    System.out.println("Enter License Number");
                    LicenseNumber=sc.next();
                    doctorArray.add(new Doctor(Fname,Sname,Mobile,DOB,NIC,Specialization,LicenseNumber));
                    System.out.println(Fname+" "+Sname+" Added Successfully");
                    System.out.println("Doctor Added");
                    System.out.println(doctorArray.toString());
                    System.out.println(doctorArray.get(0).toString());
                    break;
//                case 2:
//                    removeDoctor();
//                    break;
//                case 3:
//                    getDoctors();
//                    break;
//                case 4:
//                    getDoctorById();
//                    break;
//                case 5:
//                    getDoctorsBySpecialization();
//                    break;
//                case 6:
//                    bookConsultation();
//                    break;
//                case 7:
//                    cancelConsultation();
//                    break;
//                case 8:
//                    System.exit(0);
//                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorArray.add(doctor);
    }

    @Override
    public void removeDoctor(Doctor doctor) {

    }

    @Override
    public ArrayList<Doctor> getDoctors() {
        return null;
    }

    @Override
    public Doctor getDoctorById(String id) {
        return null;
    }

    @Override
    public ArrayList<Doctor> getDoctorsBySpecialization(String specialization) {
        return null;
    }

    @Override
    public void bookConsultation(Patient patient, Doctor doctor, Date date, String timeSlot, double cost, String notes) {

    }

    @Override
    public void cancelConsultation(Consultation consultation) {

    }
}
