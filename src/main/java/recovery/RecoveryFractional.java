package recovery;

public class RecoveryFractional implements RecoveryBehavior {
  double recoveryPortion;

  /**
   * Recovery behavior for fractional
   *
   * @param recoveryFraction percent amount for recovery
   */
  public RecoveryFractional(double recoveryFraction) {
    recoveryPortion = Math.max(0, recoveryFraction);
  }

  @Override
  public int calculateRecovery(int currentLife, int maxLife) {
    int reduced = Math.min((currentLife + (int)
            (Math.ceil(currentLife * recoveryPortion))), maxLife);
    return Math.max(0, reduced);
  }
}
