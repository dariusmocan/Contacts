package org.example.search;

import org.example.contact.ContactTelefonic;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Result extends JFrame {
    /**
     * Label for the "rezultat" field.
     */
    private JLabel rezultat;
    /**
     * Label for the "Nume" field.
     */
    private JLabel nume;

    /**
     * Label for the "Numar" field.
     */
    private JLabel numar;
    /**
     * Label for the "adres" field.
     */
    private JLabel adresa;

    /**
     * Constructor for the result class.
     *
     * @throws FileNotFoundException If the specified file is not found.
     */
    public Result(String name, String number) throws FileNotFoundException {
        super("Contact");
        this.setSize(350, 200);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);  // Changed to Y_AXIS
        panel.setLayout(boxlayout);

        if (Objects.equals(name, "") && Objects.equals(number, "")) {
            rezultat = new JLabel("Introduceti numele sau numarul!");
            panel.add(rezultat);
        } else {
            rezultat = new JLabel("");

            nume = new JLabel("");
            nume.setHorizontalAlignment(SwingUtilities.RIGHT);
            nume.setPreferredSize(new Dimension(70, 12));

            numar = new JLabel("");
            numar.setHorizontalAlignment(SwingUtilities.RIGHT);
            numar.setPreferredSize(new Dimension(70, 12));

            adresa = new JLabel("");
            adresa.setHorizontalAlignment(SwingUtilities.RIGHT);
            adresa.setPreferredSize(new Dimension(150, 12));

            panel.add(rezultat);
            panel.add(new JLabel("Nume:"));
            panel.add(nume);
            panel.add(new JLabel("Numar:"));
            panel.add(numar);
            panel.add(new JLabel("Adresa:"));
            panel.add(adresa);
        }

        int contor = 0;

        if (!Objects.equals(name, "") && Objects.equals(number, "")) {
            File file = new File("src/test/contacte.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            java.util.List<ContactTelefonic> contacts = new ArrayList<>();
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                java.util.List<String> lista = new ArrayList<>();
                lista = List.of(s.split(";"));
                ContactTelefonic c = new ContactTelefonic(lista.get(0), lista.get(1), lista.get(2));
                contacts.add(c);
            }

            for (ContactTelefonic c : contacts) {
                if (name.equals(c.getNume())) {
                    nume.setText(c.getNume());
                    numar.setText(c.getNumar());
                    adresa.setText(c.getAdresa());
                    contor = 1;
                }
            }
        } else if (Objects.equals(name, "") && !Objects.equals(number, "")) {

            File file = new File("src/test/contacte.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            List<ContactTelefonic> contacts = new ArrayList<>();
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                List<String> lista = new ArrayList<>();
                lista = List.of(s.split(";"));
                ContactTelefonic c = new ContactTelefonic(lista.get(0), lista.get(1), lista.get(2));
                contacts.add(c);
            }

            for (ContactTelefonic c : contacts) {
                if (number.equals(c.getNumar())) {
                    nume.setText(c.getNume());
                    numar.setText(c.getNumar());
                    adresa.setText(c.getAdresa());
                    contor = 1;
                }
            }

        }

        if (contor == 0) {
            rezultat.setText("Contactul nu a fost gasit!");
        }

        this.add(panel);
    }
}
