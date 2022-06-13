#include <iostream>
#include <ctime>

using namespace std;


int leap_year(int yr)
{
    int flag=0;
    if(yr%4)
    {
        if(yr%100)
        {
            if(yr%400) flag=1;
            else flag=0;
        }
        else flag=1;
    }
    else flag=0;

    return flag;
}


class date_time
{
    public:
    int dy,mnth,yr;
    date_time(int d,int m,int y)
    {
        this->dy=d;
        this->mnth=m;
        this->yr=y;
    }

    void operator ++()
    {
        if(mnth==2||mnth==4||mnth==6||mnth==9||mnth==11)
        {
            if(dy==30){dy=1;mnth++;}
            else dy++;
        }

        else if(mnth==2)
        {
            if(leap_year(yr))
            {
                if(dy==29&&mnth==2) {dy=1;mnth++;}
                else  dy++;
            }
            else{
                if(dy==28&&mnth==2){dy=1;mnth++;}
            }
        }

        else{
            if(dy==31&&mnth==12){dy=1;mnth=1;yr++;}
            else if(dy==31)
            {
                dy=1;mnth++;
            }
            else{
                dy++;
            }
        }

    }
};


int main() {
    int day,month,year;
    time_t now = time(0);
    //which is in seconds

    tm *ltm = localtime(&now);
    //assign to the respective variables
    year = 1900+ltm->tm_year;
    month=1+ltm->tm_mon;
    day=ltm->tm_mday;

    date_time obj(day,month,year);
    ++obj;
    cout<<"Current date:"<<endl;
    cout<<day<<"-"<<month<<"-"<<year<<endl;
    cout<<"Incremented date:"<<endl;
    cout<<obj.dy<<"-"<<obj.mnth<<"-"<<obj.yr;

    return 1;

}