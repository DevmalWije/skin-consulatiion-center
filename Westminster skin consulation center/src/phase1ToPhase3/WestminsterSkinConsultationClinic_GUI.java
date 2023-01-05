package phase1ToPhase3;

//importing relevant libraries
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import static phase1ToPhase3.WestminsterSkinConsultationManager.doctorArray;


public class WestminsterSkinConsultationClinic_GUI {
        public static void main(String[] args) {

                //setting header label
                JLabel HeaderLabel = new JLabel("Westminster Skin");
                JLabel HeaderLabel2 = new JLabel("consultation Clinic");
                HeaderLabel.setBounds(312, 40, 500, 100);
                HeaderLabel2.setBounds(310, 70, 500, 100);
                HeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
                HeaderLabel2.setHorizontalAlignment(SwingConstants.CENTER);

                //setting header label font and color
                HeaderLabel.setFont(new Font("poppins", Font.PLAIN, 30));
                HeaderLabel.setForeground(new Color(0x123456));
                HeaderLabel2.setFont(new Font("poppins", Font.PLAIN, 30));
                HeaderLabel2.setForeground(new Color(0x123456));

                //adding background image
                JLabel background = new JLabel(new ImageIcon("backdrop.jpeg"));
                background.setBounds(0, 0, 750, 500);

                //creating buttons
                JButton ConsultationButton = new JButton("Book consultation");
                JButton doctorListButton = new JButton("Doctor list");
                JButton bookedConsultationsButton = new JButton("currently Booked consultations");
                JButton backButton1 = new JButton("< Back");
                JButton backButton2 = new JButton("< Back");
                JButton backButton3 = new JButton("< Back");
                JButton backButton4 = new JButton("< Back");
                JButton bookButton = new JButton("Book consultation");
                JButton doctorSortButton = new JButton("Sort Doctor by Name");
                JButton imageUploadButton = new JButton("\uD83D\uDCC4");
                JButton checkConsultationButton = new JButton("Check Your Consultation");


                //setting button bounds
                ConsultationButton.setBounds(410, 180, 300, 50);
                ConsultationButton.setFont(new Font("poppins", Font.PLAIN, 16));

                doctorListButton.setBounds(410, 250, 300, 50);
                doctorListButton.setFont(new Font("poppins", Font.PLAIN, 16));

                bookedConsultationsButton.setBounds(410, 320, 300, 50);
                bookedConsultationsButton.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton1.setBounds(0, 0, 300, 50);
                backButton1.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton2.setBounds(0, 0, 300, 50);
                backButton2.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton2.setBounds(0, 0, 734, 40);
                backButton2.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton3.setBounds(0, 0, 300, 50);
                backButton3.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton4.setBounds(0, 0, 300, 50);
                backButton4.setFont(new Font("poppins", Font.PLAIN, 16));

                bookButton.setBounds(280, 395, 200, 40);
                bookButton.setFont(new Font("poppins", Font.PLAIN, 16));

                doctorSortButton.setBounds(0, 0, 300, 50);
                doctorSortButton.setFont(new Font("poppins", Font.PLAIN, 16));

                imageUploadButton.setBounds(480,250,150,35);

                checkConsultationButton.setBounds(0, 0, 300, 50);
                checkConsultationButton.setFont(new Font("poppins", Font.PLAIN, 16));
                //creating doctor table model
                DefaultTableModel doctorTableModel = new DefaultTableModel();

                //adding columns to doctor table
                doctorTableModel.addColumn("Name");
                doctorTableModel.addColumn("Surname");
                doctorTableModel.addColumn("Mobile #");
                doctorTableModel.addColumn("Birth Date");
                doctorTableModel.addColumn("NIC");
                doctorTableModel.addColumn("Specialization");
                doctorTableModel.addColumn("License #");

                //adding rows to doctor table
                for (Doctor doctor : doctorArray) {
                        String name = doctor.getName();
                        String surname = doctor.getSurName();
                        String mobileNumber = doctor.getMobileNumber();
                        String dateOfBirth = doctor.getDateOfBirth();
                        String NIC = doctor.getNIC();
                        String specialization = doctor.getSpecialization();
                        String licenseNumber = doctor.getMedicalLicenseNumber();
                                doctorTableModel.addRow(new Object[]{name, surname, mobileNumber, dateOfBirth, NIC, specialization, licenseNumber});
//                        doctorTableModel.addRow(new Object[]{doctor.getName(), doctor.getSurName(), doctor.getMobileNumber(), doctor.getDateOfBirth(), doctor.getNIC(), doctor.getSpecialization(), doctor.getLicenseNumber()});
                }

                //creating doctor table
                JTable doctorTable = new JTable(doctorTableModel);
                doctorTable.setBounds(0, 0, 750, 500);
                doctorTable.setRowHeight(45);
                doctorTable.setEnabled(false);
                doctorTable.setFont(new Font("poppins", Font.PLAIN, 13));
                doctorTable.setBackground(new Color(121, 152, 201));
                doctorTable.setForeground(Color.WHITE);

                JTableHeader doctorTableHeader = doctorTable.getTableHeader();
                doctorTableHeader.setFont(new Font("poppins", Font.BOLD, 13));
                doctorTableHeader.setBackground(new Color(0x123456));
                doctorTableHeader.setForeground(Color.WHITE);


                //Creating consultations table model
                JTable consultationTable = new JTable();
                consultationTable.setBounds(0, 0, 750, 500);
                consultationTable.setRowHeight(45);
                consultationTable.setEnabled(false);
                consultationTable.setFont(new Font("poppins", Font.PLAIN, 13));
                consultationTable.setBackground(new Color(121, 152, 201));
                consultationTable.setForeground(Color.WHITE);

                JTableHeader consultationTableHeader = consultationTable.getTableHeader();
                consultationTableHeader.setFont(new Font("poppins", Font.BOLD, 13));
                consultationTableHeader.setBackground(new Color(0x123456));
                consultationTableHeader.setForeground(Color.WHITE);

                //adding columns to consultation table
                consultationTable.setModel(new DefaultTableModel(
                        new Object[][]{
                        },
                        new String[]{
                                "Doctor Name", "Specialization", "Patient Name", "Patient ID", "Consult Date", "Consult Time","Consult cost","Consult ID"
                        }
                ));

                //adding rows to consultation table
                for (Consultation consultation : WestminsterSkinConsultationManager.consulationsArray) {
                        ((DefaultTableModel) consultationTable.getModel()).addRow(new Object[]{consultation.getDoctor().getName()+" "+consultation.getDoctor().getSurName(),
                                consultation.getDoctor().getSpecialization(), consultation.getPatient().getName()+" "+consultation.getPatient().getSurName(),consultation.getPatient().getPatientID(),
                                consultation.getConsultationDate(), consultation.getConsultationTime(),"£ "+consultation.getConsultationFee(),consultation.getConsultationID()});
                }

                // Create a new table to show more details about the clicked row
                JTable detailsTable = new JTable();
                DefaultTableModel detailsModel = new DefaultTableModel();
                detailsModel.addColumn("Attribute");
                detailsModel.addColumn("Value");
                detailsTable.setModel(detailsModel);


                //creating combobox for doctor selection
                JComboBox<String> doctorComboBox = new JComboBox<>();
                doctorComboBox.setBounds(150, 50, 150, 30);


                //adding doctors to combobox
                for (Doctor doctor : doctorArray) {
                        doctorComboBox.addItem(doctor.getMedicalLicenseNumber());
                }
                doctorComboBox.setSelectedIndex(-1);

                //creating combobox for time slot selection
                JComboBox<String> timeSlotComboBox = new JComboBox<>();
                timeSlotComboBox.setBounds(380, 100, 70, 30);
                for (int i = 8; i < 21; i++) {
                        timeSlotComboBox.addItem(i + ":00");
                }
                timeSlotComboBox.setSelectedIndex(-1);

                //creating combobox for consultation duration
                JComboBox<String> durationComboBox = new JComboBox<>();
                durationComboBox.setBounds(560, 100, 100, 30);
                durationComboBox.addItem("30 minutes");
                durationComboBox.addItem("1 hour");
                durationComboBox.addItem("1 hour 30");
                durationComboBox.addItem("2 hours");


                //Creating Jlabels for consultation panel

                JLabel doctorLabel = new JLabel("Select Doctor :");
                doctorLabel.setBounds(25, 40, 300, 50);
                doctorLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel SelectedDoctorLabel = new JLabel("Selected Doctor :");
                SelectedDoctorLabel.setBounds(325, 40, 400, 50);
                SelectedDoctorLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel ConsultationDateLabel = new JLabel("Select Date :");
                ConsultationDateLabel.setBounds(25, 90, 400, 50);
                ConsultationDateLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel ConsultationTimeLabel = new JLabel("Time :");
                ConsultationTimeLabel.setBounds(325, 90, 400, 50);
                ConsultationTimeLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel ConsultationDurationLabel = new JLabel("Duration :");
                ConsultationDurationLabel.setBounds(475, 90, 400, 50);
                ConsultationDurationLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel patientNameLabel = new JLabel("Patient Name :");
                patientNameLabel.setBounds(25, 140, 300, 50);
                patientNameLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel patientSurnameLabel = new JLabel("Patient Surname :");
                patientSurnameLabel.setBounds(325, 140, 300, 50);
                patientSurnameLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel PatientDOBLabel = new JLabel("Patient DOB :");
                PatientDOBLabel.setBounds(25, 190, 300, 50);
                PatientDOBLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel PatientContactLabel = new JLabel("Patient Mobile No :");
                PatientContactLabel.setBounds(325, 190, 300, 50);
                PatientContactLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel PatientNICLabel = new JLabel("Patient NIC :");
                PatientNICLabel.setBounds(25, 240, 300, 50);
                PatientNICLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel patientNotesLabel = new JLabel("Patient Notes :");
                patientNotesLabel.setBounds(25, 290, 300, 50);
                patientNotesLabel.setFont(new Font("poppins", Font.PLAIN, 16));

                JLabel imageUploadLabel = new JLabel("Upload Image :");
                imageUploadLabel.setBounds(325,240,300,50);
                imageUploadLabel.setFont(new Font("poppins", Font.PLAIN, 16));


                //creating main panel
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BorderLayout());

