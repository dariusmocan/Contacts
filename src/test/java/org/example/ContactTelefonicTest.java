package org.example;

import static org.junit.Assert.assertEquals;

import org.example.contact.ContactTelefonic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTelefonicTest {
    private ContactTelefonic contact=new ContactTelefonic();



    @Test
    void getNume() {
        this.contact.setNume("John Doe");
        assertEquals("John Doe", contact.getNume());
    }

    @Test
    void getNumar() {
        this.contact.setNumar("0777777777");
        assertEquals("0777777777", contact.getNumar());
    }

    @Test
    void getAdresa() {
        this.contact.setAdresa("John@gmail.com");
        assertEquals("John@gmail.com", contact.getAdresa());
    }

    @Test
    void setAdresa() {
        contact.setAdresa("John@gmail.com");
        assertEquals("John@gmail.com", contact.getAdresa());
    }

    @Test
    void setNumar() {
        contact.setNumar("0777777777");
        assertEquals("0777777777", contact.getNumar());
    }

    @Test
    void setNume() {
        contact.setNume("Jane Doe");
        assertEquals("Jane Doe", contact.getNume());
    }


    @Test
    public void testIsValidEmail() {
        assertTrue(ContactTelefonic.isValidEmail("john.doe@example.com"));

        assertFalse(ContactTelefonic.isValidEmail("invalid-email-example.com"));

        assertFalse(ContactTelefonic.isValidEmail("john.doe@invalid-email"));
    }

    @Test
    void testNumarValidation() {
        contact.setNumar("0712345678");
        assertEquals("0712345678", contact.getNumar());

        assertThrows(IllegalArgumentException.class, () -> contact.setNumar("1234567890"));

        assertThrows(IllegalArgumentException.class, () -> contact.setNumar("07123456789"));
    }
}