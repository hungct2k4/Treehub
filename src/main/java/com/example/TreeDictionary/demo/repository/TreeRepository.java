package com.example.TreeDictionary.demo.repository;

import com.example.TreeDictionary.demo.model.Tree;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {

    @Query(value = "SELECT * FROM Tree\n"
            + "WHERE name LIKE %:keyword% OR sick LIKE %:keyword% OR functions LIKE %:keyword% ", nativeQuery = true)
    public List<Tree> searchTree(@Param("keyword")String keyword);
}
