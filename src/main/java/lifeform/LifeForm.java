package lifeform;

import weapon.Weapon;

/**
 * Keeps track of the information associated with a simple life form.
 * Also provide the functionality related to the life form.
 */
public abstract class LifeForm {
  protected String myName;
  protected int currentLifePoints;
  protected int attackStrength;
  protected Weapon weapon;
  private boolean currHasWeapon = false;
  protected int row = -1;
  protected int col = -1;
  protected int currentDirection = 0;
  protected int maxSpeed = 0;

  /**
   * Create an instance
   *
   * @param name   Name of lifeform.
   * @param points Amount of life points.
   */
  public LifeForm(String name, int points) {
    myName = name;
    currentLifePoints = Math.max(0, points);
  }

  /**
   * Create an instance with a strength value
   *
   * @param name     Name of lifeform.
   * @param points   Amount of life points.
   * @param strength Attack strength value.
   */
  public LifeForm(String name, int points, int strength) {
    myName = name;
    currentLifePoints = points;
    attackStrength = strength;
  }

  /**
   * @return The name of the lifeform.
   */
  public String getName() {
    return myName;
  }

  /**
   * @return The current amount of life points of a lifeform.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * sets currentLifePoints
   *
   * @param lifePoints health value
   */
  public void setCurrentLifePoints(int lifePoints) {
    currentLifePoints = lifePoints;
  }

  /**
   * take hit for lifeform
   *
   * @param damage damage to be taken
   */
  public void takeHit(int damage) {
    int hit = Math.max(0, damage);
    currentLifePoints = Math.max(currentLifePoints - hit, 0);
  }

  /**
   * sets attackStrength
   *
   * @param attack attack to be set
   */
  public void setAttackStrength(int attack) {
    attackStrength = attack;
  }

  /**
   * returns attackStrength
   *
   * @return attack
   */
  public int getAttackStrength() {
    return attackStrength;
  }

  /**
   * Takes one lifeform and makes them attack another using takeHit
   *
   * @param opponent the lifeform being attacked
   */
  public void attack(LifeForm opponent, int range) {
    boolean attackIsMelee = (range <= 5);
    if (currentLifePoints > 0) {
      if (attackIsMelee) {
        opponent.takeHit(getAttackStrength());
      } else if (currHasWeapon) {
        opponent.takeHit(weapon.fire(range));
      }
      //if you don't have a weapon and are too far away, doesn't do either
    }
  }

  /**
   * Method to let a lifeform pick up a weapon.
   *
   * @param weapon
   * @return
   */
  public boolean pickUpWeapon(Weapon weapon) {
    boolean didPickUpWeapon = false;
    if (!currHasWeapon) {
      this.weapon = weapon;
      currHasWeapon = true;
      didPickUpWeapon = true;
    }
    return didPickUpWeapon;
  }

  /**
   * Method to let a lifeform drop a weapon.
   *
   * @return
   */
  public Weapon dropWeapon() {
    currHasWeapon = false;
    Weapon outputWeapon = weapon;
    weapon = null;
    return outputWeapon;
  }

  /**
   * Method to check if a lifeform currently has a weapon.
   *
   * @return
   */
  public boolean hasWeapon() {
    return currHasWeapon;
  }

  /**
   * gets a lifeform's row value
   *
   * @return row value
   */
  public int getRow() {
    return row;
  }

  /**
   * gets a lifeform's column value
   *
   * @return column value
   */
  public int getCol() {
    return col;
  }

  /**
   * sets a lifeform's location
   *
   * @param rowNew the new row value for the lifeform
   * @param colNew the new column value for the lifeform
   */
  public void setLocation(int rowNew, int colNew) {
    if (rowNew < 0 || colNew < 0) {
      row = -1;
      col = -1;
    } else {
      row = rowNew;
      col = colNew;
    }
  }

  public void changeDirection(int direction) {
    currentDirection = direction;
  }
}
