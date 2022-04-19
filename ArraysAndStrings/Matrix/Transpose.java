package ArraysAndStrings.Matrix;

class Transpose {
    public int[][] transpose(int[][] matrix) {

        int[][] solution = new int[matrix[0].length][matrix.length];

        for (int xx = 0; xx < matrix.length; xx++) {
            for (int yy = 0; yy < matrix[0].length; yy++) {
                solution[yy][xx] = matrix[xx][yy];
            }
        }
        return solution;
    }
}