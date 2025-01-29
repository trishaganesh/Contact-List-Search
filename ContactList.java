/**
 * Purpose: The Contact List object class
 *
 * @author Trisha Ganesh
 * @version 6/28/2021
 *
 */

public class ContactList {

        // instance variables
        private String name;
        private String relationship;
        private String birthMonth;
        private int birthDate;
        private String phoneNumber;
        private String email;

        // Constructor for objects of class ContactList
        public ContactList(String n, String r, String bM, int bD, String p, String e)
        {
            // initialize instance variables
            name = n;
            relationship = r;
            birthMonth = bM;
            birthDate = bD;
            phoneNumber = p;
            email = e;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String n)
        {
            name = n;
        }

        public String getRelationship()
        {
            return relationship;
        }

        public void setRelationship(String r)
        {
            relationship = r;
        }

        public String getBirthMonth()
        {
            return birthMonth;
        }

        public void setBirthMonth(String bM)
        {
            birthMonth = bM;
        }

        public int getBirthDate()
        {
            return birthDate;
        }

        public void setBirthDate(int bD)
        {
            birthDate = bD;
        }

        public String getPhoneNumber()
        {
            return phoneNumber;
        }

        public void setPhoneNumber(String p)
        {
            phoneNumber = p;
        }

        public String getEmail()
        {
            return email;
        }

        public void setEmail(String e)
        {
            email = e;
        }

        public String toString()
        {
            String str = String.format("%-25s %-20s %-20s %-20s %-20s", name,  relationship , (birthMonth + " " + birthDate),
                    phoneNumber, email);
            return str;
        }
    }

