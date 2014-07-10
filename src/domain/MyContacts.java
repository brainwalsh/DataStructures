/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import listarray.*;

/**
 * @author bwalsh
 */
public class MyContacts {

    
    private IList<Contact> contacts;

    public MyContacts(int size) {
        //creates an array with 10 slots (for pointers)
        //first slot will be nubered zero
        //contacts = new Contact[size];
        contacts = new ListArrayImpl<Contact>(size);

    }

    public Contact add(Contact c) {

        contacts.add(c);
        return c;
    }

    public int numberOfContacts() {

        return contacts.count();
    }
}
