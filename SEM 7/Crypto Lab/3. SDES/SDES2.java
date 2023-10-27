import java.util.Scanner;

public class SDES2 {
    public static String circularLeftShift(String input, int shiftValue) {
        String result = "";
        for (int shift = 0; shift < shiftValue; shift++) {
            result = "";
            for (int i = 0; i < input.length() - 1; i++) {
                result = result + input.charAt(i + 1);
            }
            result = result + input.charAt(0);
            input = result;
        }
        return result;
    }

    public static String[] generateSubkeys(String plaintext, String key) {
        int[] compressionTable = {6, 3, 7, 4, 8, 5, 10, 9};
        int[] SP = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
        String[] subkeys = new String[2];
        String keyPermuted = "";

        for (int i = 0; i < SP.length; i++) {
            keyPermuted = keyPermuted + key.charAt(SP[i] - 1);
        }

        String left = keyPermuted.substring(0, 5);
        String right = keyPermuted.substring(5, 10);

        for (int i = 0; i < 2; i++) {
            String leftShifted = circularLeftShift(left, i + 1);
            String rightShifted = circularLeftShift(right, i + 1);
            String combined = leftShifted + rightShifted;
            String subkey = "";

            for (int j = 0; j < compressionTable.length; j++) {
                subkey = subkey + combined.charAt(compressionTable[j] - 1);
            }

            subkeys[i] = subkey;
            left = leftShifted;
            right = rightShifted;
        }

        return subkeys;
    }

    public static String XOR(String a, String b) {
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result = result + "0";
            } else {
                result = result + "1";
            }
        }
        return result;
    }

    public static String SBOX(String input, int sBoxNumber) {
        int[][] sBox1 = {{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 3, 2}};
        int[][] sBox2 = {{0, 1, 2, 3}, {2, 0, 1, 3}, {3, 0, 1, 0}, {2, 1, 0, 3}};

        String rowBits = "" + input.charAt(0) + input.charAt(3);
        String colBits = "" + input.charAt(1) + input.charAt(2);

        int rowIndex = Integer.parseInt(rowBits, 2);
        int colIndex = Integer.parseInt(colBits, 2);
        String result;

        if (sBoxNumber == 1) {
            result = Integer.toBinaryString(sBox1[rowIndex][colIndex]);
        } else {
            result = Integer.toBinaryString(sBox2[rowIndex][colIndex]);
        }

        if (result.length() == 1) {
            result = "0" + result;
        }

        return result;
    }

    public static String Feistal(String input, String[] subkeys, int sBoxNumber) {
        int[] EP = {4, 1, 2, 3, 2, 3, 4, 1};
        int[] SP = {2, 4, 3, 1};
        String expandedInput = "";

        for (int j = 0; j < EP.length; j++) {
            expandedInput += input.charAt(EP[j] - 1);
        }

        String xorResult = XOR(expandedInput, subkeys[sBoxNumber]);
        String leftBits = xorResult.substring(0, 4);
        String rightBits = xorResult.substring(4, 8);
        String sBoxResult = SBOX(leftBits, 1) + SBOX(rightBits, 2);
        String output = "";

        for (int k = 0; k < SP.length; k++) {
            output = output + sBoxResult.charAt(SP[k] - 1);
        }

        return output;
    }

    public static String process(String data, String[] subkeys, boolean isEncryption) {
        int[] IP = {2, 6, 3, 1, 4, 8, 5, 7};
        int[] FP = {4, 1, 3, 5, 7, 2, 8, 6};
        String processedData = "";

        for (int j = 0; j < IP.length; j++) {
            processedData += data.charAt(IP[j] - 1);
        }

        String leftBits = processedData.substring(0, 4);
        String rightBits = processedData.substring(4, 8);

        for (int i = 0; i < 2; i++) {
            String functionResult;
            if (isEncryption) {
                functionResult = Feistal(rightBits, subkeys, i);
            } else {
                functionResult = Feistal(rightBits, subkeys, subkeys.length - i - 1);
            }
            String newRightBits = XOR(leftBits, functionResult);
            if (i == 0) {
                leftBits = rightBits;
                rightBits = newRightBits;
            } else {
                leftBits = newRightBits;
            }
        }

        String finalData = leftBits + rightBits;
        String outputData = "";

        for (int j = 0; j < FP.length; j++) {
            outputData += finalData.charAt(FP[j] - 1);
        }

        return outputData;
    }

    public static void main(String[] args) {
        String data;
        String key;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data : ");
        data = scanner.next();
        System.out.println("--------------------");
        System.out.println("Key : ");
        key = scanner.next();
        String[] subkeys = generateSubkeys(data, key);
        System.out.println("Generated Subkeys in 2 rounds:");
        for (int i = 0; i < subkeys.length; i++) {
            System.out.println("Subkey " + i + " " + subkeys[i]);
        }
        System.out.println("--------------------");
        String encryptedData = process(data, subkeys, true);
        System.out.println("Encrypted Data: " + encryptedData);
        String decryptedData = process(encryptedData, subkeys, false);
        System.out.println("Decrypted Data: " + decryptedData);
    }
}