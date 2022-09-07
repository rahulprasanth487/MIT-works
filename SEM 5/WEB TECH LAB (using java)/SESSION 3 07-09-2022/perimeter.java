/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt.pkg3;

import java.util.*;

class Circle
{
    float r;
    Circle(float r)
    {
        this.r=r;
        
        System.out.println("Perimeter of the circle  = "+2*Math.PI*r);
        System.out.println();
    }
}

class Rectangle
{
    float l,b;
    Rectangle(float l,float b)
    {
        this.l=l;
        this.b=b;
        
        System.out.println("Perimeter of the Rectangle  = "+2*(l+b));
        System.out.println();
    }
}

class Square
{
    int a;
    Square(int a)
    {
        this.a=a;
        
        System.out.println("Perimeter of the Square  = "+4*a);
        System.out.println();
    }
}


public class perimeter {

    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        //Circle
        System.out.print("Enter the radius of the circle = ");
        float r=inp.nextFloat();
        
        new Circle(r);
        
        //Rectangle
        System.out.print("Enter the length and breadth of the rectangle = ");
        float a=inp.nextFloat();
        float b=inp.nextFloat();
        
        new Rectangle(a,b);
        
        System.out.print("Enter the side of the square = ");
        int c=inp.nextInt();
        
        new Square(c);
    }
    
}
