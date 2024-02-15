package com.bs.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.entity.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
