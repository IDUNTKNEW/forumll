package weapon;

import gameplay.TimerObserver;

public abstract class GenericWeapon implements Weapon, TimerObserver {
  protected int baseDamage;
  protected int currentAmmo;
  protected int maxAmmo;
  protected int maxRange;
  protected int rateOfFire;
  protected int shotsLeft;

  public abstract int fire(int distance);

  public int getBaseDamage() {
    return baseDamage;
  }

  public int getCurrentAmmo() {
    return currentAmmo;
  }

  public int getMaxAmmo() {
    return maxAmmo;
  }

  public int getMaxRange() {
    return maxRange;
  }

  public int getNumAttachments() {
    return 0;
  }

  public int getRateOfFire() {
    return rateOfFire;
  }

  public int getShotsLeft() {
    return shotsLeft;
  }

  public void reload() {
    currentAmmo = getMaxAmmo();
  }

  //public abstract String toString();
  public void updateTime(int time) {
    shotsLeft = getRateOfFire();
  }
}
