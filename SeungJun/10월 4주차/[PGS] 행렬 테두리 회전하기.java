class Solution {
    public int rotate(int[][] matrix, int x1, int y1, int x2, int y2) {
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int min = Integer.MAX_VALUE;
        int r = x1, c = y1;
        int idx = 0, prev = 0, next = matrix[x1][y1];

        while (idx < 4) {
            prev = next;

            r += delta[idx][0];
            c += delta[idx][1];

            next = matrix[r][c];
            matrix[r][c] = prev;

            min = Math.min(min, matrix[r][c]);

            int nr = r + delta[idx][0];
            int nc = c + delta[idx][1];

            if(nr < x1 || nr > x2 || nc < y1 || nc > y2) idx++;
        }

        return min;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        for(int i = 0, num = 1; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
        }

        return answer;
    }
}