
import java.util.*;
class Vehicle
{
    String type;
    int weight,power,wheels;
    void assignVehicle()
    {
        Scanner inp =new Scanner(System.in);
        System.out.print("Type of the vehicle = ");
        this.type=inp.nextLine();
        System.out.print("Weight of the vehicle(kgs) = ");
        this.weight=inp.nextInt();
        System.out.print("Power of the vehicle = ");
        this.power=inp.nextInt();
        System.out.print("No of wheels on the vehicle = ");
        this.wheels=inp.nextInt();
    }
    
    void display()
    {
        System.out.println("\n\nType of the vehicle = "+type);
        System.out.println("Weight of the vehicle(kgs) = "+weight);
        System.out.println("Power of the vehicle = "+power);
        System.out.println("No of wheels on the vehicle = "+wheels+"\n\n");
    }
}


class Twowheel extends Vehicle
{
    Twowheel()
    {
        System.out.println("\nTwo wheel\n");
        super.assignVehicle();
        //super.display();
    }
}

class Threewheel extends Vehicle
{
    Threewheel()
    {
        System.out.println("\nThree wheel\n");
        super.assignVehicle();
        //super.display();
    }
}

class Fourwheel extends Vehicle
{
    Fourwheel()
    {
        System.out.println("\nFour wheel\n");
        super.assignVehicle();
        //super.display();
    }
}

public class Vehicles {
    public static void main(String[] args)
    {
        Twowheel obj1 = new Twowheel();
        Threewheel obj2 = new Threewheel();
        Fourwheel obj3 = new Fourwheel();

        obj1.display();
        obj2.display();
        obj3.display();
        
    }
}
