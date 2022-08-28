/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_2;
import java.util.*;
/**
 *
 * @author student
 */
public class Copyarray {
    int[] arrgen()
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
        
        return arr;
    }
    public static void main(String[] args)
    {
        Copyarray obj=new Copyarray();
        System.out.println("Array 1 = ");
        int arr1[]=obj.arrgen();
        System.out.println("Array 2 = ");
        int arr2[]=obj.arrgen();
        
        System.arraycopy(arr1, 1, arr2, 3, 3);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
