package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class PowerBooster extends Attachment {

  /**
   * Creates a Power Booster
   * @param base the base weapon
   * @throws AttachmentException cannot have more than 2 attachments
   */
  public PowerBooster(Weapon base) throws AttachmentException {
    if (base.getNumAttachments() == 2) {
      throw new AttachmentException("You cannot have more than 2 attachments!");
    }
    this.base = base;
  }

  /**
   * Power Booster's fire method
   * @param distance The distance a shot was fired at
   * @return damage done
   * @throws WeaponException cannot fire at a negative range
   */
  public int fire(int distance) throws WeaponException {
    double multiplier = (1.0 + (base.getCurrentAmmo()) / (base.getMaxAmmo() / 1.0));
    double baseDamage = base.fire(distance);
    return (int) Math.floor(baseDamage * multiplier);
  }

  public String toString() {
    return (base.toString() + " +PowerBooster");
  }

}
