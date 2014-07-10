package map;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bwalsh
 */
public class MapHashtableImplTest {
    
    public MapHashtableImplTest() 
    {
    }
   
    /**
     * Test of put method, of class MapHashtableImpl.
     */
    @Test
    public void testMap() 
    {
        System.out.println("Map Test");

        IMap<String, Contact> map = new MapHashtableImpl<String, Contact>();
        assertEquals(map.size(), 0);
        
        //create and populate contacts
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
        
        //add all the contacts to the hashmap
        //check the count to see if they were successfully added
        
        map.put(c1.getFullName(), c1);
        assertEquals(map.size(), 1);
        
        map.put(c2.getFullName(), c2);
        assertEquals(map.size(), 2);
        
        map.put(c3.getFullName(), c3);
        assertEquals(map.size(), 3);
        
        map.put(c4.getFullName(), c4);
        assertEquals(map.size(), 4);
        
        //pull each contact out, check to make sure that
        //we get out what we should be getting out
        
        Contact firstOut = map.get(c1.getFullName());
        assertEquals(c1,firstOut);
        
        Contact secondOut = map.get(c2.getFullName());
        assertEquals(c2,secondOut);
        
        Contact thirdOut = map.get(c3.getFullName());
        assertEquals(c3,thirdOut);
        
        Contact fourthOut = map.get(c4.getFullName());
        assertEquals(c4,fourthOut);
        
        //now use an iterator to return all the keys
        
        IIterator iterator = map.keys();
        assertTrue(iterator.hasNext());
        
        //iterate through, checking each contact as we go
        Contact iter1 = (Contact) iterator.next();
        assertEquals(c1,iter1);
        
        Contact iter2 = (Contact) iterator.next();
        assertEquals(c2,iter2);
        
        Contact iter3 = (Contact) iterator.next();
        assertEquals(c3,iter3);
        
        Contact iter4 = (Contact) iterator.next();
        assertEquals(c4,iter4);
        
        //we should be at the end
        assertNull(iterator.next());
        
        //reset the iterator
        iterator = map.keys();
        
        //go through the entire list of keys
        while(iterator.hasNext()){
            assertNotNull(iterator.next());
        }
        //then check to make sure we went all the way through
        assertNull(iterator.next());
        
    }
}