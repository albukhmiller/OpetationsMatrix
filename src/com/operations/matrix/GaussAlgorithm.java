package com.operations.matrix;


import com.operations.matrix.interfaces.MatrixOperation;

public class GaussAlgorithm extends BaseMatrix implements MatrixOperation {

    private final String MATRIX_CONSASTENCY = "Матрица несовместна!";

    public GaussAlgorithm(double[][] matrix) {
        matrixB = new double[matrix.length][];
        matrixA = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrixA[i] = new double[matrix.length];
            matrixB[i] = new double[1];
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == matrix[i].length - 1)
                    matrixB[i][0] = matrix[i][j];
                else matrixA[i][j] = matrix[i][j];
            }
        }
    }

    @Override
    public void calculate() {
        System.out.println(toString());
        if (matrixA[0][0] == 0)
            if (!swapFirstElement(matrixA, matrixB)) {
                System.out.println("Решений нет!");
                return;
            }
        System.out.println(toString());
        straightPass(true);
        if (!isСonsistencyMatrix()) {
            System.out.println(MATRIX_CONSASTENCY);
            return;
        }

        reversePass(true);
        System.out.println(toString());
    }


    private boolean isСonsistencyMatrix() {
        for (int i = 0; i < matrixA.length; i++) {
            double sumElement = 0;
            for (int j = 0; j < matrixA.length; j++)
                sumElement += matrixA[i][j];
            if (sumElement == 0 && matrixB[i][0] != 0)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++)
                System.out.print(String.format("%.2f", matrixA[i][j]) + " ");
            System.out.println("|" + String.format("%.2f", matrixB[i][0]));
        }
        return "";
    }
}

