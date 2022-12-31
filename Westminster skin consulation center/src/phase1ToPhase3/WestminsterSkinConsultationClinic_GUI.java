package phase1ToPhase3;

//importing relevant libraries
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            JLabel background=new JLabel(new ImageIcon("backdrop.jpeg"));
            background.setBounds(0,0,750,500);

            //creating buttons
            JButton ConsultationButton = new JButton("Book consultation");
            JButton doctorListButton = new JButton("Doctor list");
            JButton bookedConsultationsButton = new JButton("currently Booked consultations");
            JButton backButton1 = new JButton("< Back");
            JButton backButton2 = new JButton("< Back");
            JButton backButton3 = new JButton("< Back");

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
                    doctorTableModel.addRow(new Object[] {doctor.getName(), doctor.getSurName(), doctor.getMobileNumber(), doctor.getDateOfBirth(), doctor.getNIC(), doctor.getSpecialization(), doctor.getMedicalLicenseNumber()});
            }

            //creating doctor table
            JTable doctorTable = new JTable(doctorTableModel);
            doctorTable.setBounds(0, 0, 750, 500);
            doctorTable.setRowHeight(45);
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


            JLabel doctorLabel = new JLabel("Select doctor");
            doctorLabel.setBounds(35, 40, 300, 50);
            doctorLabel.setFont(new Font("poppins", Font.PLAIN, 16));

            JLabel SelectedDoctorLabel = new JLabel("Selected doctor Name");
            SelectedDoctorLabel.setBounds(335, 40, 300, 50);
            SelectedDoctorLabel.setFont(new Font("poppins", Font.PLAIN, 16));



            //creating main panel
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            //creating sub panels
            JPanel consultationsPanel = new JPanel();
            consultationsPanel.setLayout(null);
            consultationsPanel.setPreferredSize(new Dimension(750, 500));

            JPanel doctorListPanel = new JPanel();
            doctorListPanel.setLayout(new BorderLayout());
            doctorListPanel.setPreferredSize(new Dimension(750, 500));


            JPanel bookedConsultationsPanel = new JPanel();
            bookedConsultationsPanel.setLayout(new BorderLayout());

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
            consultationsPanel.add(doctorLabel, BorderLayout.CENTER);
            consultationsPanel.add(doctorComboBox);
            consultationsPanel.add(SelectedDoctorLabel, BorderLayout.CENTER);

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

            doctorComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            String selectedDoctor = (String) doctorComboBox.getSelectedItem();
                            for (Doctor doctor : WestminsterSkinConsultationManager.doctorArray) {
                                    if (doctor.getMedicalLicenseNumber().equals(selectedDoctor)) {
                                            SelectedDoctorLabel.setText("Selected doctor: " + doctor.getName() + " " + doctor.getSurName());
                                    }
                            }
                    }
            });
    }
}