package recovery;

public class RecoveryLinear implements RecoveryBehavior {
  int recoveryPoints;

  /**
   * Recovery behavior for linear
   *
   * @param recoveryAmount amount to be recovered
   */
  public RecoveryLinear(int recoveryAmount) {
    recoveryPoints = Math.max(0, recoveryAmount);
  }

  /**
   *
   * @param currentLife
   * @param maxLife
   * @return
   */
  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    if (currentLife == 0) {
      return currentLife;
    }
    return Math.min((currentLife + recoveryPoints), maxLife);
  }
}
