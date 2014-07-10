
package domain;



public class Contact{

    private String name;
    private String phone;
    private String email;
    
    
    
    public int compareTo(Contact c){
        
        
        
        
        
        
        
        return 0;
    }

    public boolean validate() {

        if (phone == null || phone.equals("")) {
            return false;
        }
        if (email == null || email.equals("")) {
            return false;
        }
        if (name == null || name.equals("")) {
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
        if (!this.name.equals(c.name)) {
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
        return getName() + " " + getPhone() + " " + getEmail();
    }

//returns name
    public String getName() {
        return name;
    }

//sets name
    public void setName(String name) {
        this.name = name;
    }

//returns phone
    public String getPhone() {
        return phone;
    }

//sets phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

//returns email
    public String getEmail() {
        return email;
    }

//sets email
    public void setEmail(String email) {
        this.email = email;
    }
}
