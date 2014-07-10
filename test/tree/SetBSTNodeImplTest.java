
package tree;

import org.junit.Test;
import static org.junit.Assert.*;


public class SetBSTNodeImplTest {
    
    public SetBSTNodeImplTest() {
    }
    
    
    @Test
    public void testAdd() {
        System.out.println("add");

        ISet<Contact> mc = new SetBSTNodeImpl<Contact>();
        assertEquals(mc.length(),0);
        
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        Contact c4 = new Contact();
        
        c1.setFirstName("Adam");
        c1.setLastName("Smith");
        c1.setPhone("1");
        c1.setEmail("AAA");
        
        c2.setFirstName("Greg");
        c2.setLastName("Jennings");
        c2.setPhone("2");
        c2.setEmail("BBB");
        
        c3.setFirstName("Larry");
        c3.setLastName("Mullen");
        c3.setPhone("3");
        c3.setEmail("CCC");
        
        c4.setFirstName("Brian");
        c4.setLastName("Walsh");
        c4.setPhone("4");
        c4.setEmail("DDD");
        
        mc.add(c1);
        assertEquals(mc.length(),1);
        
        mc.add(c2);
        assertEquals(mc.length(),2);
        
        mc.add(c3);
        assertEquals(mc.length(),3);
        
        mc.add(c4);
        assertEquals(mc.length(),4);

        
    }

    @Test
    public void testAddSame() {
        System.out.println("add - same");
        ISet<Contact> mc = new SetBSTNodeImpl<Contact>();
        assertEquals(mc.length(),0);
        
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        Contact c4 = new Contact();
        
        c1.setFirstName("Adam");
        c1.setLastName("Smith");
        c1.setPhone("1");
        c1.setEmail("AAA");
        
        c2.setFirstName("Greg");
        c2.setLastName("Jennings");
        c2.setPhone("2");
        c2.setEmail("BBB");
        
        c3.setFirstName("Brian");
        c3.setLastName("Walsh");
        c3.setPhone("3");
        c3.setEmail("CCC");
        
        c4.setFirstName("Brian");
        c4.setLastName("Walsh");
        c4.setPhone("4");
        c4.setEmail("DDD");
        
        mc.add(c1);
        assertEquals(mc.length(),1);
        
        mc.add(c2);
        assertEquals(mc.length(),2);
        
        mc.add(c3);
        assertEquals(mc.length(),3);
        
        mc.add(c4);
        assertEquals(mc.length(),3);
    }
}