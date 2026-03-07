package Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GameMap {

    private int numRows;
    private int numCols;
    private int[][] gameMap;

    public GameMap(int numRows, int numCols, int[][] gameMap) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.gameMap = gameMap;
    }
}
