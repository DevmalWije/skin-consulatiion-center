//package phase1ToPhase3;
//
//import java.awt.*;
//import java.util.Calendar;
//import javax.swing.*;
//import java.util.Calendar;
//import java.util.Properties;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import org.jdatepicker.JDatePicker;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;
//public class ConsultationForm extends JPanel {
//    private JList<String> doctorList;
//    private JDatePicker calendar;
//    private JTextField durationField;
//    private JTextField patientNameField;
//    private JTextField patientSurnameField;
//    private JTextField patientDOBField;
//    private JTextField patientMobileField;
//    private JTextField patientNICField;
//    private JTextArea notesField;
//
//    public ConsultationForm() {
//        setLayout(new GridBagLayout());
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.insets = new Insets(5, 5, 5, 5);
//
//        // Add a label and JList for selecting the doctor
//        constraints.anchor = GridBagConstraints.WEST;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        add(new JLabel("Doctor: "), constraints);
//
//        String[] doctorNames = {"Dr. John Smith", "Dr. Jane Doe", "Dr. Bob Johnson"};
//        doctorList = new JList<>(doctorNames);
//        constraints.gridx = 1;
//        constraints.gridy = 0;
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        add(doctorList, constraints);
//
//        // Add a label and JCalendar for selecting the date
//        constraints.gridx = 0;
//        constraints.gridy = 1;
//        add(new JLabel("Date: "), constraints);
//
//        calendar = new JCalendar();
//        calendar.setCalendar(Calendar.getInstance());
//        constraints.gridx = 1;
//        constraints.gridy = 1;
//        add(calendar, constraints);
//
//        // Add a label and text field for entering the duration of the consultation
//        constraints.gridx = 0;
//        constraints.gridy = 2;
//        add(new JLabel("Duration (minutes): "), constraints);
//
//        durationField = new JTextField(5);
//        constraints.gridx = 1;
//        constraints.gridy = 2;
//        add(durationField, constraints);
//
//        // Add a label and text field for entering the patient's name
//        constraints.gridx = 0;
//        constraints.gridy = 3;
//        add(new JLabel("Name: "), constraints);
//
//        patientNameField = new JTextField(20);
//        constraints.gridx = 1;
//        constraints.gridy = 3;
//        add(patientNameField, constraints);
//
//        // Add a label and text field for entering the patient's surname
//        constraints.gridx = 0;
//        constraints.gridy = 4;
//        add(new JLabel("Surname: "), constraints);
//
//        patientSurnameField = new JTextField(20);
//        constraints.gridx = 1;
//        constraints.gridy = 4;
//        add(patientSurnameField, constraints);
//
//        // Add a label and text field for entering the
