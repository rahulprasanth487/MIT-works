/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_2;

/**
 *
 * @author student
 */
import java.util.*;

public class Largest_and_Smallest {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        
        int arr[];
        System.out.println("Enter the number of elements - ");
        int n=inp.nextInt();
        arr=new int[n];
        for(int i=0;i<n;++i)
        {
            System.out.print("Enter the number - ");
            int num=inp.nextInt();   
            arr[i]=num;
        }
        
        System.out.println("Array = "+Arrays.toString(arr));
        
        Arrays.sort(arr);
        System.out.println("5th Largest is = "+arr[n-5]);
        System.out.println("3rd smallest is = "+arr[2]);
    }
}
