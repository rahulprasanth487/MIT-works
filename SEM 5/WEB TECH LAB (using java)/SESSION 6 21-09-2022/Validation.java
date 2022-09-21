/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.pkg6;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;


public class Validation {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the string  = ");
        String str=inp.nextLine();
        
        String regex="^(?=.*Cod)(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6}$";
        if(!Character.isUpperCase(str.charAt(0))) {System.out.println("Not validated because It is not Capitalized");}
        if(Pattern.matches(regex, str))
        {
            System.out.println("Validated");
        }
        else
        {
            System.out.println("Not validated");
        }
    }
}
