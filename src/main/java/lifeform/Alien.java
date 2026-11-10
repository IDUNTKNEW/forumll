package lifeform;

import exceptions.RecoveryRateException;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;

public class Alien extends LifeForm implements TimerObserver {
  private String myName;
  protected int maxLifePoints;
  protected int recovery = 0;
  protected RecoveryBehavior healBehavior = new RecoveryNone();
  protected int attack;
  public int myTime = 0;
  protected int maxSpeed = 2;

  /**
   * Constructor for alien with only name and hit points.
   * @param name
   * @param maxHitPoints
   */
  public Alien(String name, int maxHitPoints) {
    super(name, maxHitPoints);
    myName = name;
    maxLifePoints = maxHitPoints;
    setAttackStrength(10);
  }

  /**
   * Constructor for alien with name, hit points, and recovery behavior.
   * @param name
   * @param maxHitPoints
   * @param behavior
   */
  public Alien(String name, int maxHitPoints, RecoveryBehavior behavior) {
    super(name, maxHitPoints);
    myName = name;
    healBehavior = behavior;
    maxLifePoints = maxHitPoints;
    setAttackStrength(10);
  }

  /**
   * Constructor for alien with name, hit points, recovery behavior, and recovery rate.
   * @param name
   * @param maxHitPoints
   * @param behavior
   * @param recoveryRate
   */
  public Alien(String name, int maxHitPoints, RecoveryBehavior behavior, int recoveryRate) {
    super(name, maxHitPoints);
    myName = name;
    maxLifePoints = maxHitPoints;
    healBehavior = behavior;
    recovery = recoveryRate;
    if (recoveryRate < 0) {
      throw new RecoveryRateException("Invalid recovery rate");
    }
    setAttackStrength(10);
  }

  /**
   * Gets the max life points of an alien
   *
   * @return max life points
   */
  public int getMaxLifePoints() {
    return maxLifePoints;
  }

  /**
   * Gives the rate of recovery
   *
   * @return the rate of recovery
   */
  public int getRecoveryRate() {
    return recovery;
  }

  /**
   * Recovers health based on recovery behavior
   */
  protected void recover() {
    currentLifePoints = healBehavior.calculateRecovery(currentLifePoints, maxLifePoints);
  }

  /**
   * updates time for any observers
   *
   * @param time time in rounds passed
   */
  public void updateTime(int time) {
    myTime = time;
    if (recovery != 0 && time % recovery == 0) {
      recover();
    }
  }
}
