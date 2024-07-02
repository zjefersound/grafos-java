package MazeSolver;

import java.io.File;
import java.util.Scanner;

public class FileReader {
  private int[][] map;
  private String fileName;
  private int numOfRows;
  private int numOfColumns;
  private int startPositionCol;
  private int startPositionRow;

  public FileReader(String fileName, int numOfRows, int numOfColumns) {
    this.fileName = fileName;
    this.numOfRows = numOfRows;
    this.numOfColumns = numOfColumns;
    this.map = new int[numOfRows][numOfColumns];
  }

  public void parseFile() {
    try {
      Scanner scanner = new Scanner(new File(this.fileName));

      for (int row = 0; row < this.numOfRows; row++) {
        for (int column = 0; column < this.numOfColumns; column++) {
          map[row][column] = scanner.nextInt();

          if (map[row][column] == 2) {
            this.startPositionRow = row;
            this.startPositionCol = column;
          }
        }
      }

      scanner.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int getStartPositionCol() {
    return this.startPositionCol;
  }

  public int getStartPositionRow() {
    return this.startPositionRow;
  }

  public int[][] getMap() {
    return this.map;
  }
}
