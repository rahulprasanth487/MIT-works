import java.util.*;

class Students_marks
{
      public static void main(String[] args)
      {
            Scanner inp=new Scanner(System.in);

            int arr[]=new int[5];
            for(int i=0;i<5;++i)
            {
                  System.out.print("Enter the number = ");
                  arr[i]=inp.nextInt();
            }

            //sort
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));

            //fill
            Arrays.fill(arr,0,2,1000);
            System.out.println(Arrays.toString(arr));

            //search
            System.out.print("Enter the element to search = ");
            System.out.println("Index = "+Arrays.binarySearch(arr, inp.nextInt()));

            //equals;
            int arr2[]=arr;

            System.out.println("Arr==Arr2 "+arr2.equals(arr));

      }
}