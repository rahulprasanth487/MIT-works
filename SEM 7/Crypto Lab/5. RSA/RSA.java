import java.util.Scanner;
public class RSA {
    public static long SqMul(long base, long exponent, long modulus) {
        long result = 1;
        base = base % modulus;
    
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent = exponent / 2;
        }
    
        return result;
    }
    
    public static int Inverse(int a, int n) {
        int m0 = n;
        int x0 = 0;
        int x1 = 1;
        if (n == 1) {
            return 0;
        }
        while (a > 1) {
            int q = a / n;
            int t = n;

            n = a % n;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        if (x1 < 0) {
            x1 += m0;
        }
        return x1;
    }


    public static int GCD(int a, int b) {
        int r1 = a;
        int r2 = b;
        if (a > b) {
            r1 = a;
            r2 = b;
        } else {
            r2 = a;
            r2 = b;
        }
        int q, r = 0;
        while (r2 != 0) {
            q = r1 / r2;
            r = r1 % r2;
            r1 = r2;
            r2 = r;
        }
        return r1;
    }


      public static long RSA(long p, int e, int n) {
        long ans = SqMul(p, e, n);
        return ans;
    }

    public static long [] ToNum(String str,int e,int n){
        long[] arr=new long[str.length()];
        for(int i=0;i<str.length();i++){
            long c=(long)str.charAt(i);
            long enc=RSA(c,e,n);
            arr[i]=enc;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nString :");
        String text=sc.next();
        int p = 3271;
        int q = 3461;
        int n = p * q;
        int phi_n = (p - 1) * (q - 1);

        int e = 10;
        while (e < phi_n) {
            if (GCD(e, phi_n) == 1) {
                break;
            }
            else {
                e++;
            }
        }


        int d = Inverse(e, phi_n);
        System.out.println("Public key: " + e);
        System.out.println("Private key: " + d);
        long[] enc=ToNum(text,e,n);
        System.out.print("Encrypted text: ");

        for(long i:enc){
            System.out.print(i+" ");
        }

        String ans="";
        for(long i:enc){
            long decrypt=RSA(i, d, n);
            ans=ans+(char)decrypt;
        }
        System.out.println("\nDecrypted text: "+ans+"\n");
    }
}
