import java.util.*;


class Transposition {

    public static String Encrypt(String str)
    {
        char[] arr=str.toCharArray();
        String odd = "",eve="";

        for(int i=0;i<str.length();++i)
        {
            if(i%2!=0) odd+=arr[i];
            else eve+=arr[i];
        }

        return eve+odd;
    }

    public static String Decrypt(String cipher)
    {
        String ans="";

        //Hello -> Hloel
        //abcd->acbd

        int first=0,second=cipher.length()/2;
        if(cipher.length()%2!=0)
        {
            second=cipher.length()/2 +1;
        }
        

        int l=first,r=second;

        while(l<second && r<cipher.length())
        {
            ans=ans+cipher.charAt(l)+cipher.charAt(r);
            l++;r++;
        }

        if(l<second) ans=ans+cipher.charAt(l);

        return ans;
    }


    public static void main(String[] args)
    {
        String inp;
        Scanner scn=new Scanner(System.in);
        System.out.print("\n\nEnter the string = ");
        
        inp=scn.next();
        String enc = Encrypt(inp);
        String dec=Decrypt(enc);

        System.out.println("Enc = "+enc);
        System.out.println("Dec = "+dec);
    }
}