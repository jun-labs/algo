package programmers.가장_큰_정사각형_찾기;

class Solution {

    private int[][] map;

    public int solution(int[][] board) {
        map = new int[board.length + 1][board[0].length + 1];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                map[x + 1][y + 1] = board[x][y];
            }
        }

        int max = -100_000;
        for (int x = 1; x < map.length; x++) {
            for (int y = 1; y < map[0].length; y++) {
                if (map[x][y] == 1) {
                    int left = map[x][y - 1];
                    int up = map[x - 1][y];
                    int leftUp = map[x - 1][y - 1];
                    int min = Math.min(left, Math.min(up, leftUp));
                    map[x][y] = min + 1;
                    max = Math.max(max, min + 1);

                }
            }
        }
        return (int) Math.pow(max, 2);
    }
}
