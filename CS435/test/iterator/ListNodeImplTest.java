package iterator;

import domain.Contact;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListNodeImplTest {

    public ListNodeImplTest() {
    }

    @Test
    public void testNextMethods() {
        System.out.println("next methods");
        
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


        IIterator<Contact> iter = mc.getIterator();
        // test if an iterator is created
        assertNotNull(iter);

        //Testing that spot one in the list has a next
        assertTrue(iter.hasNext());

        //loop through to the one past the end
        while (iter.hasNext()) {
            assertNotNull(iter.next());
        }

        //when we get to the last one we will move beyond the list and point to a null
        //test has nexts work at the beyond the end
        assertFalse(iter.hasNext());
    }

    @Test
    public void testPreviousMethods() {
        System.out.println("previous methods");

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


        IIterator<Contact> iter = mc.getIterator();
        // test if an iterator is created
        assertNotNull(iter);

        //Testing that spot one in the list has a next
        assertTrue(iter.hasNext());

        //loop through to the end
        for (int i = 1; i < mc.getCount(); i++) {
            assertNotNull(iter.next());
        }

        //test if there is a previous
        assertTrue(iter.hasPrevious());

        //loop from the end to the begining
        while (iter.hasPrevious()) {
            assertNotNull(iter.previous());
        }

        //Test the begining of the list
        assertFalse(iter.hasPrevious());
        assertNull(iter.previous());
    }
    
    @Test
    public void testGetItem() {
        System.out.println("getItem");

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
        
       
        
        //test first contact
        Contact result = mc.getItem(1);
        assertEquals(result, c1);
        
        //test second contact
        result = mc.getItem(2);
        assertEquals(result, c2);
        
    }
    
    @Test
    public void testReset(){
        System.out.println("reset");
        
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


        IIterator<Contact> iter = mc.getIterator();
        // test if an iterator is created
        assertNotNull(iter);
        
        while(iter.hasNext()){
            assertNotNull(iter.next());
            System.out.println("Not yet reset");
        }
        
        while(iter.hasNext()){
            fail();
        }
        
        iter.reset();
        
        while(iter.hasNext()){
            assertNotNull(iter.next());
            System.out.println("Reset");
        }
        assertFalse(iter.hasNext());
    }
    
    @Test
    public void testInsert(){
        System.out.println("Insert");

        IList<Contact> mc = new ListNodeImpl<Contact>();
        assertEquals(mc.getCount(), 0);
        
        //populate first contact
        Contact c1 = new Contact();
        c1.setName("A");
        c1.setEmail("aaa");
        c1.setPhone("1");

        //check to see that the first contact has been added
        mc.add(c1);
        assertEquals(mc.getCount(), 1);

        //populate second contact
        Contact c2 = new Contact();
        c2.setName("B");
        c2.setEmail("bbb");
        c2.setPhone("2");

        //check to see that the second contact has been added
        mc.add(c2);
        assertEquals(mc.getCount(), 2);
        
        Contact c3 = new Contact();
        c2.setName("C");
        c2.setEmail("ccc");
        c2.setPhone("3");

        //check to see that the third contact has been added
        mc.add(c3);
        assertEquals(mc.getCount(), 3);
        
        Contact add = new Contact();
        add.setName("ADD");
        add.setEmail("add");
        add.setPhone("666");
        
        IIterator<Contact> iter = mc.getIterator();
        // test if an iterator is created
        assertNotNull(iter);
      
        
    }
    
    
}