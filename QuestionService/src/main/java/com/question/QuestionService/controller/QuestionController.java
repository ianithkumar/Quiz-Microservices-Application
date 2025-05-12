package com.question.QuestionService.controller;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

  private QuestionService  questionService;

  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @PostMapping
  public Question create(@RequestBody Question question) {
    return questionService.create(question);
  }

  @GetMapping
  public List<Question> getAll() {
    return questionService.get();
  }

  @GetMapping("/{questionId}")
  public Question getOne(@PathVariable Long questionId) {
    return questionService.getOne(questionId);
  }

  //get all questions of specific quiz
  @GetMapping("/quiz/{quizId}")
  public List<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
    return questionService.getQuestionByQuizId(quizId);
  }
}
