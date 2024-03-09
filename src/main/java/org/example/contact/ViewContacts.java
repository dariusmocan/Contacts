package org.example.contact;

import org.example.contact.ContactTelefonic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Represents a JFrame for managing and viewing contact information.
 */
public class ViewContacts extends JFrame {
    /**
     * List to store contactTelefonic objects.
     */
    private List<ContactTelefonic> contacte;

    /**
     * Current position in the list of contacts.
     */
    private int position;

    /**
     * Label for the "Nume" (Name) field.
     */
    private JLabel numeEticheta;

    /**
     * Label for the "Numar" (Number) field.
     */
    private JLabel numarEticheta;

    /**
     * Label for the "Adresa" (Address) field.
     */
    private JLabel adresaEticheta;

    /**
     * Text field for entering the name.
     */
    private JTextField campNume;

    /**
     * Text field for entering the number.
     */
    private JTextField campNumar;

    /**
     * Text field for entering the address.
     */
    private JTextField campAdresa;

    /**
     * Button for moving to the previous contact.
     */
    private JButton buttonPrevious;

    /**
     * Button for moving to the next contact.
     */
    private JButton buttonNext;

    /**
     * Button for adding a new contact.
     */
    private JButton buttonAdd;

    /**
     * Button for deleting the current contact.
     */
    private JButton buttonDelete;

    /**
     * Button for editing the current contact.
     */
    private JButton buttonEdit;

