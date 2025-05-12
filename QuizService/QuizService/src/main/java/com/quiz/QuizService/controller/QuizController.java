package com.quiz.QuizService.controller;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
  private QuizService quizService;

  public QuizController(QuizService quizService) {
    this.quizService = quizService;
  }

  //create
  @PostMapping
  public Quiz create(@RequestBody Quiz quiz) {
    return quizService.add(quiz);
  }

  //get All
  @GetMapping
  public List<Quiz> getAll() {
    return quizService.get();
  }

  @GetMapping("/{id}")
  public Quiz getOne(@PathVariable Long id) {
    return quizService.get(id);
  }
}
