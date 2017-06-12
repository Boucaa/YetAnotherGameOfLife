package logic;

/**
 * Created by colander on 6/5/17.
 */
public class Game {

    private boolean[][] map;

    public Game(int width, int height) {
        this.map = new boolean[width][height];
        baseInit();
    }


    //TODO:to be removed
    private void baseInit() {
        this.map[10][10] = true;
        this.map[10][11] = true;
        this.map[10][12] = true;
        this.map[11][11] = true;
        this.map[12][11] = true;
    }

    private int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public void step() {
        //leaves out the edges -> they can never become active
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                int sum = 0;
                for (int[] direction : directions) {
                    sum += map[i + direction[0]][j + direction[1]] ? 1 : 0;
                }

                switch (sum) {
                    case 0:
                    case 1:
                        map[i][j] = false;
                        break;
                    case 3:
                        map[i][j] = true;
                        break;
                    default:
                        if (sum != 2) map[i][j] = false;
                }
            }
        }
    }


    public void flip(int x, int y) {
        if (x >= 0 && y >= 0 && x < map.length && y < map[0].length) map[x][y] = !map[x][y];
    }

    public boolean[][] getMap() {
        return map;
    }
}
