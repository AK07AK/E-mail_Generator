import java.util.*;
public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String alternateMail;
    int mailboxCapacity;
    String newPassword,retypeNewPassword;

    //set the mailbox capacity
    //set the alternate email id
    //Change the password

    //constructors for initializing the variables
    public Email(String firstName, String lastName) {
        Scanner sc = new Scanner(System.in);
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED " + this.firstName + " " + this.lastName);
        //call the setDepartment method for setting the department name

        this.department = setDepartment();

        System.out.println(this.firstName + this.lastName + " Belongs to " + this.department+"Community");
        //call the random password method for generating the random password
        this.password = generateRandomPassword(8);
        System.out.println("Your Temporary Password: " + this.password);
        System.out.println("Your Company E-mail id is: ");
        emailGenerator(firstName,lastName,department);
        System.out.println("***Now change your Password***");
        System.out.print("Enter Your New Password: ");
        newPassword = sc.next();
        System.out.print("Confirm your password: ");
        retypeNewPassword = sc.next();
        if(newPassword.equals(retypeNewPassword))
        {
            changePassword(retypeNewPassword);//this method will assign the new password to the auto generated password
            System.out.println("Password changed successfully!");

        }
        else {

            while (!retypeNewPassword.equals(newPassword))
            {
                System.out.println("Password does not match!!!");
                System.out.print("Please enter the correct password: ");
                retypeNewPassword = sc.next();
            }
            System.out.println("Password changed successfully!");
        }

    }

    private String setDepartment() {
        System.out.println(" Department: ");
        System.out.println("1.sales");
        System.out.println("2.Accounting");
        System.out.println("3.Developer");
        System.out.println("4.No Department");
        System.out.println("Enter the Department: ");
        Scanner sc = new Scanner(System.in);
        String departmentName;
        int department = sc.nextInt();
        if (department == 1)
            return "Sales";
        else if (department == 2)
            return "Accounting";
        else if (department == 3)
            return "Developer";
        return " ";
    }

    private String generateRandomPassword(int length) {
        String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&*1234567890";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomNumber = (int) (Math.random() * passwordCharacters.length());
            password[i] = passwordCharacters.charAt(randomNumber);
        }
        return new String(password);//this will return the generated random password;


    }
    private void emailGenerator(String firstname,String lastName,String department)
    {
        String email = firstname.toLowerCase()+ lastName.toLowerCase() +"@Zoho"+department+".com";
        System.out.println(email);
    }
    private void changePassword(String Password)
    {
        this.password=password;

    }


}



