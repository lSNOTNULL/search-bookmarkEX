package org.example.searchbookmarkex.service;

import org.example.searchbookmarkex.model.vo.KeywordSearch;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface SearchService {
    List<KeywordSearch> searchByKeyword(String keyword) throws Exception;
}
