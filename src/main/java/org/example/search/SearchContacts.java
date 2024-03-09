package org.example.search;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Represents a JFrame for searching contacts by name or number.
 */
public class SearchContacts extends JFrame {
    /**
     * Label for the "Nume" field.
     */
    private JLabel nume;

    /**
     * Label for the "Numar" field.
     */
    private JLabel numar;

    /**
     * Text field for entering the name to search.
     */
    private JTextField campNume;

    /**
     * Text field for entering the number to search.
     */
    private JTextField campNumar;

    /**
     * Button for initiating the search by name.
     */
    private JButton cautareNume;

    /**
     * Button for initiating the search by number.
     */
    private JButton cautareNumar;

    /**
     * Constructor for the searchContacts class.
     *
     * @throws FileNotFoundException If the specified file is not found.
     */
    public SearchContacts() throws FileNotFoundException{
        super("Search contacts");
        this.setSize(500, 200);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        nume=new JLabel("Nume: ");
        nume.setHorizontalAlignment(SwingUtilities.RIGHT);
        nume.setPreferredSize(new Dimension(70, 12));

        numar=new JLabel("Numar: ");
        numar.setHorizontalAlignment(SwingUtilities.RIGHT);
        numar.setPreferredSize(new Dimension(70, 12));

        campNume=new JTextField(20);
        campNumar=new JTextField(20);

        cautareNume=new JButton("Cauta dupa nume");
        cautareNumar=new JButton("Cautare dupa numar");

        this.add(nume);
        this.add(campNume);
        this.add(cautareNume);
        this.add(numar);
        this.add(campNumar);
        this.add(cautareNumar);


        ActionListener searchName= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                /*String name=campNume.getText();

                File file=new File("contacte.txt");
                Scanner sc= null;
                try {
                    sc = new Scanner(file);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                List<contactTelefonic> contacts=new ArrayList<>();
                while (sc.hasNextLine()){
                    String s=sc.nextLine();
                    List<String>lista=new ArrayList<>();
                    lista=List.of(s.split(";"));
                    contactTelefonic c = new contactTelefonic(lista.get(0),lista.get(1),lista.get(2));
                    contacts.add(c);
                }

                for(contactTelefonic c:contacts){
                    if(name.equals(c.getNume())){
                        campNumar.setText(c.getNumar());
                    }
                }*/

                try {
                    Result result = new Result(campNume.getText(),campNumar.getText());
                    result.setVisible(true);
                    result.setLocationRelativeTo(null);

                    //viewContacts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        cautareNume.addActionListener(searchName);


        ActionListener searchNumar= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                /*String numar=campNumar.getText();

                File file=new File("contacte.txt");
                Scanner sc= null;
                try {
                    sc = new Scanner(file);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                List<contactTelefonic> contacts=new ArrayList<>();
                while (sc.hasNextLine()){
                    String s=sc.nextLine();
                    List<String>lista=new ArrayList<>();
                    lista=List.of(s.split(";"));
                    contactTelefonic c = new contactTelefonic(lista.get(0),lista.get(1),lista.get(2));
                    contacts.add(c);
                }

                for(contactTelefonic c:contacts){
                    if(numar.equals(c.getNumar())){
                        campNume.setText(c.getNume());
                    }
                }*/
                try {
                    Result result = new Result(campNume.getText(),campNumar.getText());
                    result.setVisible(true);
                    result.setLocationRelativeTo(null);

                    //viewContacts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        cautareNumar.addActionListener(searchNumar);

    }
}