    /**
     * Reads contacts from a file and returns a list of contactTelefonic objects.
     *
     * @return List of contactTelefonic objects read from the file.
     * @throws FileNotFoundException If the specified file is not found.
     */
    public List<ContactTelefonic> getContacts() throws FileNotFoundException {
        File file=new File("src/test/contacte.txt");
        Scanner sc=new Scanner(file);
        List<ContactTelefonic> contacts=new ArrayList<>();
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            List<String>lista=new ArrayList<>();
            lista=List.of(s.split(";"));
            ContactTelefonic c = new ContactTelefonic(lista.get(0),lista.get(1),lista.get(2));
            contacts.add(c);
        }
        return contacts;
    }
    /**
     * Constructor for the viewContacts class.
     *
     * @throws FileNotFoundException If the specified file is not found.
     */

    public ViewContacts() throws FileNotFoundException {
        super("GESTIUNE CONTACTE");
        this.setSize(350, 200);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.contacte = new ArrayList<>();
        this.position=-1;
        File file=new File("src/test/contacte.txt");
        Scanner sc=new Scanner(file);

        while (sc.hasNextLine()){
            String s=sc.nextLine();
            List<String>lista=new ArrayList<>();
            lista=List.of(s.split(";"));
            ContactTelefonic c = new ContactTelefonic(lista.get(0),lista.get(1),lista.get(2));
            contacte.add(c);
        }

        numeEticheta=new JLabel("Nume:");
        numeEticheta.setHorizontalAlignment(SwingUtilities.RIGHT);
        numeEticheta.setPreferredSize(new Dimension(70, 12));

        numarEticheta=new JLabel("Numar:");
        numarEticheta.setHorizontalAlignment(SwingUtilities.RIGHT);
        numarEticheta.setPreferredSize(new Dimension(70,12));

        adresaEticheta=new JLabel("Gmail:");
        adresaEticheta.setHorizontalAlignment(SwingUtilities.RIGHT);
        adresaEticheta.setPreferredSize(new Dimension(70,12));

        campNume=new JTextField(20);
        campNumar=new JTextField(20);
        campAdresa=new JTextField(20);
        this.add(numeEticheta);
        this.add(campNume);
        this.add(numarEticheta);
        this.add(campNumar);
        this.add(adresaEticheta);
        this.add(campAdresa);

        buttonAdd=new JButton("Add");
        buttonDelete=new JButton("Delete");
        buttonNext=new JButton("Next");
        buttonPrevious=new JButton("Previous");
        buttonEdit=new JButton("Edit");

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(320, 40));
        panel.add(buttonAdd);
        panel.add(buttonEdit);
        panel.add(buttonDelete);
        this.add(panel);

        JPanel panelStanga = new JPanel();
        JPanel panelDreapta = new JPanel();
        panelStanga.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelDreapta.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelStanga.setPreferredSize(new Dimension(160, 40));
        panelDreapta.setPreferredSize(new Dimension(160, 40));
        panelStanga.add(buttonPrevious);
        panelDreapta.add(buttonNext);
        this.add(panelStanga);
        this.add(panelDreapta);

        ActionListener addAction = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nume = campNume.getText();
                String numar = campNumar.getText();
                String adresa = campAdresa.getText();

                ContactTelefonic c = new ContactTelefonic(nume, numar, adresa);
                contacte.add(c);

                campNume.setText("");
                campNumar.setText("");
                campAdresa.setText("");

                try {
                    FileWriter writer = new FileWriter("src/test/contacte.txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);

                    for (ContactTelefonic contact : contacte)
                        bufferedWriter.write(contact.getNume() + ";" + contact.getNumar() + ";" + contact.getAdresa() + ";\n");
                    bufferedWriter.close();
                    writer.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }

        };

        ActionListener editAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nume = campNume.getText();
                String numar = campNumar.getText();
                String adresa = campAdresa.getText();
                ContactTelefonic c = new ContactTelefonic(nume, numar, adresa);

                /*contactTelefonic cInitial = contacte.get(position);
                System.out.println(cInitial);
                System.out.println(c);*/

                contacte.get(position).setNume(nume);
                contacte.get(position).setNumar(numar);
                contacte.get(position).setAdresa(adresa);


                try {
                    FileWriter writer = new FileWriter("src/test/contacte.txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);

                    for (ContactTelefonic contact : contacte)
                        bufferedWriter.write(contact.getNume() + ";" + contact.getNumar() + ";" + contact.getAdresa() + ";\n");
                    bufferedWriter.close();
                    writer.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }



            }
        };

        ActionListener deleteAction = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nume = campNume.getText();
                String numar = campNumar.getText();
                String adresa = campAdresa.getText();

                ContactTelefonic c = new ContactTelefonic(nume, numar, adresa);


                for (int i = 0; i < contacte.size(); i++) {
                    if (contacte.get(i).getNume().equals(c.getNume())) {
                        contacte.remove(i);
                        break;
                    }
                }

                try {
                    FileWriter writer = new FileWriter("src/test/contacte.txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);

                    for (ContactTelefonic contact : contacte)
                        bufferedWriter.write(contact.getNume() + ";" + contact.getNumar() + ";" + contact.getAdresa() + ";\n");
                    bufferedWriter.close();
                    writer.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

                campNume.setText("");
                campNumar.setText("");
                campAdresa.setText("");
            }
        };


        ActionListener nextAction = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (contacte.size() == 0) {

                }

                if (position < contacte.size() - 1) {
                    position++;
                    ContactTelefonic c = contacte.get(position);

                    String nume = c.getNume();
                    String numar = c.getNumar();
                    String adresa = c.getAdresa();

                    campNume.setText(nume);
                    campNumar.setText(numar);
                    campAdresa.setText(adresa);

                }
            }
        };

        ActionListener previousAction = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (contacte.size() == 0) {

                }

                if (position > 0) {
                    position--;
                    ContactTelefonic c = contacte.get(position);

                    String nume = c.getNume();
                    String numar = c.getNumar();
                    String adresa = c.getAdresa();

                    campNume.setText(nume);
                    campNumar.setText(numar);
                    campAdresa.setText(adresa);

                }
            }
        };

        buttonAdd.addActionListener(addAction);
        buttonEdit.addActionListener(editAction);
        buttonDelete.addActionListener(deleteAction);
        buttonNext.addActionListener(nextAction);
        buttonPrevious.addActionListener(previousAction);


    }

}
