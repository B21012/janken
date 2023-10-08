package oit.is.z1759.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1759.kaizi.janken.model.Janken;

@Controller
public class JankenController {
  // それぞれの回数
  private int totalGame = 0;
  private int countWin = 0;
  private int countDraw = 0;
  private int countLose = 0;

  // handを受け取って、handというリクエストパラメータを受け取り、userHandに格納
  @GetMapping("/jankengame")
  public String playGame(@RequestParam("hand") String userHand, ModelMap model) {
    // ゲーム回数をカウント
    totalGame++;
    // Jankenクラスからインスタンスを作成
    Janken jankenResult = new Janken(userHand);
    // 勝負の結果
    String result = jankenResult.getResult();

    if (result.equals("You Win!")) {
      countWin++;
    } else if (result.equals("It's a Draw!")) {
      countDraw++;
    } else if (result.equals("You Lose!")) {
      countLose++;
    }

    // 結果をModelMapに登録し、Viewに渡す
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

  /* /jankenの時表示 入力せず同じ画面を返すのでGetがいい */
  @GetMapping("/janken")
  public String showIndex() {
    totalGame = 0;
    countWin = 0;
    countDraw = 0;
    countLose = 0;
    return "janken";
  }

  // 名前をtextという名前のパラメータを受け取りstrに格納
  @PostMapping("/janken")
  public String postRequest(@RequestParam("text") String str, ModelMap model) {
    // 新たに名前を入力するとカウント初期化
    totalGame = 0;
    countWin = 0;
    countDraw = 0;
    countLose = 0;
    // 画面から受け取った文字列をViewに渡す
    model.addAttribute("sample", str);
    // janken.htmlに遷移
    return "janken";
  }

}
