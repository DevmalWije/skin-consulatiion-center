package phase1ToPhase3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WestminsterSkinConsultationClinic_GUI {
    public static void main(String[] args) {

        //setting header label

        JLabel HeaderLabel = new JLabel("Westminster Skin");
        JLabel HeaderLabel2 = new JLabel("consultation Clinic");

        HeaderLabel.setBounds(430, 40, 500, 100);
        HeaderLabel2.setBounds(420, 70, 500, 100);

        HeaderLabel.setFont(new Font("poppins", Font.PLAIN, 30));
        HeaderLabel.setForeground(new Color(0x123456));
        HeaderLabel2.setFont(new Font("poppins", Font.PLAIN, 30));
        HeaderLabel2.setForeground(new Color(0x123456));

        JLabel background=new JLabel(new ImageIcon("backdrop.jpeg"));
        background.setBounds(0,0,750,500);



        //creating buttons
        JButton bookConsultationButton = new JButton("Book consultation");
        JButton doctorListButton = new JButton("Doctor list");
        JButton bookedConsultationsButton = new JButton("currently Booked consultations");

        bookConsultationButton.setBounds(410, 180, 300, 50);
        doctorListButton.setBounds(410, 250, 300, 50);
        bookedConsultationsButton.setBounds(410, 320, 300, 50);


        //Creating object of MyFrame class
        JFrame frame = new JFrame("Westminster Skin Consultation Clinic");
        frame.setSize(750, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.add(bookConsultationButton);
        frame.add(doctorListButton);
        frame.add(bookedConsultationsButton);
        frame.add(HeaderLabel2);
        frame.add(HeaderLabel);
//        frame.add(buttonPanel);
        frame.add(background);
        frame.setVisible(true);

//        bookedConsultationsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//                JFrame bookedConsultationsFrame = new JFrame("Booked Consultations");
//                bookedConsultationsFrame.setSize(750, 500);
//                bookedConsultationsFrame.setLayout(null);
//                bookedConsultationsFrame.setVisible(true);
//                bookedConsultationsFrame.setLocationRelativeTo(null);
//                bookedConsultationsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            }
//        });

        
    }
}

