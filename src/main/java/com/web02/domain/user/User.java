package com.web02.domain.user;


import com.web02.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)//JPA로 데이터베이스 저장할 때 Enum 값 String 으로 저장(기본 int)
    @Column(nullable=false)
    private Role role;

    @Builder
    public User(String name, String email,String picture, Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=Role.USER;
    }

    public User update(String name,String picture){
        this.name=name;
        this.picture=picture;
        this.role=role;
        return this;
    }

    public  String getRoleKey(){
        return this.role.getKey();
    }

}
