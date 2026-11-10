package gameplay;

public interface Timer {
  public void addTimeObserver(TimerObserver observer);

  public void removeTimeObserver(TimerObserver observer);

  public void timeChanged();

}
