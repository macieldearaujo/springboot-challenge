package com.springboot.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentRepository, Long> {
}
