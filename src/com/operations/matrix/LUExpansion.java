package com.operations.matrix;

import com.operations.matrix.Utils.ValidatorMatrix;
import com.operations.matrix.interfaces.MatrixOperation;

public class LUExpansion extends BaseMatrix implements MatrixOperation {

    public LUExpansion(double[][] matrix) {
        this.matrixA = matrix;
        initSingleMatrix(matrix.length);
    }

    @Override
    protected void straightPass(boolean isGauss) {


        if (!ValidatorMatrix.determinantCalculate(matrixA)) {
            System.out.println(DETENMINATE_ZERO);
            return;
        }

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = i + 1; j < matrixA.length; j++) {
                double factor = matrixA[j][i] / matrixA[i][i];
                for (int kA = i; kA < matrixA.length; kA++)
                    matrixA[j][kA] -= matrixA[i][kA] * factor;
                matrixB[j][i] = factor;
            }
        }
    }


    // метод гаусса = метод обртной матрицы
    @Override
    public void calculate() {
        straightPass(false);
        System.out.println(toString());
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
}
