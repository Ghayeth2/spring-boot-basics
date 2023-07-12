package com.patika_course.tutorials.dao;

import com.patika_course.tutorials.dtos.PlayerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDao extends JpaRepository<PlayerDto, Integer> {
}
