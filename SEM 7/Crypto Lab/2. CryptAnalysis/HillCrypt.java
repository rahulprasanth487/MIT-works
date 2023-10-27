import java.io.*;
import java.util.*;

public class HillCrypt
{
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                result[i][j] = sum % 26; // Take the result modulo 26
            }
        }
        return result;
    }

    
    private static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        throw new ArithmeticException("Modular inverse does not exist.");
    }
    
    
    public static int[][] inverse(int[][] matrix){
        int n = matrix.length;
        int[][] augmentedMatrix = new int[n][2 * n];

        // Create an augmented matrix [matrix | I] where I is the identity matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1 : 0;
            }
        }

        // Apply Gaussian elimination to transform the left side into the identity matrix
        for (int i = 0; i < n; i++) {
            int pivotIdx = -1;
            for (int j = i; j < n; j++) {
                if (augmentedMatrix[j][i] != 0) {
                    pivotIdx = j;
                    break;
                }
            }

            if (pivotIdx == -1) {
                throw new ArithmeticException("Matrix is not invertible modulo 26.");
            }

            // Swap rows to make the pivot element non-zero
            int[] temp = augmentedMatrix[i];
            augmentedMatrix[i] = augmentedMatrix[pivotIdx];
            augmentedMatrix[pivotIdx] = temp;

            int pivot = augmentedMatrix[i][i];
            int pivotInverse = modInverse(pivot, 26);

            // Scale the row to make the pivot element 1
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] = (augmentedMatrix[i][j] * pivotInverse) % 26;
            }

            // Eliminate other rows
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    int factor = augmentedMatrix[j][i];
                    for (int k = 0; k < 2 * n; k++) {
                        augmentedMatrix[j][k] = (augmentedMatrix[j][k] - (factor * augmentedMatrix[i][k])) % 26;
                        if (augmentedMatrix[j][k] < 0) {
                            augmentedMatrix[j][k] += 26;
                        }
                    }
                }
            }
        }

        // Extract the right side of the augmented matrix as the inverse
        int[][] inverseMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverseMatrix;
    }

    public static void main(String[] args) {

	    System.out.println("\nInput is : HELL");
        System.out.println("Cipher of that Input is : DRJI");
		int [][] text = new int[][] {{7,11},{4,11}};
        int [][] cipher = new int[][] {{3,9},{17,8}};

	
	
	    System.out.println("INVERSE:");
        int[][] inverse = inverse(text);
        for (int[] row : inverse) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        
         System.out.println("\nKEY MATRIX:");
         
        int [][]mulMat = multiply(cipher, inverse);
	    for (int[] row : mulMat) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
	    
	}
}
