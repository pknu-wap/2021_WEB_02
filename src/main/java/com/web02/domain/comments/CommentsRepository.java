package com.web02.domain.comments;

import com.web02.domain.files.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    @Query("SELECT c from Comments c where c.post.id=:postNo and c.id>0 order by c.id ASC ")
    public List<Comments> getCommentsOfPost(@Param("postNo") Long postNo);
}
