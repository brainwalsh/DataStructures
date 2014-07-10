/*
 * general tests steps:
 * 1. initiate the class under test
 * 2. "" any other necessary objects and populate them with data
 * 3. invoke the behavior
 * 4. assert
 */
package domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author bwalsh
 */
public class ContactTest {

    public ContactTest() {
    }

    /**
     * Test of validate method, of class Contact.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        //instantiate the class
        Contact c = new Contact();
        boolean result = c.validate();
        assertFalse(result);

        c.setName("John Doe");
        result = c.validate();
        assertFalse(result);

        c.setEmail("john.doe@gmail.com");
        result = c.validate();
        assertFalse(result);

        c.setPhone("6103211313");
        result = c.validate();
        assertTrue(result);
    }

    /**
     * Test of equals method, of class Contact.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        //populate first contact
        Contact c1 = new Contact();
        c1.setName("John Doe");
        c1.setEmail("john.doe@gmail.com");
        c1.setPhone("6103211313");

        //populate the second uniquely
        Contact c2 = new Contact();
        c2.setName("Jane Doe");
        c2.setEmail("jane.doe@gmail.com");
        c2.setPhone("7209291313");

        //march through the properties, making c2 equal c1
        //assert false until they are equal, then assert true
        boolean result = c1.equals(c2);
        assertFalse(result);

        c2.setName("John Doe");
        result = c1.equals(c2);
        assertFalse(result);

        c2.setEmail("john.doe@gmail.com");
        result = c1.equals(c2);
        assertFalse(result);

        c2.setPhone("6103211313");
        result = c1.equals(c2);
        assertTrue(result);
    }
}