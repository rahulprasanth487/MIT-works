import java.util.*;

public class ElgamalDSS {
    static Scanner s = new Scanner(System.in);
    static int Q = 0, mi = 0;

    public static void main(String[] args) {
        int m, q, a, d, y_a, k, s1, s2, k_inv, t, v1, v2, t1;
        System.out.println("\nprimitive root of p,q : ");
        a = s.nextInt();
        q = s.nextInt();
        System.out.println("private key of A (from 1 and q-1 : ");
        d = s.nextInt();
        y_a = mod(a, d, q);
        System.out.println("The public component of A: " + y_a);
        System.out.println("Private key: {" + d + "}");
        System.out.println("Public key: {" + q + "," + a + "," + y_a + "}");
        System.out.println("M value ( 0 to q-1 : ");
        m = s.nextInt();
        System.out.println("k ( 1 to q-1 : ");
        k = s.nextInt();
        s1 = mod(a, k, q);
        k_inv = inv(1, 0, (q - 1), 0, 1, k, 0, 0, 0);
        t = k_inv * (m - (d * s1));
        s2 = mod(t, 1, (q - 1));
        System.out.println("Signature Pair: {" + s1 + "," + s2 + "}");
        v1 = mod(a, m, q);
        t1 = ((int) Math.pow(y_a, s1)) * ((int) Math.pow(s1, s2));
        v2 = mod(t1, 1, q);
        System.out.println("v1: " + v1 + " v2: " + v2);
        if(v1==v2)
        {
            System.out.println("Signature is valid\n");   
        }
        else
        {
            System.out.println("Signature is not valid");
        }
    }

    public static int mod(int a, int p, int n) {
        int x = 1;
        int j = a;
        while (p > 0) {
            if (p % 2 == 1) {
                x = (x * a);
                if (x > n) {
                    x %= n;
                }
            }
            a = (a * a);
            if (a > n) {
                a %= n;
            }
            p /= 2;
        }
        return x;
    }

    public static int inv(int A1, int A2, int A3, int B1, int B2, int B3, int T1, int T2, int T3) {
        if (B3 == 1) {
            mi = B2;
        } else {
            Q = Math.abs(A3 / B3);
            update(A1, A2, A3, B1, B2, B3, T1, T2, T3, Q);
        }
        return mi;
    }

    public static void update(int A1, int A2, int A3, int B1, int B2, int B3, int T1, int T2, int T3, int Q) {
        T1 = A1 - Q * B1;
        T2 = A2 - Q * B2;
        T3 = A3 - Q * B3;
        A1 = B1;
        A2 = B2;
        A3 = B3;
        B1 = T1;
        B2 = T2;
        B3 = T3;
        inv(A1, A2, A3, B1, B2, B3, T1, T2, T3);
    }
}
