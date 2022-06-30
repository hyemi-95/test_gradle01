package com.jojoIdu.book.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}


//Posts클래스 생성 후 Posts클래스로 DataBase를 접근하게 해줄 JpaRepository 인터페이스 생성
//단순 인터페이스를 생성 후 JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD메소드가 자동으로 생성됨
//@Repository를 추가할 필요도 없음

//***주의***
//Entity크래스와 기본 Entity Repository는 함께 위치해야함
//둘은 아주 밀접한 관계이고, Entity클래스는 기본 Repository없이는 제대로 역할을 할 수가 없기때문
//도메인별로 프로젝트를 분리해야 한 다면 Entity클래스와 기본 Repository는 함께 움직여야하므로 도메인패키지에서 함께 관리