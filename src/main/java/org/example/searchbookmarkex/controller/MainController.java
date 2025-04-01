package org.example.searchbookmarkex.controller;

import org.example.searchbookmarkex.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // 멤버변수
    private final SearchService searchService;

    public MainController(SearchService searchService) {
        // 생성자 주입
        this.searchService = searchService;
    }

    @GetMapping
    public String index() throws Exception {
        searchService.searchByKeyword("잘 찍히는지 확인");
        return "index";
    }
}
