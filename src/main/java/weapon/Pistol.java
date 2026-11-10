package weapon;

import exceptions.WeaponException;

public class Pistol extends GenericWeapon {

  /**
   * Constructor for a pistol. Sets base values.
   */
  public Pistol() {
    baseDamage = 10;
    currentAmmo = 10;
    maxAmmo = 10;
    maxRange = 50;
    rateOfFire = 2;
    shotsLeft = 2;
  }

  /**
   * Method to let a pistol fire. Computes damage rounded down.
   * @param distance
   * @return
   * @throws WeaponException
   */
  public int fire(int distance) throws WeaponException {
    if (currentAmmo > 0 && shotsLeft > 0) {
      int damage = 0;
      if (distance <= getMaxRange()) {
        damage = (int) Math.floor(baseDamage
                * ((getMaxRange() - distance + 10) / (double) getMaxRange()));
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
   * Method to describe a pistol.
   * @return
   */
  public String toString() {
    return "Pistol";
  }

  /**
   * Method to let a pistol reload.
   */
  public void reload() {
    currentAmmo = maxAmmo;
    shotsLeft = rateOfFire;
  }
}
