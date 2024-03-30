package com.sbs.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

  @GetMapping("/question/list")
  // 이 자리에 @ResponseBody가 없으면 resources/templates/question_list.html을 뷰로 삼는다.
  public String list() {
    return "question_list";
  }

  @GetMapping("/question/list2")
  // 이 자리에 @ResponseBody가 없으면 resources/templates/question_list.html을 뷰로 삼는다.
  public String list2() {
    return "question_list2";
  }
}
