package com.sbs.exam.sbb;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer, Integer>, RepositoryUtil {
  @Transactional
  @Modifying
  @Query(value = "TRUNCATE answer", nativeQuery = true)
  void truncate();
}
