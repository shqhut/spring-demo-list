
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {

    int[][] preMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            this.preMatrix = new int[1][1];
            return;
        }
        preMatrix = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            for (int j = 1; j <=n; j++) {
//                preMatrix[1][1] = preMatrix[0][0] + preMatrix[0][1] + preMatrix[1][0] + matrix[1][1];
                preMatrix[i][j] = preMatrix[i-1][j] + preMatrix[i][j-1] + matrix[i-1][j-1] - preMatrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
//        return preMatrix[row2+1][col2+1]-preMatrix[row2+1][col1+1]-preMatrix[row1+1][col2+1]+preMatrix[row1+1][col1+1];
        int x1 = preMatrix[row2+1][col2+1];
        int x2 = preMatrix[row2+1][col1];
        int x3 = preMatrix[row1][col2+1];
        int x4 = preMatrix[row1][col1];
        return x1-x2-x3+x4;
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
