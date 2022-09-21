/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_5;

import java.util.*;

public class Arraylist {
    public static void main(String[] args)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the number of elements = ");
        int n=inp.nextInt();
        for(int  i=0;i<n;++i)
        {
            System.out.print("Enter the element - ");
            arr.add(inp.nextInt());
        }
        
        System.out.println(Arrays.asList(arr));
        int sum=0;
        for(int i=0;i<n;++i)
        {
            sum+=arr.get(i);
        }
        System.out.println("Average of the array = "+sum/arr.size());
        
        System.out.println("Maximum - "+Collections.max(arr));
        System.out.println("Minimum - "+Collections.min(arr));
        
        for(int i=0;i<arr.size();++i)
        {
            if(arr.get(i)%2!=0) 
            {
                arr.remove(Integer.valueOf(arr.get(i)));
            }
        }
        
        System.out.println(Arrays.asList(arr));
    }
}
