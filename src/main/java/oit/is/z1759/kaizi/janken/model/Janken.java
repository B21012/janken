package oit.is.z1759.kaizi.janken.model;

import java.util.Random;

public class Janken {
  private String userHand;
  private String cpuHand;
  private String result;

  // コンストラクタ
  public Janken() {
    this.cpuHand = getRandomHand();
  }

  private String getRandomHand() {
    String[] hands = { "gu", "choki", "pa" };
    Random random = new Random();
    int index = random.nextInt(hands.length);
    return hands[index];
  }

  // getter&setter
  public String getUserHand() {
    return userHand;
  }

  public void setUserHand(String userHand) {
    this.userHand = userHand;
  }

  public String getCpuHand() {
    return cpuHand;
  }

  public void setCpuHand(String cpuHand) {
    this.cpuHand = cpuHand;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

}
