import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int defaultPasswordLength;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;
    private String companySufix;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.defaultPasswordLength = 8;
        this.companySufix = "mycompany.com";
        this.mailboxCapacity = 0;

        System.out.printf("Email created: %s %s", this.firstName, this.lastName);

        this.department = setdepartment();

        this.password = setRandomPassword(defaultPasswordLength);
        System.out.println("Your generated password: " + this.password);

        this.email = String.format("%s.%s@%s.%s",
                firstName.toLowerCase(),
                lastName.toLowerCase(),
                department.toLowerCase(),
                companySufix.toLowerCase());


    }

    private String setdepartment(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nDepartment codes: \n1 - Sales \n2- Development \n3 - Accounting\n0 - None" +
                "\nEnter department code:");
        int deptChoice = scan.nextInt();

        if(deptChoice == 1){ return "Sales"; }
        else if(deptChoice == 2){ return "Dev"; }
        else if(deptChoice == 3){ return "Acct"; }
        else{ return ""; }
    }

    private String setRandomPassword(int length){
        String passwdSet = "ABCDEFGHIJKLMNORSTUVWXYZ0123456789@#!$";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            // necessario fazer casting aqui, pois queremos que seja int
            int randNum = (int) (Math.random() * passwdSet.length());
            password[i] = passwdSet.charAt(randNum);
        }

        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String showInfo() {
        return String.format("NAME: %s %s\n" +
                "COMPANY EMAIL: %s\n" +
                "MAILBOX CAPACITY: %d", firstName, lastName, email, mailboxCapacity);
    }
}
