package oit.is.z1759.kaizi.janken.model;

public class Match {
  private int id;
  private int user1;
  private int user2;
  private String user1Hand;
  private String user2Hand;

  // Constructor

  public Match(int id, int user1, int user2, String user1Hand, String user2Hand) {
    this.id = id;
    this.user1 = user1;
    this.user2 = user2;
    this.user1Hand = user1Hand;
    this.user2Hand = user2Hand;
  }

  // Getters

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

  public String getUser2Hand() {
    return user2Hand;
  }

  // Setters

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

  public void setUser2Hand(String user2Hand) {
    this.user2Hand = user2Hand;
  }
}
