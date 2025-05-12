package com.question.QuestionService.services.impl;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repository.QuestionRepository;
import com.question.QuestionService.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
  private QuestionRepository questionRepository;

  public QuestionServiceImpl(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  @Override
  public Question create(Question question) {
    return questionRepository.save(question);
  }

  @Override
  public List<Question> get() {
    return questionRepository.findAll();
  }

  @Override
  public Question getOne(Long id) {
    return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found"));
  }

  @Override
  public List<Question> getQuestionByQuizId(Long quizId) {
    return questionRepository.findByQuizId(quizId);
  }
}
