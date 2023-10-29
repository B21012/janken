package oit.is.z1759.kaizi.janken.model;

public class MatchInfo {
  private int id;
  private int user1;
  private int user2;
  private String user1Hand;
  private boolean isActive;

  // Getter methods
  public int getId() {
    return id;
  }

  public int getUser1() {
    return user1;
  }

  public int getUser2() {
    return user2;
  }

  public String getUser1Hand() {
    return user1Hand;
  }

  public boolean getIsActive() {
    return isActive;
  }

  // Setter methods
  public void setId(int id) {
    this.id = id;
  }

  public void setUser1(int user1) {
    this.user1 = user1;
  }

  public void setUser2(int user2) {
    this.user2 = user2;
  }

  public void setUser1Hand(String user1Hand) {
    this.user1Hand = user1Hand;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }
}
