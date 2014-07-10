
package set;

import org.junit.Test;
import static org.junit.Assert.*;


public class OrderedSetNodeImplTest {
    
    public OrderedSetNodeImplTest() {
    }
    
    @Test
    public void testAdd() {
        System.out.println("add");
        ISet<Contact> mc = new OrderedSetNodeImpl<Contact>();
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

        System.out.println(mc.getItem(1).toString());
        System.out.println(mc.getItem(2).toString());
        System.out.println(mc.getItem(3).toString());
        System.out.println(mc.getItem(4).toString());
    }

    @Test
    public void testAddSame() {
        System.out.println("add - same");
        ISet<Contact> mc = new OrderedSetNodeImpl<Contact>();
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

        System.out.println(mc.getItem(1).toString());
        System.out.println(mc.getItem(2).toString());
        System.out.println(mc.getItem(3).toString());
        //System.out.println(mc.getItem(4).toString());
        //the above line causes an error, which is what we expect
    }
    
    @Test
    public void testRemove() {
        System.out.println("remove");
        ISet<Contact> mc = new OrderedSetNodeImpl<Contact>();
        assertEquals(mc.length(),0);
        
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        Contact c4 = new Contact();
        
        c1.setFirstName("a");
        c1.setPhone("1");
        c1.setEmail("AAA");
        
        c2.setFirstName("b");
        c2.setPhone("2");
        c2.setEmail("BBB");
        
        c3.setFirstName("c");
        c3.setPhone("3");
        c3.setEmail("CCC");
        
        c4.setFirstName("d");
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
        
        //Testing extremes
        assertNull(mc.remove(0));
        assertNull(mc.remove(5));
        
        //Test the middle
        assertEquals(mc.remove(2),c2);
        assertEquals(mc.length(),3);
        
        //Test the begining
        assertEquals(mc.remove(1),c1);
        assertEquals(mc.length(),2);
        
        //Test the end
        assertEquals(mc.remove(2),c4);
        assertEquals(mc.length(),1);
        
        //Test one
        assertEquals(mc.remove(1),c3);
        assertEquals(mc.length(),0);
        
    }
}