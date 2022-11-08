
import java.util.*;
class Volume
{
//    float r,h;
//    int a;
    
    void vol(int a)
    {
        System.out.println("The volume of the Cube is = "+Math.pow(a, 3));
    }
    
    void vol(int r,int h)
    {
        System.out.println("The volume of the Cylinder is = "+(Math.PI*Math.pow(r, 2)*h));
    }
    
    void vol(float r)
    {
        System.out.println("The volume of the sphere is = "+(4/3)*Math.PI*Math.pow(r, 3));
    }
    
}

public class Volume_cal {
    public static void main(String[] args)
    {
        Scanner inp=new Scanner(System.in);
        int a,r,h;
        System.out.print("Enter the side of the cube = ");
        a=inp.nextInt();
        //cube
        new Volume().vol(a);
        
        System.out.print("Enter the radius and breadth of the Cylinder = ");
        r=inp.nextInt();
        h=inp.nextInt();
        //Cyliner
        new Volume().vol(r,h);
        
        System.out.print("Enter the side of the Sphere = ");
        float r2=inp.nextFloat();
        //cube
        new Volume().vol(r2);
        
    }
}
