import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {

    }

    ArrayList<String> ans = new ArrayList<>();

    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int m = mat.size();

        int[][] grid = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = mat.get(i).get(j);
            }
        }

        if (grid[0][0] == 0) return ans;

        boolean[][] v = new boolean[m + 1][m + 1];
        v[0][0] = true;
        f(0, 0, m, new StringBuilder(), grid, v);

        return ans;
    }

    private void f(int i, int j, int m, StringBuilder t, int[][] grid, boolean[][] v) {
        if (i == m - 1 && j == m - 1) {
            ans.add(t.toString());
            return;
        }

        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        String dir = "DLRU";
        for (int d = 0; d < 4; d++) {
            int ix = i + dirs[d][0];
            int jy = j + dirs[d][1];

            System.out.println("ix = " + ix);
            System.out.println("jy = " + jy);

            if (ix >= 0 && ix < m && jy >= 0 && jy < m && !v[ix][jy] && grid[ix][jy] == 1) {
                v[ix][jy] = true;
                t.append(dir.charAt(d));
                f(ix, jy, m, t, grid, v);
                t.deleteCharAt(t.length() - 1);
                v[ix][jy] = false;
            }

        }
    }
}
