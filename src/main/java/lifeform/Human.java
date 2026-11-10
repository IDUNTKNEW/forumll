package lifeform;

public class Human extends LifeForm {
  protected int myArmor;

  /**
   * Human lifeform
   *
   * @param name       human name
   * @param lifepoints health number
   * @param armor      armor number
   */
  public Human(String name, int lifepoints, int armor) {
    super(name, lifepoints);
    myName = name;
    currentLifePoints = Math.max(0, lifepoints);
    myArmor = Math.max(0, armor);
    setAttackStrength(5);
  }

  /**
   * returns armor
   *
   * @return armor
   */
  public int getArmorPoints() {
    return myArmor;
  }

  /**
   * sets armor
   *
   * @param armor armor for attack reduction
   */
  public void setArmorPoints(int armor) {
    myArmor = Math.max(0, armor);
  }

  /**
   * takes hit for human
   *
   * @param damage damage to be taken
   */
  @Override
  public void takeHit(int damage) {
    setCurrentLifePoints(Math.max(0, (currentLifePoints - Math.max(0, damage - myArmor))));
  }
}