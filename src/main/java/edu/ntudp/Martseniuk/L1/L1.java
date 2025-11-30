package edu.ntudp.Martseniuk.L1;

import java.util.Scanner;
import java.util.Random;

public class L1 {
    private static final int MIN_RANDOM_VALUE = -100;
    private static final int MAX_RANDOM_VALUE = 100;
    private static final int MAX_SIZE = 20;

    private static Scanner scanner = new Scanner(System.in);
    private static int[][] matrix;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        System.out.println(" Matrix  Program \n");

        inputMatrixSizeFromUser();
        int choice = chooseMatrixCreationMethod();

        if (choice == 1) {
            createMatrixByManualInput();
        } else {
            createMatrixWithRandomValues();
        }

        displayMatrixOnScreen();

        int min = findMinimumElementInMatrix();
        System.out.println("\nMinimum element: " + min);

        int max = findMaximumElementInMatrix();
        System.out.println("Maximum element: " + max);

        double avg = calculateAverageOfAllElements();
        System.out.printf("Average: %.2f%n", avg);

        scanner.close();
    }

    private static void inputMatrixSizeFromUser() {
        do {
            System.out.print("Enter number of rows (1-" + MAX_SIZE + "): ");
            rows = scanner.nextInt();
            if (rows < 1 || rows > MAX_SIZE) {
                System.out.println("Error! Number of rows must be between 1 and " + MAX_SIZE);
            }
        } while (rows < 1 || rows > MAX_SIZE);

        do {
            System.out.print("Enter number of columns (1-" + MAX_SIZE + "): ");
            cols = scanner.nextInt();
            if (cols < 1 || cols > MAX_SIZE) {
                System.out.println("Error! Number of columns must be between 1 and " + MAX_SIZE);
            }
        } while (cols < 1 || cols > MAX_SIZE);

        matrix = new int[rows][cols];
    }

    private static int chooseMatrixCreationMethod() {
        int choice;
        do {
            System.out.println("\nChoose matrix creation method:");
            System.out.println("1 - Manual input");
            System.out.println("2 - Random generation");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 2) {
                System.out.println("Error! Choose 1 or 2.");
            }
        } while (choice < 1 || choice > 2);

        return choice;
    }

    private static void createMatrixByManualInput() {
        System.out.println("\nEnter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void createMatrixWithRandomValues() {
        Random random = new Random();
        System.out.println("\nGenerating matrix randomly...");
        System.out.println("Value range: from " + MIN_RANDOM_VALUE + " to " + MAX_RANDOM_VALUE);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }
    }

    private static void displayMatrixOnScreen() {
        System.out.println("\nMatrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int findMinimumElementInMatrix() {
        int minimumValue = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < minimumValue) {
                    minimumValue = matrix[i][j];
                }
            }
        }
        return minimumValue;
    }

    private static int findMaximumElementInMatrix() {
        int maximumValue = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > maximumValue) {
                    maximumValue = matrix[i][j];
                }
            }
        }
        return maximumValue;
    }

    private static double calculateAverageOfAllElements() {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
                count++;
            }
        }

        return (double) sum / count;
    }
}