package oit.is.z1759.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1759.kaizi.janken.model.Janken;

@Controller
public class JankenController {
  private int totalGame = 0;
  private int countWin = 0;
  private int countDraw = 0;
  private int countLose = 0;

  @GetMapping("/jankengame")
  public String playGame(@RequestParam("hand") String userHand, ModelMap model) {
    // ゲーム回数を表示
    totalGame++;

    // CPUの手
    String result;

    Janken jankenResult = new Janken();

    // 対戦結果のロジックを追加
    result = determineWinner(userHand, jankenResult.getCpuHand());

    if (result.equals("You Win!")) {
      countWin++;
    } else if (result.equals("It's a Draw!")) {
      countDraw++;
    } else if (result.equals("You Lose!")) {
      countLose++;
    }

    // 結果をmodelに登録
    model.addAttribute("userHand", userHand);
    model.addAttribute("cpuHand", jankenResult.getCpuHand());
    model.addAttribute("result", result);
    model.addAttribute("totalGame", totalGame);
    model.addAttribute("countWin", countWin);
    model.addAttribute("countDraw", countDraw);
    model.addAttribute("countLose", countLose);
    // janken.htmlに遷移
    return "janken";
  }

  @GetMapping("/janken")
  public String showIndex() {
    totalGame = 0;
    countWin = 0;
    countDraw = 0;
    countLose = 0;
    return "janken.html";
  }

  @PostMapping("/janken")
  public String postRequest(@RequestParam("text") String str, ModelMap model) {
    totalGame = 0;
    countWin = 0;
    countDraw = 0;
    countLose = 0;
    // 画面から受け取った文字列をModelに登録
    model.addAttribute("sample", str);
    // janken.htmlに遷移
    return "janken";
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

}
