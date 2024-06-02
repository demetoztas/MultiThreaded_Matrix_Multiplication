public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] B = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] C = new int[5][5];

        
        Thread[] threads = new Thread[5];

        
        for (int i = 0; i < 5; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    C[row][j] = 0;
                    for (int k = 0; k < 5; k++) {
                        C[row][j] += A[row][k] * B[k][j];
                    }
                }
            });
            threads[i].start();
        }

        
        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        
        System.out.println("Matrix C Sonuç");
        
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
