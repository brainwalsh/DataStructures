package domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author bwalsh
 */
public class MyContactsTest {

    public MyContactsTest() {
    }

    /**
     * Test of add method, of class MyContacts.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        MyContacts mc = new MyContacts(10);
        assertEquals(mc.numberOfContacts(), 0);


        Contact c = new Contact();
        c.setName("John Doe");
        c.setEmail("john.doe@gmail.com");
        c.setPhone("6103211313");

        mc.add(c);
        assertEquals(mc.numberOfContacts(), 1);

    }
}