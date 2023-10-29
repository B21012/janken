package oit.is.z1759.kaizi.janken.model;

import java.util.Random;

public class Janken {
  private String userHand;
  private String cpuHand;

  // コンストラクタ
  public Janken(String userHand) {
    this.userHand = userHand;
    this.cpuHand = getRandomHand();
  }

  // 新しく追加
  public void setUserHandForMatchInfo(MatchInfo matchInfo, Integer hand) {
    switch (hand) {
      case 1:
        matchInfo.setUser1Hand("Gu");
        break;
      case 2:
        matchInfo.setUser1Hand("Choki");
        break;
      case 3:
        matchInfo.setUser1Hand("Pa");
        break;
      default:
        // Handle invalid hand input
        throw new IllegalArgumentException("Invalid hand value: " + hand);
    }
  }

  // 勝負を行方を返す
  public String jankenResult() {
    return determineWinner(userHand, cpuHand);
  }

  // cpuをランダムな手を考える
  private String getRandomHand() {
    String[] hands = { "Gu", "Choki", "Pa" };
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
    return determineWinner(userHand, cpuHand);
  }

  // 勝負の行方
  private String determineWinner(String userHand, String cpuHand) {
    if (userHand.equals("Gu") && cpuHand.equals("Choki")) {
      return "You Win!";
    } else if (userHand.equals("Choki") && cpuHand.equals("Pa")) {
      return "You Win!";
    } else if (userHand.equals("Pa") && cpuHand.equals("Gu")) {
      return "You Win!";
    } else if (userHand.equals(cpuHand)) {
      return "It's a Draw!";
    } else {
      return "You Lose!";
    }
  }

}
