
package queuestack;

import queuestack.QueueNodeImpl;
import queuestack.IQueue;
import domain.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class QueueNodeImplTest {
    
    public QueueNodeImplTest() {
    }
    
    @Test
    public void testQueue(){
        System.out.println("Queue Test");
                
        IQueue<Contact> mc = new QueueNodeImpl<Contact>();
        assertEquals(mc.size(),0);
        
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        
        c1.setName("a");
        c1.setPhone("1");
        c1.setEmail("AAA");
        
        c2.setName("b");
        c2.setPhone("2");
        c2.setEmail("BBB");
        
        c3.setName("c");
        c3.setPhone("3");
        c3.setEmail("CCC");
        

        mc.enqueue(c1);
        assertEquals(mc.size(),1);
        
        mc.enqueue(c2);
        assertEquals(mc.size(),2);
        
        mc.enqueue(c3);
        assertEquals(mc.size(),3);
        
        mc.dequeue();
        assertEquals(mc.size(),2);
        
        mc.dequeue();
        assertEquals(mc.size(),1);
        
        mc.dequeue();
        assertEquals(mc.size(),0);
        

        
    } 
}