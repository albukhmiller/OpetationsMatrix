package com.operations.matrix.Utils;

import java.util.Arrays;

public class ValidatorMatrix {

    public static boolean determinantCalculate(double[][] mat) {
        double[][] matrix = new double[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            matrix[i] = new double[mat.length];
            matrix[i] = Arrays.copyOf(mat[i], mat.length);
        }
        double mulDiagonalElement = 1;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = i + 1; j < matrix[i].length; j++) {
                double factor = matrix[j][i] / matrix[i][i];

                for (int k = i; k < matrix.length; k++) {

                    matrix[j][k] -= matrix[i][k] * factor;
                    if (Double.isNaN(matrix[j][k]))
                        factor = 1;
                }
            }
            mulDiagonalElement *= matrix[i][i];
        }
        return mulDiagonalElement == 0.0 ? false : true;
    }
}
