package com.sbs.exam.sbb.answer;

import com.sbs.exam.sbb.qustion.Question;
import com.sbs.exam.sbb.qustion.QuestionService;
import com.sbs.exam.sbb.user.SiteUser;
import com.sbs.exam.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;
  private final UserService userService;

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/create/{id}")
  public String createAnswer(Principal principal, Model model, @PathVariable Long id, @Valid AnswerForm answerForm, BindingResult bindingResult) {

    Question question = questionService.getQuestion(id);

    if(bindingResult.hasErrors()) {
      model.addAttribute("question", question);
      return "question_detail";
    }

    SiteUser siteUser = userService.getUser(principal.getName());

    // 답변 등록 시작
    answerService.create(question, answerForm.getContent(), siteUser);
    // 답변 등록 끝

    return "redirect:/question/detail/%d".formatted(id);
  }
}
