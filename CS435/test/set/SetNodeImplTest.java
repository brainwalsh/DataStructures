/*
 * 
 */
package set;

import org.junit.Test;
import static org.junit.Assert.*;

public class SetNodeImplTest 
{
    
    @Test
    public void testAdd()
    {
        
        ISet<Contact> myContacts = new SetNodeImpl<Contact>();
        assertEquals(myContacts.length(),0);
        
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        Contact c4 = new Contact();
        
        c1.setName("a");
        c1.setPhone("1");
        c1.setEmail("AAA");
        
        c2.setName("b");
        c2.setPhone("2");
        c2.setEmail("BBB");
        
        c3.setName("c");
        c3.setPhone("3");
        c3.setEmail("CCC");
        
        c4.setName("d");
        c4.setPhone("4");
        c4.setEmail("DDD");
        
        myContacts.add(c1);
        assertEquals(myContacts.length(),1);
        
        myContacts.add(c2);
        assertEquals(myContacts.length(),2);
        
        myContacts.add(c3);
        assertEquals(myContacts.length(),3);
        
        myContacts.add(c4);
        assertEquals(myContacts.length(),3);
        
    }// end testAdd
    
    @Test
    public void testRemove()
    {
        
        ISet<Contact> myContacts = new SetNodeImpl<Contact>();
        assertEquals(myContacts.length(),0);
        
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        Contact c4 = new Contact();
        
        c1.setName("a");
        c1.setPhone("1");
        c1.setEmail("AAA");
        
        c2.setName("b");
        c2.setPhone("2");
        c2.setEmail("BBB");
        
        c3.setName("c");
        c3.setPhone("3");
        c3.setEmail("CCC");
        
        c4.setName("d");
        c4.setPhone("4");
        c4.setEmail("DDD");
        
        myContacts.add(c1);
        assertEquals(myContacts.length(),1);
        
        myContacts.add(c2);
        assertEquals(myContacts.length(),2);
        
        myContacts.add(c3);
        assertEquals(myContacts.length(),3);
        
        myContacts.add(c4);
        assertEquals(myContacts.length(),4);
        
        //Testing extremes
        assertNull(myContacts.remove(0));
        assertNull(myContacts.remove(5));
        
        //Test the middle
        assertEquals(myContacts.remove(2),c2);
        assertEquals(myContacts.length(),3);
        
        //Test the begining
        assertEquals(myContacts.remove(1),c1);
        assertEquals(myContacts.length(),2);
        
        //Test the end
        assertEquals(myContacts.remove(2),c4);
        assertEquals(myContacts.length(),1);
        
        //Test one
        assertEquals(myContacts.remove(1),c3);
        assertEquals(myContacts.length(),0);
        
    }// end testAdd
    
    
    
} //end setNodeImplTest
