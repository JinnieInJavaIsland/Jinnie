package com.example.jinnie.repository;

import com.example.jinnie.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/*

JPA를 이용할 때 (JpaRepository 인터페이스를 상속하는) 인터페이스를 선언하는 것만으로
데이터베이스와 관련된 작업을 처리할 수 있다. CRUD와 페이징 처리를 할 수 있다.
JpaRepository 인터페이스를 상속할 때에는 엔티티 타입(Board)와 @Id 타입 (Long) 을 지정해주어야 한다.

 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
