package Algorithm;

import java.util.*;

public class G1681203 {
    // 방법 1. 거리가 m이하인 칸 모두 탐색하기
    static class Pair {
        int x;
        int y;

        Pair() {
        }

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean search(int x, int y, int[][] ground, int n, int m) {
        // |dx|+|dy|<=m

        // 윗 부분 탐색
        for (int i = -m; i <= 0; i++) {
            for (int j = -m - i; j <= m + i; j++) {
                if (0 <= x + i && x + i < n && 0 <= y + j && y + j < n) {
                    if (ground[x + i][y + j] == 2) {
                        return true;
                    }
                }
            }
        }

        // 아래 부분 탐색
        for (int i = 1; i <= m; i++) {
            for (int j = -m + i; j <= m - i; j++) {
                if (0 <= x + i && x + i < n && 0 <= y + j && y + j < n) {
                    if (ground[x + i][y + j] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ground = new int[n][n];
        ArrayList<Pair> ants = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ground[i][j] = sc.nextInt();
                if (ground[i][j] == 1) {
                    ants.add(new Pair(i, j));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < ants.size(); i++) {
            Pair p = ants.get(i);
            if (search(p.x, p.y, ground, n, m)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
