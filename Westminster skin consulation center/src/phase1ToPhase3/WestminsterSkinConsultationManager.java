package phase1ToPhase3;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    static ArrayList<Doctor> doctorArray = new ArrayList<Doctor>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc=new Scanner(System.in);
        String Fname = null,Sname = null,Mobile = null,DOB = null,NIC = null,Specialization = null,LicenseNumber = null;

        //CRUD for operations testing
//        doctorArray.add(new Doctor("John", "Smith", "0777777777", "01/01/1990", "123456789V", "Dermatologist", "123456"));
//        doctorArray.add(new Doctor("Jane", "Doe", "0777777777", "01/01/1990", "123456789V", "Dermatologist", "123456"));
//        doctorArray.add(new Doctor("John", "Smith", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));
//        doctorArray.add(new Doctor("Jane", "Doe", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));
//        doctorArray.add(new Doctor("John", "Smith", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));
//        doctorArray.add(new Doctor("John", "Smith", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));
//        doctorArray.add(new Doctor("John", "Smith", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));
//        doctorArray.add(new Doctor("Jane", "Doe", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));
//        doctorArray.add(new Doctor("John", "Smith", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));
//        doctorArray.add(new Doctor("John", "Smith", "dasddsad", "01/06/1990", "asdasd", "dadasd", "asd"));

        System.out.println("Welcome to Westminster Skin Consultation Center");
        getSavedDoctorList();

        while (true) {
            System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. Display Doctors");
            System.out.println("4. Save Doctors list");
            System.out.println("5. Run GUI center");
            System.out.println("6. Exit");
            System.out.print("choice--->>> ");
            String OptionChoice = sc.next();
            switch (OptionChoice) {
                case "1":
                    //Taking user input and validating it to add new doctor
                        if (doctorArray.size() == 10) {
                            System.out.println("Sorry, doctor list is full");
                            break;
                        } else {
                            while (true) {
                            try {
                                System.out.println("Enter First Name");
                                Fname = sc.next();
                                if (Fname.length() >= 3) {
                                    break;
                                } else {
                                    System.out.println("First name should be more than 3 characters");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Input");
                            }
                        }
                    while (true) {
                        try {
                            System.out.println("Enter Last Name");
                            Sname = sc.next();
                            if (Sname.length() >= 3) {
                                break;
                            } else {
                                System.out.println("First name should be more than 3 characters");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input");
                        }
                    }

                    while (true) {
                        System.out.println("Enter Mobile Number in the following format: 0777777777");
                        try {
                            Mobile = sc.next();
                            if (Mobile.length() != 10) {
                                throw new InputMismatchException();
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid mobile number. Please enter a valid number with 10 digits.");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Enter Date of Birth the format dd/MM/yyyy");
                            DOB = sc.next();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            sdf.setLenient(false);
                            Date date = sdf.parse(DOB);
                            break;
                        } catch (ParseException e) {
                            System.out.println("Error: Invalid date of birth. Please enter a valid date in the format dd/MM/yyyy.");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Enter NIC");
                            NIC = sc.next();
                            if (NIC.length() <= 11) {
                                throw new InputMismatchException();
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid NIC. Please enter a valid NIC with 13 digits.");
                        }
                    }
                    while (true) {
                        try {
                            System.out.println("Enter Specialization");
                            Specialization = sc.next();
                            if (Specialization.length() >= 3) {
                                break;
                            } else {
                                System.out.println("Specialization should be more than 3 characters");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Enter License Number");
                            LicenseNumber = sc.next();
                            if (LicenseNumber.length() != 7) {
                                throw new InputMismatchException();
                            } else {
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid license number. Please enter a valid license number with 7 digits.");
                        }
                    }
                    //Adding the doctor to the array list
                    doctorArray.add(new Doctor(Fname, Sname, Mobile, DOB, NIC, Specialization, LicenseNumber));
                    System.out.println(Fname + " " + Sname + " Doctor Added Added Successfully");
                    printDoctorList();
            }


                    break;

                case "2":
                    //Remove Doctor
                    if (doctorArray.size() == 0) {
                        System.out.println("No Doctors Available");
                    } else {
                        printDoctorList();
                        boolean doctorFound = false;
                        System.out.println("Enter License Number of Doctor to remove");
                        LicenseNumber = sc.next();
                        for (Doctor doctor : doctorArray) {
                            if (doctor.getMedicalLicenseNumber().equals(LicenseNumber)) {
                                doctorArray.remove(doctor);
                                System.out.println("Doctor Removed Successfully");
                                System.out.println("-------------------------------------------------------- Updated List of Available Doctors ----------------------------------------------------");
                                printDoctorList();
                                doctorFound = true;
                                break;
                            }
                        }
                        if (!doctorFound) {
                            System.out.println("Doctor Not Found");
                        }
                    }
                    break;

                case "3":
                    if(doctorArray.size() == 0) {
                        System.out.println("No Doctors Available");
                    } else {
                        printSortedList();
                        break;
                    }
                    break;

                case "4":
                   //saving doctor list to text file
                    saveDoctorList();
                    break;

                case "5":
                    //running GUI
                    WestminsterSkinConsultationClinic_GUI.main(null);
                    break;
                case "6":
                    //exit
                    System.exit(0);
                    break;

                default:
                System.out.println("Invalid choice");
            }
        }
    }

    //Method to print the doctor list
    private static void printDoctorList() {
        System.out.println("-------------------------------------------------------------- Available Doctors --------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "First Name", "Surname", "Mobile Number", "Date of Birth", "NIC", "Specialization", "License Number");
        for (Doctor doctor : doctorArray) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", doctor.getName(), doctor.getSurName(), doctor.getMobileNumber(), doctor.getDateOfBirth(), doctor.getNIC(), doctor.getSpecialization(), doctor.getMedicalLicenseNumber());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }
    //sorting the doctor list
    private static void printSortedList(){
        ArrayList<String> sortedList = new ArrayList<>();
        for (int i = 0; i < doctorArray.size(); i++) {
            sortedList.add(i,doctorArray.get(i).getSurName()+" "+doctorArray.get(i).getName()+" "+doctorArray.get(i).getMobileNumber()+" "+doctorArray.get(i).getDateOfBirth()+" "+doctorArray.get(i).getNIC()+" "+doctorArray.get(i).getSpecialization()+" "+doctorArray.get(i).getMedicalLicenseNumber());
        }
        sortedList.sort(String::compareToIgnoreCase);
        System.out.println("-------------------------------------------------------------- Sorted Doctors List --------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Surname", "First Name", "Mobile Number", "Date of Birth", "NIC", "Specialization", "License Number");
        for (String doctor : sortedList) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", doctor.split(" ")[0], doctor.split(" ")[1], doctor.split(" ")[2], doctor.split(" ")[3], doctor.split(" ")[4], doctor.split(" ")[5], doctor.split(" ")[6]);
        }
    }
    //saving doctor list to text file
    private static void saveDoctorList() throws IOException {
        if (doctorArray.size() == 0) {
            System.out.println("No Doctors Available");
        } else {
            File file = new File("DoctorsDetails.txt");
            file.createNewFile();

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (int i = 1; i <= doctorArray.size(); i++) {
                objectOutputStream.writeObject(doctorArray.get(i - 1));
            }

            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Doctors list saved successfully");
        }

    }

    //getting saved doctor list from text file
    private static void getSavedDoctorList() throws IOException, ClassNotFoundException {
        while (true) {
            File file = new File("DoctorsDetails.txt");
            if (file.exists()) {
                System.out.println("Do you wish to load the saved doctor list? (Y/N)");
                System.out.print("Choice--->>> ");
                Scanner loadOption = new Scanner(System.in);
                String option = loadOption.next();
                if (option.equals("Y") || option.equals("y")) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                    while (fileInputStream.available() > 0) {
                        Doctor doctor = (Doctor) objectInputStream.readObject();
                        doctorArray.add(doctor);
                    }
                    objectInputStream.close();
                    fileInputStream.close();

                    System.out.println("Doctors list loaded successfully\n");
                    break;
                } else if (option.equals("N") || option.equals("n")) {
                    System.out.println("Doctor list not loaded");
                    break;
                } else {
                    System.out.println("Invalid option");
                }
            } else {
                System.out.println("No saved doctors list found");
                break;

            }
        }
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorArray.add(doctor);
    }

    @Override
    public void removeDoctor(Doctor doctor) {
        doctorArray.remove(doctor);
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
