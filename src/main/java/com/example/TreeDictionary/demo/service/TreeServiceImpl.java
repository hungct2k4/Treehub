package com.example.TreeDictionary.demo.service;

import com.example.TreeDictionary.demo.model.NewsTree;
import com.example.TreeDictionary.demo.model.Tree;
import com.example.TreeDictionary.demo.repository.NewsTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.TreeDictionary.demo.repository.TreeRepository;

@Service
public class TreeServiceImpl implements ITreeService {

    @Autowired
    private NewsTreeRepository newsTreeRepository;
    
    @Autowired
    private TreeRepository treeRepository;

    @Override
    public NewsTree addNewsTree(NewsTree tree) {
        return newsTreeRepository.save(tree);
    }

    @Override
    public List<NewsTree> getAllNewsTree() {
        return newsTreeRepository.findAll();
    }

    @Override
    public List<NewsTree> saveListNewsTree(List<NewsTree> list) {
        return newsTreeRepository.saveAllAndFlush(list);
    }

    

    @Override
    public Tree addTree(Tree tree) {
        if (tree != null) {
            return treeRepository.save(tree);
        }
        return null;
    }

    @Override
    public Tree updateTree(long id, Tree tree) {
        if (tree != null) {
            Tree tree1 = treeRepository.getById(id);
            if (tree1 != null) {
                tree1.setName(tree.getName());
                tree1.setFunctions(tree.getFunctions());
                tree1.setUse(tree.getUse());
                tree1.setSick(tree.getSick());
                tree1.setPath(tree.getPath());
                return treeRepository.save(tree1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteTree(long id) {
        if (id >= 1) {
            Tree tree = treeRepository.getById(id);
            if (tree != null) {
                treeRepository.delete(tree);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Tree> getAllTree() {
        return treeRepository.findAll();
    }

    @Override
    public Optional<Tree> getOneTree(Long id) {
        return treeRepository.findById(id);
    }

    @Override
    public List<Tree> search(String keyword) {
        return treeRepository.searchTree(keyword);
    }

    @Override
    public List<Tree> saveListTree(List<Tree> list) {
        return treeRepository.saveAllAndFlush(list);
    }

    @Override
    public Tree getATree(Long id) {
        return treeRepository.getReferenceById(id);
    }


}
