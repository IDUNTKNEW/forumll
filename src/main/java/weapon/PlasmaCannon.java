package weapon;

import exceptions.WeaponException;

public class PlasmaCannon extends GenericWeapon {

  /**
   * Constructor for a plasma cannon. Sets all values.
   */
  public PlasmaCannon() {
    baseDamage = 50;
    currentAmmo = 4;
    maxAmmo = 4;
    maxRange = 40;
    rateOfFire = 1;
    shotsLeft = 1;
  }

  /**
   * Method for a plasma cannon to fire. Computes damage rounded down.
   * @param distance
   * @return
   * @throws WeaponException
   */
  @Override
  public int fire(int distance) throws WeaponException {
    if (currentAmmo > 0 && shotsLeft > 0) {
      int damage = 0;
      if (distance <= getMaxRange()) {
        damage = (int) (Math.floor(baseDamage * (getCurrentAmmo() / (double) (maxAmmo))));
      }
      currentAmmo--;
      shotsLeft--;
      return damage;
    } else if (distance < 0) {
      throw new WeaponException("You cannot fire at a negative range!");
    } else {
      return 0;
    }
  }

  /**
   * Method to describe a plasma cannon.
   * @return
   */
  public String toString() {
    return ("PlasmaCannon");
  }

  /**
   * Method to reload a plasma cannon.
   */
  public void reload() {
    currentAmmo = maxAmmo;
    shotsLeft = rateOfFire;
  }
}
