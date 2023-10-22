package oit.is.z1759.kaizi.janken.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1759.kaizi.janken.model.Janken;
import oit.is.z1759.kaizi.janken.model.User;
import oit.is.z1759.kaizi.janken.model.UserMapper;

@Controller
public class JankenController {
  // それぞれの回数
  private int totalGame = 0;
  private int countWin = 0;
  private int countDraw = 0;
  private int countLose = 0;

  @Autowired
  UserMapper userMapper;

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

  @GetMapping("/janken")
  public String sample42(ModelMap model) {
    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users", users);
    return "janken.html";
  }

}