                //----------creating sub panels----------//
                //consultation panel
                JPanel consultationsPanel = new JPanel();
                consultationsPanel.setLayout(null);
                consultationsPanel.setPreferredSize(new Dimension(750, 500));
                //doctor list panel
                JPanel doctorListPanel = new JPanel();
                doctorListPanel.setLayout(new BorderLayout());
                doctorListPanel.setPreferredSize(new Dimension(750, 500));
                //booked consultations panel
                JPanel bookedConsultationsPanel = new JPanel();
                bookedConsultationsPanel.setLayout(new BorderLayout());
                //panel to check users consultations
                JPanel checkConsultationPanel = new JPanel();
                checkConsultationPanel.setLayout(new BorderLayout());
                checkConsultationPanel.setPreferredSize(new Dimension(750, 500));

                //creating JdatePicker component
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
                datePicker.setBounds(150, 100, 150, 30);
                datePicker.setFont(new Font("poppins", Font.PLAIN, 10));

                UtilDateModel DOBModel = new UtilDateModel();
                Properties Q = new Properties();
                Q.put("text.today", "Today");
                Q.put("text.month", "Month");
                Q.put("text.year", "Year");
                JDatePanelImpl DOBDatePanel = new JDatePanelImpl(DOBModel, Q);
                JDatePickerImpl DOBDatePicker = new JDatePickerImpl(DOBDatePanel, new DateComponentFormatter());
                DOBDatePicker.setBounds(150, 200, 150, 30);
                DOBDatePicker.setFont(new Font("poppins", Font.PLAIN, 10));


