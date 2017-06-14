package logic;

/**
 * Created by colander on 6/5/17.
 * This class handles all the game logic, most importantly the stepping process.
 */
public class Game {

    private boolean[][] map;

    public Game(int width, int height) {
        this.map = new boolean[width][height];
        baseInit();
    }


    //just to display the functionality right away without having to draw
    private void baseInit() {
        this.map[10][10] = true;
        this.map[10][11] = true;
        this.map[10][12] = true;
        this.map[11][11] = true;
        this.map[12][11] = true;
    }

    private int[][] directions = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };

    public void step() {
        //leaves out the edges -> they can never become active
        boolean[][] newMap = new boolean[map.length][map[0].length];
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                int sum = 0;
                for (int[] direction : directions) {
                    sum += map[i + direction[0]][j + direction[1]] ? 1 : 0;
                }

                switch (sum) {
                    case 0:
                        newMap[i][j] = false;
                        break;
                    case 1:
                        newMap[i][j] = false;
                        break;
                    case 2:
                        newMap[i][j] = map[i][j];
                        break;
                    case 3:
                        newMap[i][j] = true;
                        break;
                    default:
                        newMap[i][j] = false;
                }
            }
        }
        map = newMap;
    }


    public void flip(int x, int y) {
        if (x >= 0 && y >= 0 && x < map.length && y < map[0].length) map[x][y] = !map[x][y];
    }

    public boolean[][] getMap() {
        return map;
    }
}
