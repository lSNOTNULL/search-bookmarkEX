<%@ page import="org.example.searchbookmarkex.model.vo.KeywordSearch" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> 검색하자 </title>
</head>
<body>
    <h1> 검색 </h1>
    <form>
        <label>키워드 : <input name="keyword"/></label>
        <input type="submit" value="검색">
    </form>
    <% if (request.getAttribute("result") != null) { %>
    <section style="display: flex; flex-direction: column;align-items: center;justify-content: center;gap: 12px">
        <%
            for (KeywordSearch v : (List<KeywordSearch>) request.getAttribute("result")){
                %>
            <div>
                <h3><%= v.title() %></h3>
                <ul>
                    <li><%= v.link() %></li>
                    <li><%= v.description() %></li>
                    <li><%= v.date() %></li>
                </ul>
            </div>
        <%
            }
        %>
    </section>
<%} %>

</body>
</html>