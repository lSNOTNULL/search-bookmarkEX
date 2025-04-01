`.env`

# 작동 순서
0. index 페이지에서 input 에 keyword 입력
1. controller 의 searchService.searchByKeyword(keyword);
2. 인터페이스 SearchService를 구현한 NaverSearchService 에서 `keyword`를 사용하여 callAPI 메서드 호출
3. NaverSearchAPI 안의 callAPI 가 호출되어 네이버 api 공식 문서 양식대로 api req,resp
4. 해당 resp를 역직렬화(readValue) + map을 활용한 List의 형태로 값 return
5. 다시 1번으로
6. 해당 return값을 배열의 형태로 model의 속성 추가 (addAttribute) "result" 에 담아서 index로
7. JSP에서 스크립틀릿을 활용해 배열의 형태 (result)를 향상된 for문을 이용하여 v 변수명으로 순회
8. 필요한 값을 각 li에 출력