package com.example.TreeDictionary.demo.controller;

import com.example.TreeDictionary.demo.model.NewsTree;
import com.example.TreeDictionary.demo.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.example.TreeDictionary.demo.service.ITreeService;

@CrossOrigin(origins = "http://localhost:3000/")

@RestController
@RequestMapping("/search/tree")
public class TreeController {

    @Autowired
    private ITreeService treeService;

    // Test
    @GetMapping("/")
    public String test() {
        return "timoday";
    }

    // API add tree
    @PostMapping("/add")
    public Tree addTree(@RequestBody Tree tree) {
        return treeService.addTree(tree);
    }

    @PostMapping("/addList")
    public List<Tree> addLístTree(@RequestBody List<Tree> list) {
        return treeService.saveListTree(list);
    }

    @PostMapping("/addListNew")
    public List<NewsTree> addListNTrees(@RequestBody List<NewsTree> list) {
        return treeService.saveListNewsTree(list);
    }

    // API update employee

    @PutMapping("/{id}")
    public Tree updateTree(@PathVariable("id") long id, @RequestBody Tree tree) {
        return treeService.updateTree(id, tree);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTree(@PathVariable("id") long id) {
        return treeService.deleteTree(id);
    }

    @GetMapping("/list")
    public List<Tree> getAllTree() {
        return treeService.getAllTree();
    }

    @GetMapping("/listNews")
    public List<NewsTree> getAllNewsTree() {
        return treeService.getAllNewsTree();
    }

    @GetMapping("/{id}")
    public Optional<Tree> getTree(@PathVariable("id") long id) {
        return treeService.getOneTree(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Tree>> searchStudent(@RequestParam("query") String query) {
        return ResponseEntity.ok(treeService.search(query));
    }

}
