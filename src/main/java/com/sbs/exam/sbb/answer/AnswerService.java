package com.sbs.exam.sbb.answer;

import com.sbs.exam.sbb.qustion.Question;
import com.sbs.exam.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
  private final AnswerRepository answerRepository;

  public void create(Question question, String content, SiteUser author) {
    Answer answer = new Answer();
    answer.setContent(content);
    answer.setCreateDate(LocalDateTime.now());
    answer.setQuestion(question);
    answer.setAuthor(author);

    question.addAnswer(answer);

    answerRepository.save(answer);
  }
}
