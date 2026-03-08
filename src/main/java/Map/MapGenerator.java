package Map;

import java.io.FileWriter;
import java.io.IOException;

public class MapGenerator {

    public static void main(String[] args) {

        int SIZE = 50;
        int[][] grid = new int[SIZE][SIZE];

        // Fill with short grass
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                grid[y][x] = 1;
            }
        }

        // Border walls
        for (int i = 0; i < SIZE; i++) {
            grid[0][i] = 5;
            grid[SIZE-1][i] = 5;
            grid[i][0] = 5;
            grid[i][SIZE-1] = 5;
        }

        // Cross roads in the middle
        for (int i = 0; i < SIZE; i++) {
            grid[24][i] = 4;
            grid[25][i] = 4;
            grid[i][24] = 4;
            grid[i][25] = 4;
        }

        // Tree cluster 1
        for (int y = 6; y < 10; y++) {
            for (int x = 6; x < 10; x++) {
                grid[y][x] = 3;
            }
        }

        // Tree cluster 2
        for (int y = 35; y < 40; y++) {
            for (int x = 35; x < 40; x++) {
                grid[y][x] = 3;
            }
        }

        // Long grass patch 1
        for (int y = 2; y < 6; y++) {
            for (int x = 2; x < 6; x++) {
                grid[y][x] = 2;
            }
        }

        // Long grass patch 2
        for (int y = 30; y < 34; y++) {
            for (int x = 10; x < 15; x++) {
                grid[y][x] = 2;
            }
        }

        // Write map to file
        try {
            FileWriter writer = new FileWriter("map.txt");

            for (int y = 0; y < SIZE; y++) {
                for (int x = 0; x < SIZE; x++) {
                    writer.write(grid[y][x] + " ");
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Map generated: map.txt");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
