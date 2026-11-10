package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class Stabilizer extends Attachment {

  /**
   * Makes a Stabilizer
   * @param baseWeapon the base weapon for the stabilizer
   * @throws AttachmentException can only have 2 attachments at a time on a weapon
   */
  public Stabilizer(Weapon baseWeapon) throws AttachmentException {
    if (baseWeapon.getNumAttachments() == 2) {
      throw new AttachmentException("You cannot have more than 2 attachments!");
    }
    this.base = baseWeapon;
  }

  /**
   * Stabilizer's fire method
   * @param distance The distance a shot was fired at
   * @return damage done
   * @throws WeaponException cannot fire at a negative range
   */
  public int fire(int distance) throws WeaponException {

    int damage = (int) (Math.floor(1.25 * (base.fire(distance))));
    if (base.getCurrentAmmo() == 0) {
      base.reload();
    }
    return damage;
  }

  public String toString() {
    return (base.toString() + " +Stabilizer");
  }
}
