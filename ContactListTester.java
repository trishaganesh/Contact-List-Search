/**
 * Purpose: The purpose of this program is to utilize concepts learned in module 7 and 8
 * into a challenge program: a contact list.
 *
 * @author Trisha Ganesh
 * @version 6/28/2021
 *
 */

public class ContactListTester {

    public static void main(String[] args) {
        //contact list array
        ContactList[] contact = new ContactList[10];

        contact[0] = new ContactList("Diana Prince", "aunt", "October", 25, "321-555-0811", "aunt@yahoo.com");
        contact[1] = new ContactList("Lexis Denis", "friend", "November", 9, "111-565-0812", "friend@yahoo.com");
        contact[2] = new ContactList("Tony Starks", "friend", "January", 10, "321-545-0761", "friend@yahoo.com");
        contact[3] = new ContactList("Alan Prince", "uncle", "January", 2, "221-555-0841", "uncle@yahoo.com");
        contact[4] = new ContactList("Clara Davis", "sister", "February", 21, "421-555-0891", "sister@yahoo.com");
        contact[5] = new ContactList("Connor Davis", "brother", "February", 1, "521-555-0831", "brother@yahoo.com");
        contact[6] = new ContactList("Angela Matthews", "neighbor", "February", 20, "351-555-0811", "neighbor@yahoo.com");
        contact[7] = new ContactList("Mrs. B", "neighbor", "May", 25, "221-555-0841", "neighbor@yahoo.com");
        contact[8] = new ContactList("Selina Williams", "mother", "April", 30, "221-555-0841", "mother@yahoo.com");
        contact[9] = new ContactList("Steven Williams", "father", "May", 31, "361-985-0211", "father@yahoo.com");


        int search;

        printContactList(contact);

        System.out.println("\n\nBinary Searching for name, Angela Matthews: ");
        System.out.println("--------------------------------------------------");
        selectionSortName(contact);

        search = binaryName(contact, "Angela Matthews");
        if(search != -1)
            System.out.println("We found: " + contact[search]);
        else
            System.out.println("Name not found. " );

        System.out.println("\n\nBinary Search for name, Jennifer Williams: ");
        System.out.println("-----------------------------------------------");
        search = binaryName(contact, "Jennifer Williams");
        if(search != -1)
            System.out.println("We found: " + contact[search]);
        else
            System.out.println("Name was not found. " );

        System.out.println("\n\nBinary Search for a Friend: ");
        System.out.println("-----------------------------------");
        selectionSortRelationship(contact);
        binaryRelationship(contact, "friend");

        System.out.println("\n\nBinary Search for Aunt: ");
        System.out.println("-----------------------------------");
        selectionSortRelationship(contact);
        binaryRelationship(contact, "aunt");

        System.out.println("\n\nSequential Search for contacts born in February: ");
        System.out.println("---------------------------------------------------------------------");
        findBirthMonths(contact, "February");

        System.out.println("\n\nSequential Search for contacts born in May: ");
        System.out.println("---------------------------------------------------------------------");
        findBirthMonths(contact, "May");

        System.out.println("\n\nSequential Search for contacts with Phone Number of 221-555-0841: ");
        System.out.println("---------------------------------------------------------------------");
        findPhoneNumbers(contact, "221-555-0841");

        System.out.println("\n\nSequential Search for contacts with Phone Number of 999-999-9999: ");
        System.out.println("---------------------------------------------------------------------");
        findPhoneNumbers(contact, "999-999-9999");

        System.out.println("\n\nSequential Search for contacts with Email of friend@yahoo.com: ");
        System.out.println("---------------------------------------------------------------------");
        findEmails(contact, "friend@yahoo.com");

        System.out.println("\n\nSequential Search for contacts with Email of coworker@gmail.com: ");
        System.out.println("---------------------------------------------------------------------");
        findEmails(contact, "coworker@gmail.com");
    }

    //binary method (Binary Search for Name)
    public static int binaryName(ContactList[] element, String toFind)
    {
        int high = element.length;
        int low = -1;
        int probe;

        while(high - low > 1)
        {
            probe = (high + low) / 2;
            if(element[probe].getName().compareTo(toFind) > 0)
                high = probe;
            else
                low = probe;
        }

        if((low >= 0) && (element[low].getName().compareTo(toFind) == 0))
            return low;
        else
            return -1;
    }

