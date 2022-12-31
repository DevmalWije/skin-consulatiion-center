package phase1ToPhase3;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class WestminsterSkinConsultationClinic_GUI {
//    public static void main(String[] args) {
//
//        //setting header label
//
//        JLabel HeaderLabel = new JLabel("Westminster Skin");
//        JLabel HeaderLabel2 = new JLabel("consultation Clinic");
//
//        HeaderLabel.setBounds(430, 40, 500, 100);
//        HeaderLabel2.setBounds(420, 70, 500, 100);
//
//        HeaderLabel.setFont(new Font("poppins", Font.PLAIN, 30));
//        HeaderLabel.setForeground(new Color(0x123456));
//        HeaderLabel2.setFont(new Font("poppins", Font.PLAIN, 30));
//        HeaderLabel2.setForeground(new Color(0x123456));
//
//        JLabel background=new JLabel(new ImageIcon("backdrop.jpeg"));
//        background.setBounds(0,0,750,500);
//
//
//
//        //creating buttons
//        JButton ConsultationButton = new JButton("Book consultation");
//        JButton doctorListButton = new JButton("Doctor list");
//        JButton bookedConsultationsButton = new JButton("currently Booked consultations");
//
//        ConsultationButton.setBounds(410, 180, 300, 50);
//        ConsultationButton.setFont(new Font("poppins", Font.PLAIN, 16));
//
//        doctorListButton.setBounds(410, 250, 300, 50);
//        doctorListButton.setFont(new Font("poppins", Font.PLAIN, 16));
//
//        bookedConsultationsButton.setBounds(410, 320, 300, 50);
//        bookedConsultationsButton.setFont(new Font("poppins", Font.PLAIN, 16));
//
//        JPanel mainPanel = new JPanel();
//        mainPanel.setSize(750, 500);
//        mainPanel.setLayout(new CardLayout());
//
//        JPanel consultationsPanel = new JPanel();
//        JPanel doctorListPanel = new JPanel();
//        JPanel bookedConsultationsPanel = new JPanel();
//
//        mainPanel.add(ConsultationButton);
//        mainPanel.add(doctorListButton);
//        mainPanel.add(bookedConsultationsButton);
//        mainPanel.add(HeaderLabel2);
//        mainPanel.add(HeaderLabel);
//        mainPanel.add(background);
//        mainPanel.add(consultationsPanel, "Consultations Panel");
//        mainPanel.add(doctorListPanel, "Doctor List Panel");
//        mainPanel.add(bookedConsultationsPanel, "Booked Consultations Panel");
//
//        //Creating object of MyFrame class
//        JFrame frame = new JFrame("Westminster Skin Consultation Clinic");
//        frame.setSize(750, 500);
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
//        frame.add(mainPanel);
//        frame.setVisible(true);
////        frame.add(ConsultationButton);
////        frame.add(doctorListButton);
////        frame.add(bookedConsultationsButton);
////        frame.add(HeaderLabel2);
////        frame.add(HeaderLabel);
////        frame.add(background);
//        ConsultationButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //Switch to Consultations Panel
//                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
//                cardLayout.show(mainPanel, "Consultations Panel");
//            }
////                JPanel ConsultationsFrame = new JPanel();
////                ConsultationsFrame.setSize(750, 500);
////                ConsultationsFrame.setLayout(null);
////                ConsultationsFrame.setVisible(true);
////                frame.add(ConsultationsFrame);
////                ConsultationsFrame.setLocationRelativeTo(null);
////                ConsultationsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
//        });
//        doctorListButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                frame.dispose();
////                JFrame doctorListFrame = new JFrame("Doctor List");
////                doctorListFrame.setSize(750, 500);
////                doctorListFrame.setLayout(null);
////                doctorListFrame.setVisible(true);
////                doctorListFrame.setLocationRelativeTo(null);
////                doctorListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                //Switch to Doctor List Panel
//                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
//                cardLayout.show(mainPanel, "Doctor List Panel");
//            }
//        });
//        bookedConsultationsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                frame.dispose();
////                JFrame bookedConsultationsFrame = new JFrame("Booked Consultations");
////                bookedConsultationsFrame.setSize(750, 500);
////                bookedConsultationsFrame.setLayout(null);
////                bookedConsultationsFrame.setVisible(true);
////                bookedConsultationsFrame.setLocationRelativeTo(null);
////                bookedConsultationsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                //Switch to Booked Consultations Panel
//                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
//                cardLayout.show(mainPanel, "Booked Consultations Panel");
//            }
//        });
//
//    }
//}
//

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

            //setting button bounds
            ConsultationButton.setBounds(410, 180, 300, 50);
            ConsultationButton.setFont(new Font("poppins", Font.PLAIN, 16));

            doctorListButton.setBounds(410, 250, 300, 50);
            doctorListButton.setFont(new Font("poppins", Font.PLAIN, 16));

            bookedConsultationsButton.setBounds(410, 320, 300, 50);
            bookedConsultationsButton.setFont(new Font("poppins", Font.PLAIN, 16));

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

            for (Doctor doctor : WestminsterSkinConsultationManager.doctorArray) {
                    doctorTableModel.addRow(new Object[] {doctor.getName(), doctor.getSurName(), doctor.getMobileNumber(), doctor.getDateOfBirth(), doctor.getNIC(), doctor.getSpecialization(), doctor.getMedicalLicenseNumber()});
            }

            //creating doctor table
            JTable doctorTable = new JTable(doctorTableModel);
            doctorTable.setBounds(0, 0, 750, 500);
            doctorTable.setRowHeight(45);
            doctorTable.setFont(new Font("poppins", Font.PLAIN, 13));

            JTableHeader doctorTableHeader = doctorTable.getTableHeader();
            doctorTableHeader.setFont(new Font("poppins", Font.PLAIN, 13));
            doctorTableHeader.setBackground(new Color(0x123456));
            doctorTableHeader.setForeground(Color.WHITE);

            doctorTable.setBackground(new Color(121, 152, 201));
            doctorTable.setForeground(Color.WHITE);

            //creating main panel
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            //creating sub panels
            JPanel consultationsPanel = new JPanel();
            consultationsPanel.setLayout(new BorderLayout());

            JPanel doctorListPanel = new JPanel();
            doctorListPanel.setLayout(new BorderLayout());
            doctorListPanel.setPreferredSize(new Dimension(750, 500));

            JPanel bookedConsultationsPanel = new JPanel();
            consultationsPanel.setLayout(new BorderLayout());

            //adding components to  "main" panel
            mainPanel.add(ConsultationButton);
            mainPanel.add(doctorListButton);
            mainPanel.add(bookedConsultationsButton);
            mainPanel.add(HeaderLabel);
            mainPanel.add(HeaderLabel2);
            mainPanel.add(background);

            //adding components to "doctorListPanel" panel
            doctorListPanel.add(new JScrollPane(doctorTable), BorderLayout.CENTER);

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

    }
}