package queuestack;

import queuestack.IStack;
import queuestack.StackNodeImpl;
import domain.Contact;
import static org.junit.Assert.*;
import org.junit.Test;

public class StackNodeImplTest {

    public StackNodeImplTest() {
    }

    @Test
    public void testStack() {
        System.out.println("Stack Test");

        IStack<Contact> mc = new StackNodeImpl<Contact>();
        assertEquals(mc.size(), 0);

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

        mc.push(c1);
        assertEquals(mc.size(), 1);

        mc.push(c2);
        assertEquals(mc.size(), 2);

        mc.push(c3);
        assertEquals(mc.size(), 3);

        mc.pop();
        assertEquals(mc.size(), 2);

        mc.pop();
        assertEquals(mc.size(), 1);

        mc.pop();
        assertEquals(mc.size(), 0);


    }
}