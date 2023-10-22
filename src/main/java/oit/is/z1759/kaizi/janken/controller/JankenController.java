package oit.is.z1759.kaizi.janken.controller;

import java.util.ArrayList;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1759.kaizi.janken.model.Janken;
import oit.is.z1759.kaizi.janken.model.User;
import oit.is.z1759.kaizi.janken.model.UserMapper;
import oit.is.z1759.kaizi.janken.model.Match;
import oit.is.z1759.kaizi.janken.model.MatchMapper;

@Controller
public class JankenController {
  // それぞれの回数
  private int totalGame = 0;
  private int countWin = 0;
  private int countDraw = 0;
  private int countLose = 0;

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

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
  public String jankeMatch(Principal prin, ModelMap model) {

    String loginUser = prin.getName();
    model.addAttribute("loginUser", loginUser);

    ArrayList<User> users = userMapper.selectAllUsers();
    ArrayList<Match> matches = matchMapper.selectAllMatches();
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);
    totalGame = 0;
    countWin = 0;
    countDraw = 0;
    countLose = 0;
    return "janken.html";
  }

  @GetMapping("/match")
  public String gameMatch(@RequestParam Integer id, ModelMap model) {
    User match = userMapper.selectAllById(id);
    model.addAttribute("match", match);
    return "match";
  }

}
