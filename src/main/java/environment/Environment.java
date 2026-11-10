package environment;

import lifeform.LifeForm;
import weapon.Weapon;

public class Environment {
  private Cell[][] cells;
  private static Environment env;

  /**
   * Environment constructor
   *
   * @param rows Rows in the array.
   * @param cols Columns in the array.
   */
  private Environment(int rows, int cols) {
    cells = new Cell[rows][cols];
    for (int numRow = 0; numRow < rows; numRow++) {
      for (int numCol = 0; numCol < cols; numCol++) {
        cells[numRow][numCol] = new Cell();
      }
    }
  }

  /**
   *
   * @param rows how many rows of the environment
   * @param cols how many cols of the environment
   * @return the singleton of the environment
   */
  public static synchronized Environment getEnvironment(int rows, int cols) {
    if (env == null) {
      env = new Environment(rows, cols);
    }
    return env;
  }

  /**
   * Removes all LifeForms and Weapons from the Environment.
   * Useful for tests and game resets.
   */
  public void clearBoard() {
    for (int r = 0; r < cells.length; r++) {
      for (int c = 0; c < cells[0].length; c++) {
        cells[r][c] = new Cell();
      }
    }
  }

  /**
   * @return The number of rows in the Environment.
   */
  public int getNumRows() {
    return cells.length;
  }

  /**
   * @return The number of columns in the Environment.
   */
  public int getNumCols() {
    if (cells.length > 0) {
      return cells[0].length;
    }
    return 0;
  }

  /**
   * Adds a LifeForm to the Cell cells[rows][col].
   * Will not add the LifeForm if the row and col are
   * invalid or if a LifeForm is already in that cell
   *
   * @param lf  Input LifeForm
   * @param row Row number where input LifeForm will be placed
   * @param col Column number where input Lifeform will be placed
   * @return If a LifeForm was successfully made or not
   */
  public boolean addLifeForm(LifeForm lf, int row, int col) {
    if (row < 0 || col < 0 || row >= cells.length || col >= cells[0].length) {
      return false;
    }
    if (cells[row][col].getLifeForm() == null) {
      cells[row][col].addLifeForm(lf);
      lf.setLocation(row, col);
      return true;
    }
    return false;
  }

  /**
   * Removes a cell at a certain cell
   *
   * @param row Row number
   * @param col Column number
   */
  public void removeLifeForm(int row, int col) {
    if (row >= 0 && col >= 0 && row < cells.length && col < cells[0].length) {
      cells[row][col].removeLifeForm();
    }
  }

  /**
   * Gets the LifeForm at a specific cell
   *
   * @param row Row number
   * @param col Column Number
   * @return The LifeForm at a cell
   */
  public LifeForm getLifeForm(int row, int col) {
    if (row < 0 || col < 0 || row >= cells.length || col >= cells[0].length) {
      return null;
    }
    return cells[row][col].getLifeForm();
  }

  /**
   *
   * @param weapon the weapon added
   * @param row    the row of the cell the weapon is on
   * @param col    the column of the cell the weapon is on
   * @return if the weapon was added successfully
   */
  public boolean addWeapon(Weapon weapon, int row, int col) {
    if (row < 0 || col < 0 || row >= cells.length || col >= cells[0].length) {
      return false;
    }
    return cells[row][col].addWeapon(weapon);
  }

  /**
   *
   * @param weapon weapon to remove
   * @param row    row of the weapon
   * @param col    column of the weapon
   * @return the weapon that was removed returns null if no weapon was removed
   */
  public Weapon removeWeapon(Weapon weapon, int row, int col) {
    if (row < 0 || col < 0 || row >= cells.length || col >= cells[0].length) {
      return null;
    }
    return cells[row][col].removeWeapon(weapon);
  }

  /**
   *
   * @param row row of the Cell with weapons
   * @param col col of the Cell with weapons
   * @return the array of weapons
   */
  public Weapon[] getWeapons(int row, int col) {
    if (row < 0 || col < 0 || row >= cells.length || col >= cells[0].length) {
      return null;
    }
    Weapon[] w = new Weapon[2];
    w[0] = cells[row][col].getWeapon1();
    w[1] = cells[row][col].getWeapon2();
    return w;
  }

  /**
   * Calculates the Euclidean distance using the 5x5ft cell multiplier.
   */
  public double getDistance(int row1, int col1, int row2, int col2) {
    // Each cell is a 5x5 area, so we multiply the row/col grid difference by 5.0
    double rowDiff = (row1 - row2) * 5.0;
    double colDiff = (col1 - col2) * 5.0;

    return Math.sqrt((rowDiff * rowDiff) + (colDiff * colDiff));
  }

  /**
   * Calculates the Euclidean distance using the 5x5ft cell multiplier.
   */
  public double getDistance(LifeForm lf1, LifeForm lf2) {
    return getDistance(lf1.getRow(), lf1.getCol(), lf2.getRow(), lf2.getCol());
  }
}