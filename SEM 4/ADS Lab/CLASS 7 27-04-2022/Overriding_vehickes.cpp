#include <iostream>
using namespace std;

class Vehicle
{
    public:
        void type(){
            cout<<"The name of the vehicle is = ";
        }

        void price()
        {
            cout<<"The price of the car is = ";
        }
};


class Car:public Vehicle
{
    public:
        void type(){
            cout<<" CAR \n";
        }

        void price(){
            cout<<" 100000 Rupees \n";
        }
};
class Bus:public Vehicle
{
    public:
        void type(){
            cout<<" BUS \n";
        }

        void price(){
            cout<<" 200000 Rupees \n";
        }
};
class Boat:public Vehicle
{
    public:
        void type(){
            cout<<" BOAT \n";
        }

        void price(){
            cout<<" 300000 Rupees \n";
        }
};


int main()
{
    Car cr;
    Bus bs;
    Boat bt;

    cr.Vehicle::type();
    cr.type();
    cr.Vehicle::price();
    cr.price();

    bs.Vehicle::type();
    bs.type();
    bs.Vehicle::price();
    bs.price();

    bt.Vehicle::type();
    bt.type();
    bt.Vehicle::price();
    bt.price();

    return 1;
}