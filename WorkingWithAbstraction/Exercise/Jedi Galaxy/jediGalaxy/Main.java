package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] heroCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            validateCoordinates(matrix, evilRow, evilCol);

            int heroRow = heroCoordinates[0];
            int heroCol = heroCoordinates[1];

            sum = getSum(matrix, sum, heroRow, heroCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static long getSum(int[][] matrix, long sum, int heroRow, int heroCol) {
        while (heroRow >= 0 && heroCol < matrix[1].length) {
            if (heroRow >= 0 && heroRow < matrix.length && heroCol >= 0 && heroCol < matrix[0].length) {
                sum += matrix[heroRow][heroCol];
            }
            heroCol++;
            heroRow--;
        }
        return sum;
    }

    private static void validateCoordinates(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
}
