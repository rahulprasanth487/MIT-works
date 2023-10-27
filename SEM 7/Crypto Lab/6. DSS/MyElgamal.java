
//refer
//https://www.codingninjas.com/studio/library/the-schnorr-signature-scheme


import java.util.Scanner;
public class MyElgamal {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int p, q, a, d, y_a, k, s1, s2, t, v1, v2;
        
        System.out.println("Enter prime q (order of the group): ");
        q = s.nextInt();
        System.out.println("Enter primitive root a (generates group of order q): ");
        a = s.nextInt();
        System.out.println("Enter private key of A (a number between 1 and q-1): ");
        d = s.nextInt();
        
        y_a = mod(a, d, q);
        
        System.out.println("The public component of A: " + y_a);
        System.out.println("Private key: {" + d + "}");
        System.out.println("Public key: {" + q + "," + a + "," + y_a + "}");
        
        System.out.println("Enter a message m (0 to q-1): ");
        int m = s.nextInt();
        
        // k = generateRandomK(q - 1);
        k=5;
        s1 = mod(a, k, q);
        t = modInv(k, q - 1);
        s2 = (t * (m - d * s1)) % (q - 1);
        if(s2<0)
            s2+=q-1;
        
        System.out.println("Signature Pair: {" + s1 + "," + s2 + "}");
        
        // v1 = (mod(a, m, p) * mod(y_a, s1, p)) % p;
        v1 = mod(a, m, q);
        v2 = (mod(s1, s2, q) * mod(y_a, s1, q)) % q;
        
        System.out.println("v1: " + v1 + " v2: " + v2);
        
        if (v1 == v2) {
            System.out.println("Signature is valid\n");   
        } else {
            System.out.println("Signature is not valid");
        }
    }

    public static int mod(int a, int p, int n) {
        int x = 1;

        while (p > 0) {
            if (p % 2 == 1) {
                x = (x * a) % n;
            }
            a = (a * a) % n;
            p /= 2;
        }
        return x;
    }

    public static int modInv(int a, int n) {
        int t = 0, t2 = 1;
        int r = n, r2 = a;

        while (r2 != 0) {
            int quotient = r / r2;

            int tmpT = t2;
            t2 = t - quotient * t2;
            t = tmpT;

            int tmpR = r2;
            r2 = r - quotient * r2;
            r = tmpR;
        }

        if (r > 1) {
            throw new IllegalArgumentException("a is not invertible");
        }

        if (t < 0) {
            t = t + n;
        }

        return t;
    }

    public static int generateRandomK(int n) {
        int k;
        do {
            k = (int) (Math.random() * (n - 1) + 1);
        } while (gcd(k, n) != 1);
        return k;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
