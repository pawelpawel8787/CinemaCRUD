package com.mojafirma.viewGUI;

import com.mojafirma.model.Movie;
import com.mojafirma.model.Reservation;
import com.mojafirma.model.Showing;
import com.mojafirma.model.dao.MovieDAOImplement;
import com.mojafirma.model.dao.ReservationDAOImplement;
import com.mojafirma.utility.ComboBoxModelInit;
import com.mojafirma.utility.ShowingListModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ReservationDataInput extends JFrame {
    private JPanel panel1;
    private JCheckBox a10CheckBox;
    private JCheckBox a3CheckBox;
    private JCheckBox a4CheckBox;
    private JCheckBox a5CheckBox;
    private JCheckBox a6CheckBox;
    private JCheckBox a7CheckBox;
    private JCheckBox a11CheckBox;
    private JCheckBox a12CheckBox;
    private JCheckBox a14CheckBox;
    private JCheckBox a9CheckBox;
    private JCheckBox a8CheckBox;
    private JCheckBox a1CheckBox;
    private JCheckBox a2CheckBox;
    private JCheckBox a15CheckBox;
    private JCheckBox a22CheckBox;
    private JCheckBox a13CheckBox;
    private JCheckBox a21CheckBox;
    private JCheckBox a20CheckBox;
    private JCheckBox a19CheckBox;
    private JCheckBox a18CheckBox;
    private JCheckBox a17CheckBox;
    private JCheckBox a16CheckBox;
    private JCheckBox a28CheckBox;
    private JCheckBox a27CheckBox;
    private JCheckBox a26CheckBox;
    private JCheckBox a25CheckBox;
    private JCheckBox a24CheckBox;
    private JCheckBox a23CheckBox;
    private JTextField nameField;
    private JTextField surnameField;
    private JComboBox comboBox1;
    private JList showingListField;
    private JButton bookAShowButton;
    private JPanel boxesPanel;
    private JComboBox chooseTicketBocmboBox;

    public ReservationDataInput() {

        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(1000, 800);
        setLocationRelativeTo(null);



        initBox();
        initReservation();

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Movie chooser = (Movie) comboBox1.getSelectedItem();
                showingListField.setModel(new ShowingListModel(chooser.getShowings()));

            }
        });
        bookAShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initReservation();
                ReservationDAOImplement reservationDAOImplement = new ReservationDAOImplement();
                Reservation reservation = new Reservation();
                Showing chooser1 = (Showing) showingListField.getSelectedValue();


                JCheckBox[] array = new JCheckBox[boxesPanel.getComponents().length];
                for (int i = 0; i < boxesPanel.getComponents().length; i++) {
                    array[i] = ((JCheckBox) boxesPanel.getComponents()[i]);
                }


                for (JCheckBox result : array
                        ) {
                    initReservation();
                    if (result.isSelected()) {

                        result.setEnabled(false);
                        result.setBackground(Color.blue);
                        reservation.setSeatNumber(Integer.parseInt(result.getText()));
                        reservation.setName(nameField.getText());
                        reservation.setSurname(surnameField.getText());
                        reservation.setShowing(chooser1);
                        reservationDAOImplement.addReservation(reservation);
                        result.setSelected(false);
                        dispose();
                        new ReservationDataInput();

                    }

                }
                initReservation();
            }

        });


    }

    public void initReservation() {

        ArrayList<JCheckBox> checkBoxesArrayList = new ArrayList<>();
        for (int i = 0; i < boxesPanel.getComponents().length; i++) {
            checkBoxesArrayList.add((JCheckBox) boxesPanel.getComponents()[i]);
        }


        Reservation reservation = new Reservation();
        showingListField.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                JList<Showing> showingsList = (JList<Showing>) e.getSource();

                Showing selectedShowing = showingsList.getSelectedValue();
                reservation.setShowing(selectedShowing);

                if (!e.getValueIsAdjusting() && !showingsList.isSelectionEmpty()) {

                    List<Reservation> bookedTickets = selectedShowing.getReservations();

                    for (int i = 0; i < checkBoxesArrayList.size(); i++) {
                        checkBoxesArrayList.get(i).setEnabled(true);
                        checkBoxesArrayList.get(i).setBackground(new Color(232, 229, 29));
                        checkBoxesArrayList.get(i).setSelected(false);

                    }

                    for (int i = 0; i < bookedTickets.size(); i++) {
                        for (int j = 0; j < checkBoxesArrayList.size(); j++) {
                            if (bookedTickets.get(i).getSeatNumber() == Integer.parseInt(checkBoxesArrayList.get(j).getText())) {
                                checkBoxesArrayList.get(j).setEnabled(false);
                                checkBoxesArrayList.get(j).setBackground(Color.RED);
                            }
                        }
                    }
                }
            }
        });
    }

    private void initBox() {

        MovieDAOImplement movieDAOImplement = new MovieDAOImplement();
        comboBox1.setModel(new ComboBoxModelInit(movieDAOImplement.getMovieList()));
        comboBox1.setSelectedItem(ListSelectionModel.SINGLE_SELECTION);

    }
}
