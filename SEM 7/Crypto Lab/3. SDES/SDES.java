import java.util.Scanner;

public class SDES {
    public static String shiftLeft(String s, int value) {
        String res = "";
        for (int j = 0; j < value; j++) {
            res = "";
            for (int i = 0; i < s.length() - 1; i++) {
                res = res + s.charAt(i + 1);
            }
            res = res + s.charAt(0);
            s = res;
        }
        return res;
    }

    public static String[] keyGeneration(String plaintext, String key) {
        int[] compressionTable = {6, 3, 7, 4, 8, 5, 10, 9};
        int[] straightPBox = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
        String[] keys = new String[2];
        String ans = "";

        for (int i = 0; i < straightPBox.length; i++) {
            ans = ans + key.charAt(straightPBox[i] - 1);
        }

        String left = ans.substring(0, 5);
        String right = ans.substring(5, 10);

        for (int i = 0; i < 2; i++) {
            String leftShifted = shiftLeft(left, i + 1);
            String rightShifted = shiftLeft(right, i + 1);
            String concat = leftShifted + rightShifted;
            String k = "";

            for (int j = 0; j < compressionTable.length; j++) {
                k = k + concat.charAt(compressionTable[j] - 1);
            }

            keys[i] = k;
            left = leftShifted;
            right = rightShifted;
        }

        return keys;
    }

    public static String XOR(String a, String b) {
        String ans = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                ans = ans + "0";
            } else {
                ans = ans + "1";
            }
        }
        return ans;
    }

    public static String sbox(String s, int i) {
        int sbox1[][] = {{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 3, 2}};
        int sbox2[][] = {{0, 1, 2, 3}, {2, 0, 1, 3}, {3, 0, 1, 0}, {2, 1, 0, 3}};

        String row = "" + s.charAt(0) + s.charAt(3);
        String col = "" + s.charAt(1) + s.charAt(2);

        int irow = Integer.parseInt(row, 2);
        int icol = Integer.parseInt(col, 2);
        String res;
        if (i == 1) {
            res = Integer.toBinaryString(sbox1[irow][icol]);
        } else {
            res = Integer.toBinaryString(sbox2[irow][icol]);
        }
        if (res.length() == 1) {
            res = "0" + res;
        }
        return res;
    }

    public static String function(String s, String[] keys, int i) {
        int[] EP = {4, 1, 2, 3, 2, 3, 4, 1};
        int[] straightPBox = {2, 4, 3, 1};
        String ans = "";
        for (int j = 0; j < EP.length; j++) {
            ans += s.charAt(EP[j] - 1);
        }
        String xorValue = XOR(ans, keys[i]);
        String left = xorValue.substring(0, 4);
        String right = xorValue.substring(4, 8);
        String res = sbox(left, 1) + sbox(right, 2);
        String out = "";
        for (int k = 0; k < straightPBox.length; k++) {
            out = out + res.charAt(straightPBox[k] - 1);
        }
        return out;
    }

    public static String encrypt(String plaintext, String[] keys, boolean flag) {
        int[] IP = {2, 6, 3, 1, 4, 8, 5, 7};
        int[] FP = {4, 1, 3, 5, 7, 2, 8, 6};
        String ans = "";
        for (int j = 0; j < IP.length; j++) {
            ans += plaintext.charAt(IP[j] - 1);
        }
        String left = ans.substring(0, 4);
        String right = ans.substring(4, 8);
        for (int i = 0; i < 2; i++) {
            String funcApplied;
            if (flag) {
                funcApplied = function(right, keys, i);
            } else {
                funcApplied = function(right, keys, keys.length - i - 1);
            }
            String newRight = XOR(left, funcApplied);
            if (i == 0) {
                left = right;
                right = newRight;
            } else {
                left = newRight;
            }
        }
        
        String lastVal = left + right;
        String ciphertext = "";
        for (int j = 0; j < FP.length; j++) {
            ciphertext += lastVal.charAt(FP[j] - 1);
        }
        return ciphertext;
    }

    public static void main(String[] args) {
        String plaintext;
        String key;
        Scanner sc = new Scanner(System.in);
        System.out.println("Plain Text : ");
        plaintext = sc.next();
        System.out.println("Key : ");
        key = sc.next();
        String[] keys = keyGeneration(plaintext, key);
        System.out.println("Keys Generated in 2 rounds:");
        for (int i = 0; i < keys.length; i++) {
            System.out.println("Key " + i + " " + keys[i]);
        }
        String ciphertext = encrypt(plaintext, keys, true);
        System.out.println("Cipher Text: " + ciphertext);
        String decryptedText = encrypt(ciphertext, keys, false);
        System.out.println("Plain Text: " + decryptedText);
    }
}
