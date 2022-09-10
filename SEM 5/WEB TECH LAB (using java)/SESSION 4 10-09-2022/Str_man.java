/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session4;

import java.util.*;

public class Str_man {
    public static void main(String[] args)
    {
        String name = new String("Rahul Prasanth D");
        name=name.toLowerCase();
        System.out.println("Length of name  = "+name.length());
        System.out.println(name);
        int cnt=0;
        for(int i=0;i<name.length();++i)
        {
            if(name.charAt(i)==name.charAt(0)) cnt++;
        }
        System.out.println("Count of first letter along with that = "+cnt);
    }
}
