package com.operations.matrix;

import com.operations.matrix.interfaces.MatrixOperation;

public class Main {

    public static void main(String[] args) {

        double[][] matrix = {
                {0, 0, 3},
                {-4, 0, 4},
                {0, 0, 2}
        };

        MatrixOperation gauss = new LUExpansion(matrix);
        System.out.println(gauss.toString());
        gauss.calculate();

//        lu.calculate();
//        System.out.println("INverse===============");
        System.out.println(gauss.toString());

//        gauss.calculate();
//        System.out.println("Gauss===============");
//        System.out.println(gauss.toString());

    }

}
