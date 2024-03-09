package org.example.contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a contact with name, phone number, and address information.
 */
public class ContactTelefonic {
    private String nume;
    private String numar;
    private String adresa;

    /**
     * Checks if the given string is a valid email address.
     *
     * @param email The email address to validate.
     * @return True if the email is valid, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public ContactTelefonic(){
        this.nume="";
        this.numar="";
        this.adresa="";
    }

    /**
     * Constructor for creating a new contactTelefonic object.
     *
     * @param nume   The name of the contact.
     * @param numar  The phone number of the contact.
     * @param adresa The address of the contact.
     */


    public ContactTelefonic(String nume, String numar, String adresa){
        this.nume=nume;
        this.numar=numar;
        this.adresa=adresa;
    }
    /**
     * Gets the name of the contact.
     *
     * @return The name of the contact.
     */
    public String getNume() {
        return nume;
    }

    /**
     * Gets the phone number of the contact.
     *
     * @return The phone number of the contact.
     */
    public String getNumar() {
        return numar;
    }

    /**
     * Gets the address of the contact.
     *
     * @return The address of the contact.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the address of the contact.
     *
     * @param adresa The new address of the contact.
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param numar The new phone number of the contact.
     */
    public void setNumar(String numar) {
        if (isValidPhoneNumber(numar)) {
            this.numar = numar;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }
    /**
     * Checks if the given string is a valid phone number.
     *
     * @param numar validates the number.
     * @return True if the number is valid, false otherwise.
     */
    private boolean isValidPhoneNumber(String numar) {
        return numar.startsWith("07") && numar.length() == 10;
    }

    /**
     * Sets the name of the contact.
     *
     * @param nume The new name of the contact.
     */


    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Returns a string representation of the contactTelefonic object.
     *
     * @return A string with the name, phone number, and address of the contact.
     */
    public String toString() {
        return nume + "; " + numar + "; " + adresa;
    }

}
