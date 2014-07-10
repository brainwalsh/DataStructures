
package listnode;

import domain.Contact;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListNodeImplTest {
    
    public ListNodeImplTest() {
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        IList<Contact> mc = new ListNodeImpl<Contact>();
        assertEquals(mc.getCount(), 0);

        //populate first contact
        Contact c1 = new Contact();
        c1.setName("John Doe");
        c1.setEmail("john.doe@gmail.com");
        c1.setPhone("6103211313");

        //check to see that the first contact has been added
        mc.add(c1);
        assertEquals(mc.getCount(), 1);


        //populate second contact
        Contact c2 = new Contact();
        c2.setName("Jane Doe");
        c2.setEmail("jane.doe@gmail.com");
        c2.setPhone("7209291313");

        //check to see that the second contact has been added
        mc.add(c2);
        assertEquals(mc.getCount(), 2);
    }


    @Test
    public void testGetItem() {
        System.out.println("getItem");
        IList<Contact> mc = new ListNodeImpl<Contact>();
        assertEquals(mc.getCount(), 0);

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
        assertEquals(mc.getCount(), 1);

        //check that c2 was added
        mc.add(c2);
        assertEquals(mc.getCount(), 2);

        //check to see that the item in the first slot that we pull out
        //equals the first item we put in
        Contact result = new Contact();
        result = mc.getItem(1);
        assertTrue(c1.equals(result));
        System.out.println(result);
        System.out.println(c1);
    }
}