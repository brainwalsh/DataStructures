
package set;

import org.junit.Test;
import static org.junit.Assert.*;


public class OrderedSetNodeImplTest {
    
    public OrderedSetNodeImplTest() {
    }
    
   
    @Test
    public void testAdd() {
        System.out.println("add");
        ISet<Contact> myContacts = new OrderedSetNodeImpl<Contact>();
        assertEquals(myContacts.length(),0);
        
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        Contact c4 = new Contact();
        
        c1.setName("a");
        c1.setPhone("1");
        c1.setEmail("A");
        
        c2.setName("b");
        c2.setPhone("2");
        c2.setEmail("B");
        
        c3.setName("c");
        c3.setPhone("3");
        c3.setEmail("C");
        
        c4.setName("d");
        c4.setPhone("4");
        c4.setEmail("D");
        
        myContacts.add(c1);
        assertEquals(myContacts.length(),1);
        
        myContacts.add(c2);
        assertEquals(myContacts.length(),2);
        
        myContacts.add(c3);
        assertEquals(myContacts.length(),3);
        
        myContacts.add(c4);
        assertEquals(myContacts.length(),4);
        
    }

  
}