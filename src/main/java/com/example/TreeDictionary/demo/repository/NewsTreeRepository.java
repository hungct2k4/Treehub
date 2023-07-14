package com.example.TreeDictionary.demo.repository;

import com.example.TreeDictionary.demo.model.NewsTree;
import com.example.TreeDictionary.demo.model.Tree;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsTreeRepository extends JpaRepository<NewsTree, Long> {

}