    //binary method (Binary Search for Relationship)
    public static void binaryRelationship(ContactList[] element, String toFind)
    {
        int high = element.length;
        int low = -1;
        int probe;

        while(high - low > 1)
        {
            probe = (high + low) / 2;

            if(element[probe].getRelationship().compareTo(toFind) > 0)
                high = probe;
            else
            {
                low = probe;
                if(element[probe].getRelationship().compareTo(toFind) == 0)
                {
                    break;
                }
            }
        }

        if((low >= 0) && (element[low].getRelationship().compareTo(toFind) == 0 ))
        {
            linearRelationship(element, low, toFind);
        }
        else
            System.out.println("NOT found: " + toFind);
    }

    //linear Print
    public static void linearRelationship(ContactList[] element, int lowEnd, String toFind)
    {
        int i;
        int start = lowEnd;
        int end = lowEnd;

        // find starting point of matches
        i = lowEnd - 1;
        while((i >= 0) && (element[i].getRelationship().compareTo(toFind) == 0))
        {
            start = i;
            i--;
        }
        // find ending point of matches
        i = lowEnd + 1;
        while((i < element.length) && (element[i].getRelationship().compareTo(toFind) == 0))
        {
            end = i;
            i++;
        }
        // now print out the matches
        for(i = start; i <= end; i++)
            System.out.println(element[i]);
    }

    // Selection sort method for contactList (name)
    public static void selectionSortName(ContactList[] element) {
        int index;
        int k;
        int posMax;
        ContactList contact;

        for (index = element.length - 1; index >= 0; index--) {
            posMax = 0;
            for (k = 0; k <= index; k++) {
                if (element[k].getName().compareTo(element[posMax].getName()) > 0) {
                    posMax = k;
                }
                contact = element[index];
                element[index] = element[posMax];
                element[posMax] = contact;
            }
        }
    }

    // Selection sort method for contactList (relationship)
    public static void selectionSortRelationship(ContactList[] element) {
        int index;
        int k;
        int posMax;
        ContactList contact;

        for (index = element.length - 1; index >= 0; index--) {
            posMax = 0;
            for (k = 0; k <= index; k++) {
                if (element[k].getRelationship().compareTo(element[posMax].getRelationship()) > 0) {
                    posMax = k;
                }
                contact = element[index];
                element[index] = element[posMax];
                element[posMax] = contact;
            }
        }
    }

    // Sequential Search method to find Birthday
    public static void findBirthMonths (ContactList[] element, String toFind)
    {
        int found = 0;

        for(int i = 0; i < element.length; i++)
        {
            if(element[i].getBirthMonth().compareTo(toFind) == 0)
            {
                System.out.println(element[i]);
                found++;
            }
        }

        if(found == 0)
        {   // we have not found the year
            System.out.println(toFind + " was not found in the contact list");
        }
    }

    // Selection sort method to find phone numbers
    public static void findPhoneNumbers(ContactList[] element, String toFind)
    {
        int found = 0;

        for(int i = 0; i < element.length; i++)
        {
            if(element[i].getPhoneNumber().compareTo(toFind) == 0)
            {
                System.out.println(element[i]);
                found++;
            }
        }

        if(found == 0)
        {   // we have not found the year
            System.out.println(toFind + " was not found in the contact list");
        }
    }

    // Selection sort method for finding emails
    public static void findEmails(ContactList[] element, String toFind)
    {
        int found = 0;

        for(int i = 0; i < element.length; i++)
        {
            if(element[i].getEmail().compareTo(toFind) == 0)
            {
                System.out.println(element[i]);
                found++;
            }
        }

        if(found == 0)
        {   // we have not found the year
            System.out.println(toFind + " was not found in the contact list");
        }
    }

    //print results
    public static void printContactList(ContactList[] element)
    {
        System.out.println("                                Contact List                                                                   ");
        System.out.println();
        System.out.println("    Name                Relationship           Birthday             Phone number             Email             ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (ContactList contact : element)
            System.out.printf("%-25s %-20s %-20s %-20s %-20s \n", contact.getName(), contact.getRelationship(), (contact.getBirthMonth() + (" ") +
                    contact.getBirthDate()), contact.getPhoneNumber(), contact.getEmail());
    }

}
