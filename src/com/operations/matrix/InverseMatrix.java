package com.operations.matrix;

import com.operations.matrix.Utils.ValidatorMatrix;
import com.operations.matrix.interfaces.MatrixOperation;

public class InverseMatrix extends BaseMatrix implements MatrixOperation {

    private double[] freePart;

    public InverseMatrix(double[][] matrix) {
        initSingleMatrix(matrix.length);

        freePart = new double[matrix.length];
        matrixA = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrixA[i] = new double[matrix.length];

            for (int j = 0; j < matrix[i].length; j++) {
                if (j == matrix[i].length - 1)
                    freePart[i] = matrix[i][j];
                else matrixA[i][j] = matrix[i][j];
            }
            System.out.println();
        }
    }


    @Override
    public void calculate() {
        System.out.println(toString());
        if (!ValidatorMatrix.determinantCalculate(matrixA)) {
            System.out.println(DETENMINATE_ZERO);
            return;
        }

        straightPass(false);
        reversePass(false);
        multMatrix();
    }

    private double[][] initSingleMatrix(int sizeMatrix) {
        matrixB = new double[sizeMatrix][];

        for (int i = 0; i < sizeMatrix; i++) {
            matrixB[i] = new double[sizeMatrix];
            for (int j = 0; j < sizeMatrix; j++)
                if (j == i)
                    matrixB[i][i] = 1;
                else matrixB[i][j] = 0;
        }
        return matrixB;
    }

    private void multMatrix() {
        double[] res = new double[matrixB.length];
        for (int i = 0; i < matrixB.length; i++) {
            for (int j = 0; j < matrixB.length; j++) {
                res[i] += matrixB[i][j] * freePart[j];
            }
        }

        System.out.println("Inverse Matrix");
        for (int i = 0; i < res.length; i++) {
            System.out.println(String.format("%.2f", res[i]) + " ");

        }
        return;
    }
}
