package environment;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A cell that can hold a LifeForm, and/or two weapons.
 */
public class Cell {
  protected LifeForm creature = null;
  protected int weaponCount = 2;
  protected Weapon[] weaponList = new Weapon[weaponCount];

  /**
   * Tries to add the LifeForm to the Cell. Will not add if a
   * LifeForm is already present.
   *
   * @param lf the lifeform held in the cell
   * @return true if the LifeForm was added to the Cell, false otherwise.
   */
  public boolean addLifeForm(LifeForm lf) {
    if (creature == null) {
      creature = lf;
      return true;
    } else {
      return false;
    }
  }

  /**
   * Removes a life form
   */
  public void removeLifeForm() {
    creature = null;
  }

  /**
   * @return The LifeForm in this cell.
   */
  public LifeForm getLifeForm() {
    return creature;
  }

  /**
   * Add a weapon
   */
  public boolean addWeapon(Weapon w) {
    for (int i = 0; i < weaponCount; i++) {
      if (w == weaponList[i]) {
        return false;
      }
    }
    for (int i = 0; i < weaponCount; i++) {
      if (weaponList[i] == null) {
        weaponList[i] = w;
        return true;
      }
    }
    return false;
  }

  /**
   * @return weapon1
   */
  public Weapon getWeapon1() {
    return weaponList[0];
  }

  /**
   * @return weapon2
   */
  public Weapon getWeapon2() {
    return weaponList[1];
  }

  /**
   * @return weapon count
   */
  public int getWeaponsCount() {
    int count = 0;
    for (int i = 0; i < weaponCount; i++) {
      if (weaponList[i] != null) {
        count++;
      }
    }
    return count;
  }

  /**
   * Removes a weapon
   */
  public Weapon removeWeapon(Weapon w) {
    for (int i = 0; i < weaponCount; i++) {
      if (weaponList[i] == w) {
        weaponList[i] = null;
        return w;
      }
    }
    return null;
  }

}
