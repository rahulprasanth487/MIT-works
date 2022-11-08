
import java.util.*;

class Srt
{
    int[] arr=new int[5];
    Scanner inp=new Scanner(System.in);
    Srt()
    {
        for(int i=0;i<5;++i){
            System.out.print("Enter the value - ");
            this.arr[i]=inp.nextInt();
        }
    }
    Srt(int[] arr)
    {
        this.arr=arr;
    }
    
    
    void insertionsort()
    {
        for(int i=1;i<arr.length;++i)
        {
            int key=arr[i];
            int j=i-1;
            
            while(j>-1&&key<arr[j])
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        
        System.out.println(Arrays.toString(arr));
    }
}

public class Sorting {
    public static void main(String[] args)
    {
        
        new Srt().insertionsort();
        System.out.println("the above is by Using Default Constructor");
        System.out.println("Using parameterized constructor = ");
        new Srt(new int[]{10,9,1,2,3}).insertionsort();
    }
}
