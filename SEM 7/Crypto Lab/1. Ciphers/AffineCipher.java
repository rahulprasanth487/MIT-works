import java.io.*;
import java.util.*;


class AffineCipher
{
    public static String Encrypt(String plain,int a,int b)
    {
        String cipher="";

        //ax+b
        for(int i=0;i<plain.length();++i)
        {
            char c=plain.charAt(i);
            cipher+=(char)(((a*(c) +b)%26) + 'A'); 
        }
        return cipher;
    }


    public static int Inverse(int a)
    {
        //USING EXTENDED EUCLEDIAN
        int q;
        int r1=26,r2=a;
        int r,t;
        int t1=0,t2=1;

        while(r2>0)
        {
            q=r1/r2;
            r=r1%r2;
            t=t1-q*t2;
            r1=r2;
            r2=r;
            t1=t2;
            t2=t;
        }
        
        return (t1<0)?26+t1 : t1;
    }



    public static String Decrypt(String cipher,int a,int b)
    {
        String ans="";

        //a^-1 (x-b)

        int inv=Inverse(a);

        System.out.println("Inverse = "+inv);

        for(int i=0;i<cipher.length();++i)
        {
            ans = ans + (char) (((inv * ((cipher.charAt(i) - b)) % 26)) + 65);
        }

        return ans;

    }


    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.print("\n\nEnter the plain text = ");
        String plain=scn.nextLine();

        int a,b;
        System.out.println("Enter the values of a and b = ");
        a=scn.nextInt();
        b=scn.nextInt();

        //where a and b are the keys
        String cipher=Encrypt(plain,a,b);
        System.out.println("\nCipher Text = "+cipher);
        String dec=Decrypt(cipher,a,b);
        System.out.println("Decrypted = "+dec);

    }
}