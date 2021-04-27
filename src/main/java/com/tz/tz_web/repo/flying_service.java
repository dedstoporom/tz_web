package com.tz.tz_web.repo;
import com.tz.tz_web.Models.flying;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface flying_service
{
    public void save(flying pars);
    public boolean isExist(String fly_t);
    public Iterable<flying> listAll(String keyword);

}