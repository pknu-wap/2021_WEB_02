package com.web02.domain.comments;


import com.web02.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")      //@Query가 가독성이 더 좋음
    List<Posts> findAllDesc();
}
