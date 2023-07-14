package com.example.TreeDictionary.demo.service;

import com.example.TreeDictionary.demo.model.NewsTree;
import com.example.TreeDictionary.demo.model.Tree;

import java.util.List;
import java.util.Optional;

public interface ITreeService {

    public Tree addTree(Tree tree);

    public Tree updateTree(long id, Tree tree);

    public boolean deleteTree(long id);

    public List<Tree> getAllTree();

    public Tree getATree(Long id);

    Optional<Tree> getOneTree(Long id);

    public List<Tree> saveListTree(List<Tree> list);

    public List<Tree> search(String keyword);

    public NewsTree addNewsTree(NewsTree tree);

    public List<NewsTree> getAllNewsTree();

    public List<NewsTree> saveListNewsTree(List<NewsTree> list);



}
