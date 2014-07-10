package listarray;

import domain.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class ListArrayImplTest {

    public ListArrayImplTest() {
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        IList<Contact> mc = new ListArrayImpl<Contact>(10);
        assertEquals(mc.count(), 0);

        //populate first contact
        Contact c1 = new Contact();
        c1.setName("John Doe");
        c1.setEmail("john.doe@gmail.com");
        c1.setPhone("6103211313");

        //check to see that the first contact has been added
        mc.add(c1);
        assertEquals(mc.count(), 1);


        //populate second contact
        Contact c2 = new Contact();
        c2.setName("Jane Doe");
        c2.setEmail("jane.doe@gmail.com");
        c2.setPhone("7209291313");

        //check to see that the second contact has been added
        mc.add(c2);
        assertEquals(mc.count(), 2);
    }

    @Test
    public void testGetItem() {
        System.out.println("getItem");
        IList<Contact> mc = new ListArrayImpl<Contact>(10);
        assertEquals(mc.count(), 0);

        //populate c1
        Contact c1 = new Contact();
        c1.setName("John Doe");
        c1.setEmail("john.doe@gmail.com");
        c1.setPhone("6103211313");

        //populate c2
        Contact c2 = new Contact();
        c2.setName("Jane Doe");
        c2.setEmail("jane.doe@gmail.com");
        c2.setPhone("7209291313");

        //check that c1 was added
        mc.add(c1);
        assertEquals(mc.count(), 1);

        //check that c2 was added
        mc.add(c2);
        assertEquals(mc.count(), 2);

        //check to see that the item in the first slot that we pull out
        //equals the first item we put in
        boolean result;
        result = c1.equals(mc.getItem(0));
        assertTrue(result);

        //check to see the item in the second slot equals the second
        //item we put in
        result = c2.equals(mc.getItem(1));
        assertTrue(result);
    }
}