                //creating text fields
                JTextField patientNameTextField = new JTextField();
                patientNameTextField.setBounds(150, 150, 150, 30);
                patientNameTextField.setFont(new Font("poppins", Font.PLAIN, 16));
                patientNameTextField.setBorder(BorderFactory.createLineBorder(new Color(230, 238, 246)));

                JTextField patientSurnameTextField = new JTextField();
                patientSurnameTextField.setBounds(480, 150, 150, 30);
                patientSurnameTextField.setFont(new Font("poppins", Font.PLAIN, 16));
                patientSurnameTextField.setBorder(BorderFactory.createLineBorder(new Color(230, 238, 246)));

                JTextField patientContactTextField = new JTextField();
                patientContactTextField.setBounds(480, 200, 150, 30);
                patientContactTextField.setFont(new Font("poppins", Font.PLAIN, 16));
                patientContactTextField.setBorder(BorderFactory.createLineBorder(new Color(230, 238, 246)));

                JTextField patientNICTextField = new JTextField();
                patientNICTextField.setBounds(150, 250, 150, 30);
                patientNICTextField.setFont(new Font("poppins", Font.PLAIN, 16));
                patientNICTextField.setBorder(BorderFactory.createLineBorder(new Color(230, 238, 246)));

                JTextArea patientNotesTextArea = new JTextArea();
                patientNotesTextArea.setBounds(150, 300, 480, 80);
                patientNotesTextArea.setFont(new Font("poppins", Font.PLAIN, 16));
                patientNotesTextArea.setLineWrap(true);
                patientNotesTextArea.setWrapStyleWord(true);
                patientNotesTextArea.setBorder(BorderFactory.createLineBorder(new Color(230, 238, 246)));

