package com.operations.matrix;

abstract class BaseMatrix {

    protected final String DETENMINATE_ZERO = "Определитель равен 0!";

    protected double[][] matrixA;
    protected double[][] matrixB;

    protected void straightPass(boolean isGauss) {
        for (int i = 0; i < matrixA.length; i++) {

            dividerStringMatrix(matrixB[i], matrixA[i][i]);
            dividerStringMatrix(matrixA[i], matrixA[i][i]);

            nullificationStringMatrixStraight(i, isGauss);
            checkZeroString();
            System.out.println(toString());
        }
    }

    protected void reversePass(boolean isGauss) {
        for (int i = matrixA.length - 1; i >= 1; i--) {
            double factor;
            int kA = i;
            if (!isZeroString(matrixA[i]))
                for (int j = i - 1; j >= 0; j--) {

                    factor = matrixA[j][i] / matrixA[i][i];
                    if (Double.isInfinite(factor) || Double.isNaN(factor))
                        factor = 1;

                    if (matrixA[i][matrixA.length - 1] != 0)
                        kA = matrixA.length - 1;
                    for (int k = kA; k >= 0; k--)
                        matrixA[j][k] -= matrixA[i][k] * factor;

                    for (int k = 0; k < matrixB[i].length; k++)
                        if (!isGauss)
                            matrixB[j][k] -= matrixB[i][k] * factor;
                        else
                            matrixB[j][0] -= matrixB[i][0] * factor;
                }
        }
    }

    protected void nullificationStringMatrixStraight(int i, boolean isGauss) {
        for (int j = i + 1; j < matrixA.length; j++) {
            double factor;
            factor = matrixA[j][i] / matrixA[i][i];

            if (Double.isInfinite(factor) || Double.isNaN(factor))
                factor = 1;

            for (int kA = i; kA < matrixA.length; kA++) {
                matrixA[j][kA] -= matrixA[i][kA] * factor;
            }

            for (int kB = 0; kB < matrixB[i].length; kB++) {
                if (!isGauss)
                    matrixB[j][kB] -= matrixB[i][kB] * factor;
                else matrixB[j][0] -= matrixB[i][0] * factor;
            }
        }
    }

    private boolean isZeroString(double[] strMatrix) {
        double sum = 0;
        for (int i = 0; i < strMatrix.length; i++) {
            sum += strMatrix[i];
        }
        return (sum == 0) ? true : false;
    }

    private void checkZeroString() {

        for (int i = 0; i < matrixA.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrixA.length; j++) {
                sum += matrixA[i][j];
            }
            if (sum == 0) {
                double[] temp = matrixA[i];
                matrixA[i] = matrixA[matrixA.length - 1];
                matrixA[matrixA.length - 1] = temp;

                temp = matrixB[i];
                matrixB[i] = matrixB[matrixB.length - 1];
                matrixB[matrixB.length - 1] = temp;
            }
        }
    }

    protected boolean swapFirstElement(double[][] matA, double[][] matB) {

        for (int i = 1; i < matA.length; i++)
            if (matA[i][0] != 0) {
                double[] temp = matA[0];
                matA[0] = matA[i];
                matA[i] = temp;

                if (matB != null) {
                    temp = matrixB[0];
                    matrixB[0] = matrixB[i];
                    matrixB[i] = temp;
                }
                return true;
            }
        return false;
    }

    protected double[] dividerStringMatrix(double[] strMatrix, double diagonalElement) {
        for (int col = strMatrix.length - 1; col > -1; col--) {
            if (diagonalElement == 0)
                diagonalElement = 1;
            strMatrix[col] = strMatrix[col] / diagonalElement;

            if (strMatrix[col] == -0.0 || Double.isNaN(strMatrix[col]))
                strMatrix[col] = 0;
        }
        return strMatrix;
    }





    @Override
    public String toString() {

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j <= matrixA[i].length; j++)
                if (j < matrixA.length)
                    System.out.print(String.format("%.2f", matrixA[i][j]) + " ");
                else {
                    System.out.print("|");
                    for (int l = 0; l < matrixB.length; l++)
                        System.out.print(String.format("%.2f", matrixB[i][l]) + " ");
                }
            System.out.println();
        }
        return "";
    }
}
