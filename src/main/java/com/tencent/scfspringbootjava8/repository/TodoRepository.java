package com.tencent.scfspringbootjava8.repository;

import com.tencent.scfspringbootjava8.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, String> {
}