                JTextArea selectedDoctorField = new JTextArea("_ _ _ _ _ _ _ _ _");
                selectedDoctorField.setBounds(480, 50, 220, 30);
                selectedDoctorField.setFont(new Font("poppins", Font.PLAIN, 16));
                selectedDoctorField.setEditable(true);
                selectedDoctorField.setFocusable(false);
                selectedDoctorField.setLineWrap(true);
                selectedDoctorField.setBackground(new Color(238, 238, 238));


                //adding components to  "main" panel
                mainPanel.add(ConsultationButton);
                mainPanel.add(doctorListButton);
                mainPanel.add(bookedConsultationsButton);
                mainPanel.add(HeaderLabel);
                mainPanel.add(HeaderLabel2);
                mainPanel.add(background);

                JScrollPane doctorScrollPane = new JScrollPane(doctorTable);
                //adding components to "doctorListPanel" panel
                doctorListPanel.add(doctorScrollPane, BorderLayout.CENTER);
                doctorListPanel.add(backButton1, BorderLayout.NORTH);
                doctorListPanel.add(doctorSortButton, BorderLayout.SOUTH);

                //adding components to "consultationsPanel" panel
                consultationsPanel.add(backButton2);
                consultationsPanel.add(doctorLabel);
                consultationsPanel.add(doctorComboBox);
                consultationsPanel.add(SelectedDoctorLabel);
                consultationsPanel.add(ConsultationDateLabel);
                consultationsPanel.add(datePicker);
                consultationsPanel.add(ConsultationTimeLabel);
                consultationsPanel.add(timeSlotComboBox);
                consultationsPanel.add(ConsultationDurationLabel);
                consultationsPanel.add(durationComboBox);
                consultationsPanel.add(patientNameLabel);
                consultationsPanel.add(patientNameTextField);
                consultationsPanel.add(patientSurnameLabel);
                consultationsPanel.add(patientSurnameTextField);
                consultationsPanel.add(DOBDatePicker);
                consultationsPanel.add(PatientDOBLabel);
                consultationsPanel.add(PatientContactLabel);
                consultationsPanel.add(patientContactTextField);
                consultationsPanel.add(PatientNICLabel);
                consultationsPanel.add(patientNICTextField);
                consultationsPanel.add(imageUploadLabel);
                consultationsPanel.add(imageUploadButton);
                consultationsPanel.add(patientNotesLabel);
                consultationsPanel.add(patientNotesTextArea);
                consultationsPanel.add(selectedDoctorField);
                consultationsPanel.add(bookButton);

