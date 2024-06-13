public class Matrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] ta = new int[matrix[0].length][matrix.length]; // Definition der transponierten Matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ta[j][i] = matrix[i][j];
            }
        }
        return ta;
    }

    public static int[][] mult(int[][] matrixA, int[][] matrixB) {
        int za = matrixA.length; // Zeilen von Matrix A
        int sa = matrixA[0].length; // Spalten von Matrix A
        int zb = matrixB.length; // Zeilen von Matrix B
        int sb = matrixB[0].length; // Spalten von Matrix B
        if (sa != zb) {
            System.out.println("Die Dimensionen der Matrizen passen nicht zusammen.");
            return null; // rückgabe einer null-matrix
        }
        // falls sie passieren zusammen 
        int[][] result = new int[za][sb];

        // Matrixmultiplikation
        for (int i = 0; i < za; i++) { // für deje zeile in A
            for (int j = 0; j < sb; j++) { // fr jede spalte in B
                for (int k = 0; k < sa; k++) { // für jede element in zeile i 
                    result[i][j] += matrixA[i][k] * matrixB[k][j]; 
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("M[" + (i + 1) + "][" + (j + 1) + "] = " + matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] A = {
            {1, 4},
            {2, 5},
            {3, 6}
        };

        int[][] B = {
            {7, 8,9,10},
            {9, 10,2,3},
            {11, 12,4,5},
            {7, 8,1,2},
        };
        int[][] C = {
            {7, 8, 9, 10},
            {1, 9, 8, 5},
        };
        // trans
        int[][] ta = transpose(A);
        System.out.println("Transponierte Matrix A:");
        printMatrix(ta);
        // mult
        System.out.println("Ergebnis der Matrixmultiplikation von A*B:");
        int[][] res1= mult(A, B);
        if(res1 != null){
            printMatrix(res1);
        }

        int[][] res2= mult(A, C);
        if(res2 != null){
            System.out.println("Ergebnis der Matrixmultiplikation von A*C:");
            printMatrix(res2);
        }
    }
}
