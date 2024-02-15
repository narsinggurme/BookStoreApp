package com.bs.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
