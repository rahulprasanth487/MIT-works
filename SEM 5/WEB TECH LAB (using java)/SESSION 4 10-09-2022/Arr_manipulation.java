import java.util.*;
public class Arr_manipulation {
    public static void main(String[] args){
        int Arr[]=new int[10];
        Scanner inp=new Scanner(System.in);
        for(int i=0;i<10;++i)
        {
            System.out.print("Mark = ");
            Arr[i]=inp.nextInt();
        }
        
        //methods
        Arrays.sort(Arr);
        System.out.println("Array = "+Arrays.toString(Arr));
        Arrays.fill(Arr,0,5,100);
        System.out.println("Array = "+Arrays.toString(Arr));
        System.out.print("Enter the number to search = ");
        Arrays.sort(Arr);
        System.out.println(Arrays.binarySearch(Arr,0,Arr.length, inp.nextInt()));
        System.out.println("Array = "+Arrays.toString(Arr));
        int Arr2[]=Arr;
        System.out.println("Arr1==Arr2 --> "+Arrays.equals(Arr, Arr2));
        
    }
    
}
