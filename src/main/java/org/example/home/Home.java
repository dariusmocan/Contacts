package org.example.home;

import org.example.search.SearchContacts;
import org.example.contact.ViewContacts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Represents the main frame for the application's homepage.
 */
public class Home extends JFrame {

    /**
     * Button for accessing contact management functionality.
     */
    private JButton viewButton;

    /**
     * Button for searching contacts.
     */
    private JButton searchButton;

    /**
     * DefaultListModel to store and manage contact information.
     */
    private DefaultListModel<String> lista;

    /**
     * JList for displaying the list of contacts.
     */
    private JList<String> listaContacte;

    /**
     * Constructor for the home class.
     *
     * @throws FileNotFoundException If the specified file is not found.
     */
    public Home() throws FileNotFoundException {
        super("Homepage");
        this.setSize(320, 200);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        viewButton = new JButton("Contact management");
        viewButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(viewButton);

        searchButton = new JButton("Search contacts");
        searchButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.add(searchButton);

        lista = new DefaultListModel<>();
        File file = new File("src/test/contacte.txt");
        Scanner scanner = new Scanner(file);

        List<String> aux = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            aux = List.of(s.split(";"));
            String stringAux = aux.get(0) + " " + aux.get(1) + " " + aux.get(2);
            lista.addElement(stringAux);
        }

        listaContacte = new JList<>(lista);

        // Wrap the JList in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(listaContacte);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Set the preferred size of the JScrollPane
        scrollPane.setPreferredSize(new Dimension(300, 120));

        // Add the JScrollPane to the frame
        this.add(scrollPane);


        ActionListener viewAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ViewContacts viewContacts = new ViewContacts();
                    viewContacts.setVisible(true);
                    viewContacts.setLocationRelativeTo(null);

                    //viewContacts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        };
        viewButton.addActionListener(viewAction);

        ActionListener searchAction=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SearchContacts searchContacts = new SearchContacts();
                    searchContacts.setVisible(true);
                    searchContacts.setLocationRelativeTo(null);
                }catch (FileNotFoundException ex){
                    throw new RuntimeException(ex);
                }
            }
        };
        searchButton.addActionListener(searchAction);
    }


}
