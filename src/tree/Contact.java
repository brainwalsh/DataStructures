
package tree;

public class Contact implements IComparable<Contact>{

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
     
    @Override
    public int compareTo(Contact other){
        //returns -1 if my comes before other
        //returns 0 if "this" == other
        //returns 1 if "this" > other
        
        String thisFullName = 
                lastName + ", " + firstName;
        
        String otherFullName =
                other.lastName + ", " + other.firstName;

        return thisFullName.compareTo(otherFullName);
 
        
    }

    public boolean validate() {

        if (phone == null || phone.equals("")) {
            return false;
        }
        if (email == null || email.equals("")) {
            return false;
        }
        if (lastName == null || lastName.equals("")) {
            return false;
        }
        if (firstName == null || firstName.equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        //are the pointers pointing to the same location
        //in memory?
        if (this == obj) {
            return true;
        }

        //if obj is not a contact, they can't be equal
        if (!(obj instanceof Contact)) {
            return false;
        }

        //downcasting obj to a Contact
        Contact c = (Contact) obj;

        //are the names, phones, and emails the same
        if (!this.lastName.equals(c.lastName)) {
            return false;
        }
        if (!this.firstName.equals(c.firstName)) {
            return false;
        }
        if (!this.phone.equals(c.phone)) {
            return false;
        }
        if (!this.email.equals(c.email)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " " + phone + " " + email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
