package com.tz.tz_web.Models;

import com.tz.tz_web.repo.flying_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.tz.tz_web.repo.flying_repository;
import java.util.List;

@Service
public class flyingServiceImp implements flying_service
{
    @Autowired
    flying_repository repository;

    @Override
    public Iterable<flying> listAll(String keyword)
    {
        if(keyword == "")
        {
            return repository.findAll();

        }
        return repository.search(keyword);
    }
    @Override
    public void save(flying flying) {
    repository.save(flying);
    }

    @Override
    public boolean isExist(String fly_t) {
        return false;
    }


}
