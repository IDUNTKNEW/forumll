package weapon;

import exceptions.WeaponException;

public class ChainGun extends GenericWeapon {

  /**
   * Constructor for a chain gun. Sets the base values.
   */
  public ChainGun() {
    baseDamage = 15;
    currentAmmo = 40;
    maxAmmo = 40;
    maxRange = 60;
    rateOfFire = 4;
    shotsLeft = 4;
  }

  /**
   * Method for a chain gun to fire. Computes damage and rounds down.
   * @param distance
   * @return
   * @throws WeaponException
   */
  public int fire(int distance) throws WeaponException {
    if (currentAmmo > 0 && shotsLeft > 0) {
      int damage = 0;
      if (distance <= maxRange) {
        damage = (int) Math.floor(baseDamage * (distance / (double) maxRange));
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
   * Method to describe the weapon.
   * @return
   */
  public String toString() {
    return "ChainGun";
  }

  /**
   * Method to reload the ammo of a chain gun.
   */
  public void reload() {
    currentAmmo = maxAmmo;
    shotsLeft = rateOfFire;
  }
}
