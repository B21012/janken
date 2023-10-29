package oit.is.z1759.kaizi.janken.controller;

import java.util.ArrayList;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1759.kaizi.janken.model.Janken;
import oit.is.z1759.kaizi.janken.model.User;
import oit.is.z1759.kaizi.janken.model.UserMapper;
import oit.is.z1759.kaizi.janken.model.Match;
import oit.is.z1759.kaizi.janken.model.MatchInfo;
import oit.is.z1759.kaizi.janken.model.MatchInfoMapper;
import oit.is.z1759.kaizi.janken.model.MatchMapper;

@Controller
public class JankenController {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;

  // ログインし，相手を選び(janken.html)
  @GetMapping("/janken")
  public String userEntry(ModelMap model) {
    ArrayList<User> users = userMapper.selectAllUsers();
    ArrayList<Match> matches = matchMapper.selectAllMatches();
    model.addAttribute("matches", matches);
    model.addAttribute("users", users);
    return "janken";
  }

  // 手を選び(match.html)
  @GetMapping("/match")
  public String selectHand(@RequestParam Integer id, ModelMap model) {
    User match = userMapper.selectAllById(id);
    model.addAttribute("match", match);
    return "match";
  }

  @Transactional
  @GetMapping("/fight")
  public String sample43(@RequestParam Integer hand, @RequestParam Integer id, ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    User user = userMapper.selectByUserName(loginUser);
    MatchInfo matchInfo = new MatchInfo();
    matchInfo.setUser1(user.getId());
    matchInfo.setUser2(id);
    matchInfo.setIsActive(true);

    Janken janken = new Janken(loginUser);
    janken.setUserHandForMatchInfo(matchInfo, hand);

    matchInfoMapper.insertMatchInfo(matchInfo);

    return "wait";
  }

}
