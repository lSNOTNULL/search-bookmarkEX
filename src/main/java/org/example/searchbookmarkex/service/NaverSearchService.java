package org.example.searchbookmarkex.service;

import org.example.searchbookmarkex.model.vo.KeywordSearch;
import org.example.searchbookmarkex.model.vo.NaverSearchParam;
import org.example.searchbookmarkex.util.MyLogger;
import org.example.searchbookmarkex.util.NaverSearchAPI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 등록했는데... SearchService이자 NaverSearchService
// 등록된 타입은? <Naver>SearchService
public class NaverSearchService implements SearchService
{
    private final MyLogger logger = new MyLogger(this.getClass().getName());
    private final NaverSearchAPI naverSearchAPI;

    public NaverSearchService(NaverSearchAPI naverSearchAPI) {
        this.naverSearchAPI = naverSearchAPI;
    }

    @Override
    public List<KeywordSearch> searchByKeyword(String keyword) throws Exception {
        naverSearchAPI.callAPI(new NaverSearchParam(keyword));
        logger.info("searchByKeyword keyword: %s".formatted(keyword));
//        return List.of();
        return naverSearchAPI.callAPI(new NaverSearchParam(keyword));
    }
}