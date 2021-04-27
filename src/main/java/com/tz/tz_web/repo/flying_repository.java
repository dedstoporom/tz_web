package com.tz.tz_web.repo;
import com.tz.tz_web.Models.flying;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface flying_repository extends CrudRepository<flying,Long>
{
@Query("SELECT p FROM flying p WHERE p.way_company LIKE %?1% " +
                                "or p.way_end LIKE %?1%" +
                                "or p.way_number LIKE %?1%" +
                                "or p.way_time LIKE %?1%" +
                                "or p.way_terminal LIKE %?1%" +
                                "or p.way_status LIKE %?1%")
public List<flying> search(String keyword);
}

