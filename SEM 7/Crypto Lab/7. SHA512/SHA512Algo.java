// https://d3i71xaburhd42.cloudfront.net/e2917caeddacb7807af75dcf1d1bc44fd965316e/3-Figure3-1.png

import java.math.BigInteger;
import java.util.*;
public class SHA512Algo {

	static String calculateCH(BigInteger e, BigInteger f, BigInteger g) {
		//ch = (e & f) ^ (~e & g)
        BigInteger andResult = e.and(f);
        BigInteger notResult = e.not().and(g);
        BigInteger ch = andResult.xor(notResult);
        return padTo64Bits(ch.toString(2));
    }

    static String calculateMaj(BigInteger a, BigInteger b, BigInteger c) {
		//maj = (a & b) ^ (a & c) ^ (b & c)
        BigInteger andResult1 = a.and(b);
        BigInteger andResult2 = a.and(c);
        BigInteger andResult3 = b.and(c);
        BigInteger maj = andResult1.xor(andResult2).xor(andResult3);
        return padTo64Bits(maj.toString(2));
    }

	static String padTo64Bits(String binaryString) {
        int length = binaryString.length();
        if (length < 64) {
            int paddingLength = 64 - length;
            StringBuilder padding = new StringBuilder();
            for (int i = 0; i < paddingLength; i++) {
                padding.append("0");
            }
            return padding.toString() + binaryString;
        } else {
            return binaryString;
        }
    }
 	public static void main(String[] args) {
    	String w = "7162638000000000";
    	String k = "528a2f98d728ae22";
    	String a = "6a09e667f3bcc908";
		String b = "510e527fade682d1";
		String c = "bb67ae8584caa73b"; 
		String d = "9b05688c2b3f6c1f"; 
		String e = "3c6ef372fe94f82b"; 
		String f = "1f83d9abfb41bd6b"; 
		String g = "a54ff53a5f1d36f1"; 
		String h = "5be0cd19137e2179";
		
    	String ba = hexToBin(a);
    	String bb = hexToBin(b);
    	String bc = hexToBin(c);
    	String bd = hexToBin(d);
    	String be = hexToBin(e);
    	String bf = hexToBin(f);
    	String bg = hexToBin(g);
    	String bh = hexToBin(h);



    	BigInteger a1 = new BigInteger(be, 2);
    	BigInteger a2 = new BigInteger(bf, 2);
    	BigInteger a3 = new BigInteger(bg, 2);
    	String ch = calculateCH(a1, a2, a3);


    	BigInteger a4 = new BigInteger(ba, 2);
    	BigInteger a5 = new BigInteger(bb, 2);
    	BigInteger a6 = new BigInteger(bc, 2);
    	String maj = calculateMaj(a4, a5, a6);

        System.out.println(ch + " " + ch.length());
        System.out.println(maj + " " + maj.length());


    	String r35 = Rotate(ba, 35);
    	String r12 = Rotate(ba, 12);
		String r22 = Rotate(ba, 12);
    	BigInteger sa1 = new BigInteger(r35, 2);
    	BigInteger sa2 = new BigInteger(r12, 2);
    	BigInteger sa3 = new BigInteger(r22, 2);
    	String sa = ((sa1.xor(sa2)).xor(sa3)).toString();


    	String r42 = Rotate(be, 42);
    	String r18 = Rotate(be, 18);
    	String r31 = Rotate(be, 31);
    	BigInteger se1 = new BigInteger(r42, 2);
    	BigInteger se2 = new BigInteger(r18, 2);
    	BigInteger se3 = new BigInteger(r31, 2);
    	String se = (se1.xor(se2)).toString();


        System.out.println("Sum a: " + sa);
        System.out.println("Sum e: " + se);


    	BigInteger ta = new BigInteger(sa);
    	BigInteger te = new BigInteger(se);
    	BigInteger h1 = new BigInteger(h, 16);
    	BigInteger ch1 = new BigInteger(ch, 2);
    	BigInteger w1 = new BigInteger(w, 16);
    	BigInteger k1 = new BigInteger(k, 16);
    	BigInteger maj1 = new BigInteger(maj, 2);


    	BigInteger T1 = h1.add(ch1).add(te).add(w1).add(k1);
        System.out.println("\nT1 int " + T1);

    	BigInteger T2 = ta.add(maj1);
        System.out.println("T2 int" + T2);

    	String t1 = T1.toString(16);
    	String t2 = T2.toString(16);
        System.out.println("T1 hex " + t1);
        System.out.println("T2 hex " + t2);

    	h = g;
    	g = f;
    	f = e;
		
    	BigInteger D = new BigInteger(d, 16);
    	e = (D.add(T1)).toString(16);
    	d = c;
    	c = b;
    	b = a;
    	a = (T1.add(T2)).toString(16);

        System.out.println("A : " + a + " " + a.length());
        System.out.println("B : " + b + " " + b.length());
        System.out.println("C : " + c + " " + c.length());
        System.out.println("D : " + d + " " + d.length());
        System.out.println("E : " + e + " " + e.length());
        System.out.println("F : " + f + " " + f.length());
    	System.out.println("G : " + g + " " + g.length());
        System.out.println("H : " + h + " " + h.length());
    	String Final = a + b + c + d + e + f + g + h;
        System.out.println("Hash is = " + Final + " " + Final.length());
 
	}
 
	static String Rotate(String s, int n) {
    	s += s;
    	String r;
    	r = s.substring(n, n + 64);
    	return r;
	}
 
	static String hexToBin(String s) {
		BigInteger hexValue = new BigInteger(s, 16);
        String binary = hexValue.toString(2);
        return binary;
	}
}
