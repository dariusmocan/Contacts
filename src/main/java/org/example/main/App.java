package org.example.main;

import org.example.home.Home;

import javax.swing.JFrame;
/**
 * The main class for the application.
 */

public class App {
    /**
     * Default constructor for the App class.
     * This class is not intended to be instantiated, as it only contains a main method.
     */
    private App() {
        // The App class is not intended to be instantiated.
    }
    /**
     * The main method that serves as the entry point for the application.
     *
     * @param args Command line arguments.
     * @throws Exception Any exception.
     */
    public static void main(String[] args) throws Exception{
        /*List<contactTelefonic> contacte= new ArrayList<>();
        contactTelefonic c1= new contactTelefonic("Darius","0772","cuvin nr 421");
        contactTelefonic c2= new contactTelefonic("Fabi","0722","cuvin nr 421");
        contacte.add(c1);
        contacte.add(c2);
        for(contactTelefonic c : contacte){
            System.out.println(c);
        }*/

        /*viewContacts viewContacts = new viewContacts();
        viewContacts.setVisible(true);
        viewContacts.setLocationRelativeTo(null);
        viewContacts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

        Home home=new Home();
        home.setVisible(true);
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
