package com.patika_course.tutorials.business.concretes;

import com.patika_course.tutorials.business.abstracts.PlayerService;
import com.patika_course.tutorials.dao.PlayerDao;
import com.patika_course.tutorials.dtos.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerManager implements PlayerService {
    @Autowired
    private PlayerDao playerDao;
    public void save(PlayerDto playerDto){
       playerDao.save(playerDto);
    }
}
