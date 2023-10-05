package oit.is.z1759.kaizi.janken.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1759.kaizi.janken.model.Janken;

@Controller

public class JankenController {

  @GetMapping("/janken")
  public String showIndex() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String postRequest(@RequestParam("text") String str, ModelMap model) {
    // 画面から受け取った文字列をModelに登録
    model.addAttribute("sample", str);
    // janken.htmlに遷移
    return "janken";
  }

  @GetMapping("/jankengame")
  public String playGame(@RequestParam("hand") String userHand, ModelMap model) {
    // ここでCPUの手をランダムに決定
    String cpuHand = getRandomHand();

    // 対戦結果のロジックを追加

    // 結果をModelに登録
    model.addAttribute("userHand", userHand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("result", "結果"); // ここも対戦結果に変更する

    // janken.htmlに遷移
    return "janken";
  }

  private String getRandomHand() {

    String[] hands = { "gu", "choki", "pa" };
    return hands[new Random().nextInt(hands.length)];
  }

  private String determineWinner(String userHand, String cpuHand) {
    if (userHand.equals("gu") && cpuHand.equals("choki")) {
      return "You Win!";
    } else if (userHand.equals("choki") && cpuHand.equals("pa")) {
      return "You Win!";
    } else if (userHand.equals("pa") && cpuHand.equals("gu")) {
      return "You Win!";
    } else if (userHand.equals(cpuHand)) {
      return "It's a Draw!";
    } else {
      return "You Lose!";
    }
  }

  private String play(String userHand, Janken janken, ModelMap model) {
    String cpuHand = getRandomHand();
    String result = determineWinner(userHand, cpuHand);

    janken.setUserHand(userHand);
    janken.setCpuHand(cpuHand);
    janken.setResult(result);

    return "janken";
  }
}
