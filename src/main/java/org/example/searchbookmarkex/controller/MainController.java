package org.example.searchbookmarkex.controller;

import org.example.searchbookmarkex.model.vo.KeywordSearch;
import org.example.searchbookmarkex.service.SearchService;
import org.example.searchbookmarkex.util.MyLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    final private MyLogger logger = new MyLogger(this.getClass().getSimpleName());
    // 멤버변수
    private final SearchService searchService;

    public MainController(SearchService searchService) {
        // 생성자 주입
        this.searchService = searchService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "keyword", required = false) String keyword)
            // 기본적으로 required = true가 내장되어있다. (keyword 파라미터 무조건 포함. 아닐 시 예외처리 오류)
            throws Exception {
        logger.info(keyword);
        if (keyword == null) {
            return "index";
        }
        List<KeywordSearch> result = searchService.searchByKeyword(keyword);
        model.addAttribute("result", result);
        return "index";
    }
}
