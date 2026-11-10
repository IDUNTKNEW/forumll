package gameplay;

import java.util.ArrayList;

public class SimpleTimer extends Thread implements Timer {
  protected int round = 0;
  ArrayList<TimerObserver> observers = new ArrayList<>();
  protected int mySleep = 0;


  public SimpleTimer() {
  }

  public SimpleTimer(int sleep) {
    mySleep = sleep;
  }

  public void addTimeObserver(TimerObserver observer) {
    observers.add(observer);
  }

  public void removeTimeObserver(TimerObserver observer) {
    observers.remove(observer);
  }

  public int getNumObservers() {
    return observers.size();
  }

  public int getRound() {
    return round;
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      try {
        Thread.sleep(mySleep);
        timeChanged();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void timeChanged() {
    round += 1;
    observers.forEach(observer -> observer.updateTime(round));
  }
}
