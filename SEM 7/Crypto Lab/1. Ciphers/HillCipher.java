import java.util.ArrayList;
import java.util.Scanner;

public class HillCipher {

    private static int[][] getKeyMatrix() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the key matrix:");
        String key = scn.nextLine().toUpperCase();
        int matrixSize = (int) Math.sqrt(key.length());
        int[][] keyMatrix = new int[matrixSize][matrixSize];
        int k = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                keyMatrix[i][j] = key.charAt(k) - 'A';
                k++;
            }
        }

        return keyMatrix;
    }

    private static void validateKeyMatrix(int[][] keyMatrix) {
        int determinant = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        if (determinant == 0) {
            throw new RuntimeException("Invalid key matrix (Determinant is zero).");
        }
    }

    private static int[][] calculateInverseKeyMatrix(int[][] keyMatrix) {
        int determinantMod26 = (keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0]) % 26;
        int factor;
        int[][] inverseKeyMatrix = new int[2][2];

        for (factor = 1; factor < 26; factor++) {
            if ((determinantMod26 * factor) % 26 == 1) {
                break;
            }
        }

        inverseKeyMatrix[0][0] = keyMatrix[1][1] * factor % 26;
        inverseKeyMatrix[0][1] = (26 - keyMatrix[0][1]) * factor % 26;
        inverseKeyMatrix[1][0] = (26 - keyMatrix[1][0]) * factor % 26;
        inverseKeyMatrix[1][1] = keyMatrix[0][0] * factor % 26;

        return inverseKeyMatrix;
    }

    private static void displayResult(String label, int adder, ArrayList<Integer> phrase) {
        System.out.print(label);
        for (int i = 0; i < phrase.size(); i += 2) {
            System.out.print((char) (phrase.get(i) + (65 + adder)));
            System.out.print((char) (phrase.get(i + 1) + (65 + adder)));
            if (i + 2 < phrase.size()) {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    public static void encrypt(String text, boolean useZeroBasedAlphabet) {
        int adder = useZeroBasedAlphabet ? 0 : 1;
        int[][] keyMatrix;
        ArrayList<Integer> textToNumbers = new ArrayList<>();
        ArrayList<Integer> encryptedText = new ArrayList();

        text = text.replaceAll("[^a-zA-Z]", "").toUpperCase();
        if (text.length() % 2 == 1) {
            text += "Q";
        }

        keyMatrix = getKeyMatrix();
        validateKeyMatrix(keyMatrix);

        for (char c : text.toCharArray()) {
            textToNumbers.add(c - (65 + adder));
        }

        for (int i = 0; i < textToNumbers.size(); i += 2) {
            int x = (keyMatrix[0][0] * textToNumbers.get(i) + keyMatrix[0][1] * textToNumbers.get(i + 1)) % 26;
            int y = (keyMatrix[1][0] * textToNumbers.get(i) + keyMatrix[1][1] * textToNumbers.get(i + 1)) % 26;
            encryptedText.add(useZeroBasedAlphabet ? x : (x == 0 ? 26 : x));
            encryptedText.add(useZeroBasedAlphabet ? y : (y == 0 ? 26 : y));
        }

        displayResult("Encrypted text: ", adder, encryptedText);
    }

    public static void decrypt(String cipher, boolean useZeroBasedAlphabet) {
        int adder = useZeroBasedAlphabet ? 0 : 1;
        int[][] keyMatrix, inverseKeyMatrix;
        ArrayList<Integer> cipherToNumbers = new ArrayList<>();
        ArrayList<Integer> decryptedText = new ArrayList<>();

        cipher = cipher.replaceAll("[^a-zA-Z]", "").toUpperCase();

        keyMatrix = getKeyMatrix();
        validateKeyMatrix(keyMatrix);

        for (char c : cipher.toCharArray()) {
            cipherToNumbers.add(c - (65 + adder));
        }

        inverseKeyMatrix = calculateInverseKeyMatrix(keyMatrix);

        for (int i = 0; i < cipherToNumbers.size(); i += 2) {
            int decryptedX = (inverseKeyMatrix[0][0] * cipherToNumbers.get(i) + inverseKeyMatrix[0][1] * cipherToNumbers.get(i + 1)) % 26;
            int decryptedY = (inverseKeyMatrix[1][0] * cipherToNumbers.get(i) + inverseKeyMatrix[1][1] * cipherToNumbers.get(i + 1)) % 26;
            decryptedText.add(decryptedX);
            decryptedText.add(decryptedY);
        }

        displayResult("Decrypted text: ", adder, decryptedText);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("1. Encryption");
        System.out.println("2. Decryption");
        System.out.print("ch : ");
        String choice = scn.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Text: ");
                String textToEncrypt = scn.nextLine();
                encrypt(textToEncrypt, true);
                break;
            case "2":
                System.out.print("Cipher: ");
                String cipherToDecrypt = scn.nextLine();
                decrypt(cipherToDecrypt, true);
                break;
        }
    }
}