                //adding components to "bookedConsultationsPanel" panel
                bookedConsultationsPanel.add(backButton3, BorderLayout.NORTH);
                bookedConsultationsPanel.add(new JScrollPane(consultationTable), BorderLayout.CENTER);
                bookedConsultationsPanel.add(checkConsultationButton, BorderLayout.SOUTH);

                checkConsultationPanel.add(backButton4, BorderLayout.NORTH);
                checkConsultationPanel.add(new JScrollPane(detailsTable), BorderLayout.CENTER);


                //Making container panel
                JPanel containerPanel = new JPanel();
                containerPanel.setLayout(new CardLayout());

                //adding sub panels to container panel
                containerPanel.add(mainPanel, "Main Panel");
                containerPanel.add(consultationsPanel, "Consultations Panel");
                containerPanel.add(doctorListPanel, "Doctor List Panel");
                containerPanel.add(bookedConsultationsPanel, "Booked Consultations Panel");
                containerPanel.add(checkConsultationPanel, "Check Consultation Panel");

                //Creating consultation edit panels and relevant components
                JPanel consultationEditPanel = new JPanel();

                JLabel NICLabel = new JLabel("Enter NIC");

                //creating frame
                JFrame frame = new JFrame("Westminster Skin Consultation Clinic");
                frame.setSize(750, 500);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.add(containerPanel);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                //adding action listeners to buttons

                ConsultationButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                //Switch to Consultations Panel
                                mainPanel.setVisible(false);
                                consultationsPanel.setVisible(true);
                        }
                });

                doctorListButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                //Switch to Doctor List Panel
                                mainPanel.setVisible(false);
                                doctorListPanel.setVisible(true);
                        }
                });

                bookedConsultationsButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                //Switch to Booked Consultations Panel
                                mainPanel.setVisible(false);
                                bookedConsultationsPanel.setVisible(true);
                        }
                });

                ActionListener backButtonListener = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                //Switch to Main Panel
                                mainPanel.setVisible(true);
                                consultationsPanel.setVisible(false);
                                doctorListPanel.setVisible(false);
                                bookedConsultationsPanel.setVisible(false);
                                checkConsultationPanel.setVisible(false);
                                detailsModel.setRowCount(0);
                        }
                };

                doctorSortButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                               //sorting doctor table by first coloumn (name)
                                TableRowSorter<TableModel> sorter = new TableRowSorter<>(doctorTable.getModel());
                                doctorTable.setRowSorter(sorter);
                                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                                sorter.setSortKeys(sortKeys);
                                sorter.sort();

                        }
                });



                //adding action listener to back buttons
                backButton1.addActionListener(backButtonListener);
                backButton2.addActionListener(backButtonListener);
                backButton3.addActionListener(backButtonListener);
                backButton4.addActionListener(backButtonListener);



                //adding action listener to doctor combobox
                doctorComboBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String selectedDoctor = (String) doctorComboBox.getSelectedItem();
                                for (Doctor doctor : doctorArray) {
                                        if (doctor.getMedicalLicenseNumber().equals(selectedDoctor)) {
                                                selectedDoctorField.setText(doctor.getName() + " " + doctor.getSurName() + " (" + doctor.getSpecialization() + ")");
                                        }
                                }
                        }
                });

                // Adding event listener to check whether the selected date is valid
                datePicker.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Date selectedDate = (Date) datePicker.getModel().getValue();

                                // Check if the selected date is before the present date
                                if (selectedDate.before(new Date())) {
                                        JOptionPane.showMessageDialog(null, "Please select a date in the future.", "Error", JOptionPane.ERROR_MESSAGE);
                                        // Reset the date to the present date
                                        Calendar calendar = Calendar.getInstance();
                                        model.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
                                        model.setSelected(true);
                                }
                        }
                });

                DOBDatePicker.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                Date selectedDate = (Date) DOBDatePicker.getModel().getValue();

                                // Check if the selected date is before the present date
                                if (selectedDate.after(new Date())) {
                                        JOptionPane.showMessageDialog(null, "Please select a date in the Past.", "Error", JOptionPane.ERROR_MESSAGE);
                                        // Reset the date to the present date
                                        Calendar calendar = Calendar.getInstance();
                                        DOBModel.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
                                        DOBModel.setSelected(true);
                                }
                        }
                });

                //adding action listener to book button
                bookButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                if (datePicker.getJFormattedTextField().getText().equals("") || DOBDatePicker.getJFormattedTextField().getText().equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {

                                        // Get the selected doctor
                                        String selectedDoctor = (String) doctorComboBox.getSelectedItem();
                                        Doctor doctor = null;
                                        for (Doctor doctor1 : doctorArray) {
                                                if (doctor1.getMedicalLicenseNumber().equals(selectedDoctor)) {
                                                        doctor = doctor1;
                                                }
                                        }
                                        // Get the selected date
                                        Date selectedDate = (Date) datePicker.getModel().getValue();
                                        String selectedDateString = new SimpleDateFormat("dd/MM/yyyy").format(selectedDate);

                                        // Get the selected time slot
                                        String selectedTimeSlot = (String) timeSlotComboBox.getSelectedItem();
                                        // Get the selected duration
                                        String selectedDuration = (String) durationComboBox.getSelectedItem();


                                        // Get the patient name
                                        String patientName = patientNameTextField.getText();

                                        // Get the patient surname
                                        String patientSurname = patientSurnameTextField.getText();
                                        // Get the patient date of birth
                                        Date patientDOB = (Date) DOBDatePicker.getModel().getValue();
                                        String patientDOBString = new SimpleDateFormat("dd/MM/yyyy").format(patientDOB);

                                        // Get the patient contact number
                                        String patientContact = patientContactTextField.getText();


                                        // Get the patient NIC
                                        String patientNIC = patientNICTextField.getText();


                                        // Get the patient notes
                                        String patientNotes = patientNotesTextArea.getText();

                                        double duration = 0;
                                        assert selectedDuration != null;
                                        switch (selectedDuration) {
                                                case "30 minutes" -> duration = 0.5;
                                                case "1 hour" -> duration = 1;
                                                case "1 hour 30" -> duration = 1.5;
                                                case "2 hours" -> duration = 2;
                                        }
                                        String consultationID = null;
                                        consultationID = "C"+String.format("%08d", new Random().nextInt(1000));

                                        double consultPrice = 0.0;
                                        String patientID = null;
                                        boolean isPatientExist = false;
                                        for (Consultation consultation : WestminsterSkinConsultationManager.consulationsArray) {
                                                String checkPatientNIC = consultation.getPatient().getNIC();
                                                if (!Objects.equals(patientNIC, checkPatientNIC)) {
                                                        // Generate patient ID and set consultPrice
                                                        //Generating patient Id
                                                        patientID = String.format("%08d", new Random().nextInt(100000000));
                                                        consultPrice = duration * 15;
                                                } else {
                                                        // Set consultPrice
                                                        patientID = String.valueOf(consultation.getPatient().getPatientID());
                                                        consultPrice = duration * 25;
                                                }
                                        }

                                        // Checking for empty fields
                                        while (true) {
                                                if (selectedDoctor == null || selectedDate == null || patientDOB == null || selectedTimeSlot == null || patientName.isEmpty() || patientSurname.isEmpty() || patientContact.isEmpty() || patientNIC.isEmpty() || patientNotes.isEmpty()) {
                                                        JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                } else {
                                                        try {
                                                                if (patientContact.length() < 10 || patientNIC.length() < 12) {
                                                                        JOptionPane.showMessageDialog(null, "Please enter a valid contact number and NIC number.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                        break;
                                                                } else {
                                                                        //Checking for duplicate consultation date and time, then assigning the consultation
                                                                        for (Doctor doctor1 : doctorArray) {

                                                                                if (doctor1.getMedicalLicenseNumber().equals(selectedDoctor)) {

                                                                                        doctor = doctor1;

                                                                                        for (Consultation consultation : WestminsterSkinConsultationManager.consulationsArray) {
                                                                                                // Checking for duplicate consultation date and time
                                                                                                if (consultation.getDoctor().getMedicalLicenseNumber().equals(selectedDoctor) && consultation.getConsultationDate().equals(selectedDateString) && consultation.getConsultationTime().equals(selectedTimeSlot)) {
                                                                                                        JOptionPane.showMessageDialog(null, "The selected doctor is not available at the selected time slot, Assigning another doctor", "Warning", JOptionPane.ERROR_MESSAGE);

                                                                                                        //checking for other available doctors
                                                                                                        ArrayList<Doctor> availableDoctors = new ArrayList<>();
                                                                                                        for (Doctor doctor2 : WestminsterSkinConsultationManager.doctorArray) {
                                                                                                                // Check if the doctor is available at the selected time slot
                                                                                                                boolean isAvailable = true;
                                                                                                                for (Consultation consultation1 : WestminsterSkinConsultationManager.consulationsArray) {
                                                                                                                        if (consultation1.getDoctor().getMedicalLicenseNumber().equals(doctor2.getMedicalLicenseNumber()) && consultation1.getConsultationDate().equals(selectedDateString) && consultation1.getConsultationTime().equals(selectedTimeSlot)) {
                                                                                                                                isAvailable = false;
                                                                                                                                break;
                                                                                                                        }
                                                                                                                }
                                                                                                                // Add the doctor to the list of available doctors if they are available at the selected time slot
                                                                                                                if (isAvailable) {
                                                                                                                        availableDoctors.add(doctor2);
                                                                                                                }
                                                                                                        }
                                                                                                        // Assigning the consultation to the available doctor
                                                                                                        if (availableDoctors.isEmpty()) {
                                                                                                                JOptionPane.showMessageDialog(null, "There are no doctors available at the selected time slot.", "Error", JOptionPane.INFORMATION_MESSAGE);
                                                                                                                return;
                                                                                                        }
                                                                                                        // Randomly select a doctor from the list of available doctors
                                                                                                        int randomIndex = new Random().nextInt(availableDoctors.size());
                                                                                                        Doctor doctor3 = availableDoctors.get(randomIndex);

                                                                                                        // Assigning the consultation to the randomly selected doctor
                                                                                                        WestminsterSkinConsultationManager.consulationsArray.add
                                                                                                                (new Consultation(doctor3, new Patient(patientName, patientSurname, patientContact, patientDOBString, patientNIC, patientID),
                                                                                                                        selectedDateString, selectedTimeSlot, consultPrice, patientNotes, consultationID));

                                                                                                        JOptionPane.showMessageDialog(null, "Consultation booked successfully, under: "+ doctor3.getName()+" ("+doctor3.getSpecialization()+")\n Consultation Cost: £"+consultPrice, "Success", JOptionPane.INFORMATION_MESSAGE);

                                                                                                        ((DefaultTableModel) consultationTable.getModel()).addRow(new Object[]{doctor3.getName() + " " + doctor3.getSurName(),
                                                                                                                doctor3.getSpecialization(), patientName + " " + patientSurname, patientID, selectedDateString, selectedTimeSlot, "£ " + consultPrice,consultationID});

                                                                                                        // Clear the fields
                                                                                                        doctorComboBox.setSelectedIndex(0);
                                                                                                        datePicker.getModel().setSelected(false);
                                                                                                        timeSlotComboBox.setSelectedIndex(0);
                                                                                                        durationComboBox.setSelectedIndex(0);
                                                                                                        patientNameTextField.setText("");
                                                                                                        patientSurnameTextField.setText("");
                                                                                                        patientContactTextField.setText("");
                                                                                                        patientNICTextField.setText("");
                                                                                                        patientNotesTextArea.setText("");
                                                                                                        //go back to home panel
                                                                                                        mainPanel.setVisible(true);
                                                                                                        consultationsPanel.setVisible(false);
                                                                                                        return;

                                                                                                }else {
                                                                                                                WestminsterSkinConsultationManager.consulationsArray.add
                                                                                                                        (new Consultation(doctor, new Patient(patientName, patientSurname, patientContact, patientDOBString, patientNIC, patientID),
                                                                                                                                selectedDateString, selectedTimeSlot, consultPrice, patientNotes, consultationID));
                                                                                                                JOptionPane.showMessageDialog(null, "Consultation booked successfully.\n Consultation Cost :£"+consultPrice, "Success", JOptionPane.INFORMATION_MESSAGE);
                                                                                                                ((DefaultTableModel) consultationTable.getModel()).addRow(new Object[]{doctor.getName() + " " + doctor.getSurName(),
                                                                                                                        doctor.getSpecialization(), patientName + " " + patientSurname, patientID, selectedDateString, selectedTimeSlot, "£ " + consultPrice,consultationID});
                                                                                                                // Clear the fields
                                                                                                                doctorComboBox.setSelectedIndex(0);
                                                                                                                datePicker.getModel().setSelected(false);
                                                                                                                timeSlotComboBox.setSelectedIndex(0);
                                                                                                                durationComboBox.setSelectedIndex(0);
                                                                                                                patientNameTextField.setText("");
                                                                                                                patientSurnameTextField.setText("");
                                                                                                                patientContactTextField.setText("");
                                                                                                                patientNICTextField.setText("");
                                                                                                                patientNotesTextArea.setText("");
                                                                                                                //go back to home panel
                                                                                                                mainPanel.setVisible(true);
                                                                                                                consultationsPanel.setVisible(false);
                                                                                                                return;

                                                                                                }
                                                                                        }
                                                                                        break;
                                                                                }
                                                                        }
                                                                }
                                                        } catch (NumberFormatException i) {
                                                                JOptionPane.showMessageDialog(null, "Please enter a valid contact number and NIC number.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                break;
                                                        }
                                                }
                                        }
                                }
                        }
                });

                imageUploadButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
