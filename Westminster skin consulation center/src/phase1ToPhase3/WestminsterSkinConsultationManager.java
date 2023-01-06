package phase1ToPhase3;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    static ArrayList<Doctor> doctorArray = new ArrayList<Doctor>();

    static ArrayList<Consultation> consulationsArray = new ArrayList<Consultation>();

    static ArrayList<File> ImageArray = new ArrayList<File>();

    static Map<String,File>ImageMap = new HashMap<String,File>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc=new Scanner(System.in);
        String Fname = null,Sname = null,Mobile = null,DOB = null,NIC = null,Specialization = null,LicenseNumber = null;

        //CRUD for operations testing
        doctorArray.add(new Doctor("Will", "Smith", "0797767737", "01/01/1990", "123826789V", "Dermatologist", "8261437"));
        doctorArray.add(new Doctor("Mack", "Doe", "0776773697", "01/01/1990", "523456829V", "Pediatrics", "8796213"));
        doctorArray.add(new Doctor("Tonson", "Wadde", "0769776773", "01/06/1990", "823826789V", "Cardiology", "9683512"));
        doctorArray.add(new Doctor("Paneson", "Doe", "0697677377", "01/06/1990", "223482789W", "Orthopedics", "1496328"));
        doctorArray.add(new Doctor("Boh", "William", "0776967737", "01/06/1990", "428256789V", "Neurology", "6498721"));
        doctorArray.add(new Doctor("Dohn", "Shakes", "0767737697", "01/06/1990", "328256789W", "Ophthalmology", "0824651"));
        doctorArray.add(new Doctor("Nyu", "gwen", "0697767737", "01/06/1990", "082456789", "Oncology", "2317496"));
        doctorArray.add(new Doctor("Kane", "Don", "0769767737", "01/06/1990", "323458289W", "Pulmonology", "9471265"));
        doctorArray.add(new Doctor("Wade", "Mackenosn", "0777577696","01/06/1990", "723826789V", "gynecology", "6381729"));
        doctorArray.add(new Doctor("Yashika", "Rvalipadi", "0797377697", "01/06/1990", "3282567882W", "Rheumatology", "0183652"));



        System.out.println("Welcome to Westminster Skin Consultation Center");
        getSavedDoctorList();

        consulationsArray.add(new Consultation(doctorArray.get(0),new Patient("John", "Smith", "0777777777", "05/01/1990", "123456789V","01029001"),"05/01/2023","8:00",10,"by lord this mans sick, get him some milk!! asdasd asd asd asdasdasdadads a asdaa dasd asd asd asdadad adssada sdadasd","01029001"));
        consulationsArray.add(new Consultation(doctorArray.get(0),new Patient("jane", "asd", "0777777777", "01/01/1990", "123456789V","01029001"),"02/01/2023","18:00",10,"Notes","01029001"));
        consulationsArray.add(new Consultation(doctorArray.get(0),new Patient("mary", "asd", "0777777777", "01/01/1990", "123456789V","01029001"),"02/01/2023","12:00",10,"Notes","01029001"));
        consulationsArray.add(new Consultation(doctorArray.get(0),new Patient("Viktor", "Smasdith", "0777777777", "01/01/1990", "123456789V","01029001"),"02/01/2023","9:00",10,"Notes","01029001"));
        consulationsArray.add(new Consultation(doctorArray.get(0),new Patient("Putin", "fgh", "0777777777", "01/01/1990", "123456789V","01029001"),"02/01/2023","10:00",10,"Notes","01029001"));
        consulationsArray.add(new Consultation(doctorArray.get(0),new Patient("Gota", "cv", "0777777777", "01/01/1990", "123456789V","01029001"),"02/01/2023","11:00",10,"Notes","01029001"));
        consulationsArray.add(new Consultation(doctorArray.get(0),new Patient("Maina", "wer", "0777777777", "01/01/1990", "123456789V","01029001"),"02/01/2023","13:00",10,"Notes","01029001"));
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
                                System.out.println("-------------------------------------------------------- Doctor Removed Successfully ----------------------------------------------------");
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
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    while (fileInputStream.available() > 0) {
                        Doctor doctor = (Doctor) objectInputStream.readObject();
                        doctorArray.add(doctor);
                    }
                    objectInputStream.close();
                    fileInputStream.close();
                    System.out.println("Doctors list loaded successfully\n");
            } else {
                System.out.println("No saved doctors list found");

            }
            break;
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
