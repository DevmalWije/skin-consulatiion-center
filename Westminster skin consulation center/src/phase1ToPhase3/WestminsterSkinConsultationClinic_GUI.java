package phase1ToPhase3;

//importing relevant libraries
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;



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
                JButton bookButton = new JButton("Book consultation");

                //setting button bounds
                ConsultationButton.setBounds(410, 180, 300, 50);
                ConsultationButton.setFont(new Font("poppins", Font.PLAIN, 16));

                doctorListButton.setBounds(410, 250, 300, 50);
                doctorListButton.setFont(new Font("poppins", Font.PLAIN, 16));

                bookedConsultationsButton.setBounds(410, 320, 300, 50);
                bookedConsultationsButton.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton1.setBounds(0, 0, 300, 50);
                backButton1.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton2.setBounds(0, 0, 734, 40);
                backButton2.setFont(new Font("poppins", Font.PLAIN, 16));

                backButton3.setBounds(0, 0, 300, 50);
                backButton3.setFont(new Font("poppins", Font.PLAIN, 16));

                bookButton.setBounds(280, 395, 200, 40);
                bookButton.setFont(new Font("poppins", Font.PLAIN, 16));


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
                for (Doctor doctor : WestminsterSkinConsultationManager.doctorArray) {
                        doctorTableModel.addRow(new Object[]{doctor.getName(), doctor.getSurName(), doctor.getMobileNumber(), doctor.getDateOfBirth(), doctor.getNIC(), doctor.getSpecialization(), doctor.getMedicalLicenseNumber()});
                }

                //creating doctor table
                JTable doctorTable = new JTable(doctorTableModel);
                doctorTable.setBounds(0, 0, 750, 500);
                doctorTable.setRowHeight(45);
                doctorTable.setEnabled(false);
                doctorTable.setFont(new Font("poppins", Font.PLAIN, 13));

                JTableHeader doctorTableHeader = doctorTable.getTableHeader();
                doctorTableHeader.setFont(new Font("poppins", Font.BOLD, 13));
                doctorTableHeader.setBackground(new Color(0x123456));
                doctorTableHeader.setForeground(Color.WHITE);

                doctorTable.setBackground(new Color(121, 152, 201));
                doctorTable.setForeground(Color.WHITE);


                //creating combobox for doctor selection
                JComboBox<String> doctorComboBox = new JComboBox<>();
                doctorComboBox.setBounds(150, 50, 150, 30);


                //adding doctors to combobox
                for (Doctor doctor : WestminsterSkinConsultationManager.doctorArray) {
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
                durationComboBox.setBounds(600, 100, 100, 30);
                durationComboBox.addItem("30 minutes");
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

                JLabel ConsultationDurationLabel = new JLabel("Duration in hrs :");
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

                //adding components to "doctorListPanel" panel
                doctorListPanel.add(new JScrollPane(doctorTable), BorderLayout.CENTER);
                doctorListPanel.add(backButton1, BorderLayout.NORTH);

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
                consultationsPanel.add(patientNotesLabel);
                consultationsPanel.add(patientNotesTextArea);
                consultationsPanel.add(selectedDoctorField);
                consultationsPanel.add(bookButton);

                //adding components to "bookedConsultationsPanel" panel
                bookedConsultationsPanel.add(backButton3, BorderLayout.NORTH);


                //Making container panel
                JPanel containerPanel = new JPanel();
                containerPanel.setLayout(new CardLayout());

                //adding sub panels to container panel
                containerPanel.add(mainPanel, "Main Panel");
                containerPanel.add(consultationsPanel, "Consultations Panel");
                containerPanel.add(doctorListPanel, "Doctor List Panel");
                containerPanel.add(bookedConsultationsPanel, "Booked Consultations Panel");

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
                        }
                };

                //adding action listener to back buttons
                backButton1.addActionListener(backButtonListener);
                backButton2.addActionListener(backButtonListener);
                backButton3.addActionListener(backButtonListener);

                //adding action listener to doctor combobox
                doctorComboBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String selectedDoctor = (String) doctorComboBox.getSelectedItem();
                                for (Doctor doctor : WestminsterSkinConsultationManager.doctorArray) {
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
                                // Get the selected doctor
                                String selectedDoctor = (String) doctorComboBox.getSelectedItem();
                                Doctor doctor = null;
                                for (Doctor doctor1 : WestminsterSkinConsultationManager.doctorArray) {
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
                                double duration = 0;
                                assert selectedDuration != null;
                                switch (selectedDuration) {
                                        case "30 minutes" -> duration = 0.5;
                                        case "1 hour" -> duration = 1;
                                        case "1 hour 30" -> duration = 1.5;
                                        case "2 hours" -> duration = 2;
                                }

                                double consultPrice=duration*25;



                                // Get the patient name
                                String patientName = patientNameTextField.getText();

                                // Get the patient surname
                                String patientSurname = patientSurnameTextField.getText();
                                // Get the patient date of birth
                                Date patientDOB = (Date) DOBDatePicker.getModel().getValue();
                                String patientDOBString = new SimpleDateFormat("dd/MM/yyyy").format(patientDOB);

                                // Get the patient contact number
                                String patientContact = patientContactTextField.getText();
                                System.out.println(patientContact);

                                // Get the patient NIC
                                String patientNIC = patientNICTextField.getText();
                                System.out.println(patientNIC);

                                // Get the patient notes
                                String patientNotes = patientNotesTextArea.getText();

                                while (true){
                                        if(selectedDoctor==null|| selectedDate==null||patientDOB==null||selectedTimeSlot==null||patientName.isEmpty()||patientSurname.isEmpty()||patientContact.isEmpty()||patientNIC.isEmpty()||patientNotes.isEmpty()){
                                                JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                                                break;
                                        }
                                        else{
                                                try{
                                                        if (patientContact.isEmpty()  || patientNIC.isEmpty() ) {
                                                                JOptionPane.showMessageDialog(null, "Please enter a valid contact number and NIC number.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                break;
                                                        }
                                                        else {
                                                                for (Doctor doctor1 : WestminsterSkinConsultationManager.doctorArray) {
                                                                        if (doctor1.getMedicalLicenseNumber().equals(selectedDoctor)) {
                                                                                doctor = doctor1;
                                                                                for (Consultation consultation : WestminsterSkinConsultationManager.consulationsArray) {
                                                                                        if (consultation.getConsultationDate().equals(selectedDateString) && consultation.getConsultationTime().equals(selectedTimeSlot)) {
                                                                                                JOptionPane.showMessageDialog(null, "The selected doctor is not available at the selected time slot.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                                return;
                                                                                        }else {
                                                                                                if (WestminsterSkinConsultationManager.consulationsArray.size() <= 20) {
                                                                                                        WestminsterSkinConsultationManager.consulationsArray.add
                                                                                                                (new Consultation(doctor, new Patient(patientName, patientSurname, patientContact, patientDOBString, patientNIC, "30024425v2"),
                                                                                                                        selectedDateString, selectedTimeSlot, consultPrice, patientNotes));
                                                                                                        JOptionPane.showMessageDialog(null, "Consultation booked successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                                                                        System.out.println(WestminsterSkinConsultationManager.consulationsArray.toString());
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

                                                                                                } else {
                                                                                                        JOptionPane.showMessageDialog(null, "The maximum number of consultations has been reached.", "Error", JOptionPane.ERROR_MESSAGE);
                                                                                                        break;
                                                                                                }
                                                                                        }
                                                                                }
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                }catch (NumberFormatException i){
                                                        JOptionPane.showMessageDialog(null, "Please enter a valid contact number and NIC number.", "Error", JOptionPane.ERROR_MESSAGE);
                                                        break;
                                                }
                                        }
                                }
                        }
                });
        }
}