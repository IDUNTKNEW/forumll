package weapon;

import exceptions.AttachmentException;
import exceptions.WeaponException;

public class Scope extends Attachment {

  /**
   * Creates a scope
   * @param base the base weapon for a scope
   * @throws AttachmentException cannot have more than 2 attachments
   */
  public Scope(Weapon base) throws AttachmentException {
    if (base.getNumAttachments() == 2) {
      throw new AttachmentException("You cannot have more than 2 attachments!");
    }
    this.base = base;
  }

  /**
   * Scopes fire method
   * @param distance The distance a shot was fired at
   * @return damage done
   * @throws WeaponException cannot fire at a negative range
   */
  public int fire(int distance) throws WeaponException {
    int compensatedDistance = distance;
    if (distance <= getMaxRange()) {
      compensatedDistance = Math.min(distance, (getMaxRange() - 10));
    }
    int damage;
    if ((distance <= getMaxRange()) && (distance > base.getMaxRange())) {
      damage = (int) Math.floor(base.fire(compensatedDistance) + 5);
    } else {
      damage = (int) Math.floor(base.fire(compensatedDistance)
              * (1 + (getMaxRange() - distance) / (double) getMaxRange()));
    }
    return damage;
  }

  public int getMaxRange() {
    return base.getMaxRange() + 10;
  }

  public String toString() {
    return (base.toString() + " +Scope");
  }
}

