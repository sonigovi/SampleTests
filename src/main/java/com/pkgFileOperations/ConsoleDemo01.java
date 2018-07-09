package com.pkgFileOperations;

import java.io.Console;

/*The Java Console class is be used to get input from console. It provides methods to read texts and passwords.

If you read password using Console class, it will not be displayed to the user.

The java.io.Console class is attached with system console internally. The Console class is introduced since 1.5.

Let's see a simple example to read text from console.
*/

//public final class Console extends Object implements Flushable

public class ConsoleDemo01 {
    public static void main(String[] args) {
        Console c = System.console();
        try {
            System.out.println("Enter your first name and last name");
            String s = c.readLine();
            System.out.println("Welcome " + s);

            System.out.println("Enter password: ");
            char[] ch = c.readPassword();
            String pass = String.valueOf(ch);// converting char array into string
            System.out.println("Password is: " + pass);
        } catch (Exception e) {
            try {
                System.out.println(e);
                System.out.println("Enter password: ");
                char[] ch = c.readPassword();
                String pass = String.valueOf(ch);// converting char array into string
                System.out.println("Password is: " + pass);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                System.out.println(e);
            }
        }
    }
}
