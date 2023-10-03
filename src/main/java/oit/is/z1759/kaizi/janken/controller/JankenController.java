package oit.is.z1759.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {
  @PostMapping("/janken")
  public String postRequest(@RequestParam("text") String str, ModelMap model) {
    // 画面から受け取った文字列をModelに登録
    model.addAttribute("sample", str);
    // janken.htmlに遷移
    return "janken";
  }
}
