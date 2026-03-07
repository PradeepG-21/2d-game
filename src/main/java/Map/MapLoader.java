package Map;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MapLoader {
    public static GameMap loadGameMap(String mapPath) {

        int rows;
        int cols;
        int[][] map;

        try {
            map = readGrid(mapPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        rows = map.length;
        cols = map[0].length;

        return new GameMap(rows, cols, map);
    }

    private static int[][] readGrid(String filePath) throws IOException {
        List<int[]> rows = new ArrayList<>();

        try (InputStream is = MapLoader.class.getClassLoader().getResourceAsStream(filePath)) {
            assert is != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String line;

                while ((line = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line);
                    int[] row = new int[st.countTokens()];

                    for (int i = 0; i < row.length; i++) {
                        row[i] = Integer.parseInt(st.nextToken());
                    }

                    rows.add(row);
                }
            }
        }

        return rows.toArray(new int[rows.size()][]);
    }
}