//                                // Create a file chooser
//                                JFileChooser fileChooser = new JFileChooser();
//                                fileChooser.setDialogTitle("Choose an image");
//                                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//                                fileChooser.setAcceptAllFileFilterUsed(false);
//                                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
//                                fileChooser.addChoosableFileFilter(filter);
//                                int returnValue = fileChooser.showOpenDialog(null);
//                                if (returnValue == JFileChooser.APPROVE_OPTION) {
//                                        File selectedFile = fileChooser.getSelectedFile();
//                                        String filePath = selectedFile.getAbsolutePath();
//                                        ImageIcon imageIcon = new ImageIcon(filePath);
//                                        Image image = imageIcon.getImage();
//                                        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//                                        imageIcon = new ImageIcon(newImage);
//                                        patientImageLabel.setIcon(imageIcon);
//                                        patientImageLabel.setText("");
//                                }
                        }
                });

                // Add a mouse listener to the table to detect when a row is clicked
                consultationTable.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                int row = consultationTable.rowAtPoint(evt.getPoint());
                                int col = consultationTable.columnAtPoint(evt.getPoint());
                                if (row >= 0 && col >= 0) {
                                        // Get the value of the cell at the clicked location
                                        Object value = consultationTable.getValueAt(row, col);
                                        // Get the consultation ID of the selected row
                                        detailsModel.addRow(new Object[]{"ID", consultationTable.getValueAt(row, 0)});
                                        detailsModel.addRow(new Object[]{"Name", consultationTable.getValueAt(row, 1)});
                                        detailsModel.addRow(new Object[]{"Details", consultationTable.getValueAt(row, 2)});


                                        // Show details in new panel

                                        bookedConsultationsPanel.setVisible(false);
                                        checkConsultationPanel.setVisible(true);

//                                        // Display the details table in a separate window or panel
//                                        JFrame detailsFrame = new JFrame();
//                                        detailsFrame.add(new JScrollPane(detailsTable));
//                                        detailsFrame.pack();
//                                        frame.add(detailsFrame);
//                                        detailsFrame.setVisible(true);


                                }
                        }
                });
        }
}