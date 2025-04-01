package org.example.searchbookmarkex.util;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.example.searchbookmarkex.model.vo.KeywordSearch;
import org.example.searchbookmarkex.model.vo.NaverSearchParam;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class NaverSearchAPI implements DotenvMixin , ObjectMapperMixin {
    private static final Log log = LogFactory.getLog(NaverSearchAPI.class);
    private final MyLogger logger = new MyLogger(NaverSearchAPI.class.getName());
    private final HttpClient httpClient = HttpClient.newHttpClient();



    public List<KeywordSearch> callAPI(NaverSearchParam param) throws Exception {
        // https://developers.naver.com/main/
        String url = "https://openapi.naver.com/v1/search/blog.json";
        String query = URLEncoder.encode(param.query(), StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("%s?query=%s".formatted(url,query)))
                .header("X-Naver-Client-Id",dotenv.get("NAVER_CLIENT_ID"))
                .header("X-Naver-Client-Secret",dotenv.get("NAVER_CLIENT_SECRET"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        logger.info(responseBody);
        return List.of();
    }
}
