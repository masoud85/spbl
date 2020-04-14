package com.osveh.repository;

import com.osveh.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LinkRepository extends JpaRepository<Link, Long> {

    @Query("select l from Link l where l.title = ?1")
    Link findByTitle(String title);

}
