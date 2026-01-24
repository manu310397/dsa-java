public class LC_1266 {
    public static void main(String[] args) {
        int[][] input = {{1, 1}, {3, 4}, {-1, 0}};

        System.out.println(minTimeToVisitAllPoints(input));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int len = points.length;

        int[] cur = points[0];
        int seconds = 0;

        for (int i = 1; i < len; i++) {
            int[] dest = points[i];
            int di = dest[0];
            int dj = dest[1];

            int[] minPoint = new int[2];
            double minDis = Integer.MAX_VALUE;

            while (true) {
                int curi = cur[0];
                int curj = cur[1];
                int[][] nextPoints = {
                        {curi, curj + 1},
                        {curi + 1, curj + 1},
                        {curi + 1, curj},
                        {}
                };

                for (int[] next : nextPoints) {
                    if (next[0] == di && next[1] == dj) {
                        minPoint = next;
                        break;
                    }
                    double insideEq = Math.pow((double) (di - next[0]), 2) + Math.pow((double) (dj - next[1]), 2);
                    double dis = Math.sqrt(insideEq);

                    if (dis < minDis) {
                        minDis = dis;
                        minPoint = next;
                    }
                }

                cur = minPoint;
                seconds++;

                if (minPoint[0] == di && minPoint[1] == dj) {
                    break;
                }
            }

        }

        return seconds;
    }
}
