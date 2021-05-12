// Entity 클래스, 기본 Entity Repository는 함께 위치해야함, 도메인 페이지에서 관리
package com.web02.test.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 인터페이스 생성후 JpaRepository<Entity 클래스, PK타입> 으로 CRUD 메소드 자동생성
public interface PostsRepository extends JpaRepository<Posts,Long>{

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")      //@Query가 가독성이 더 좋음
    List<Posts> findAllDesc();

}
