package com.jojoIdu.book.springboot.domain.posts;


import com.jojoIdu.book.springboot.domain.BaseTImeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor//기본생성자 자동추가, public Posts(){} 와 같은 효과
@Entity //테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
public class Posts extends BaseTImeEntity {//실제 DB의 테이블과 매칭될 클래스, 보통 Entity클래스라고 함

    @Id//해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK 생성규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false)//테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨,
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)//기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    private  String content;

    private String author;

    @Builder//해당클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title =title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){ //
        this.title = title;
        this.content = content;
    }

}
