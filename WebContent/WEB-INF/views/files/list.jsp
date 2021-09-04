<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>アップロードファイル一覧</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>アップロードファイル一覧</h1>
            </div>
            <div id="content">
                <table border="1">
                    <tr>
                        <th>ファイル名</th>
                        <th>画像表示</th>
                        <th>ダウンロード</th>
                        <th>削除</th>
                    </tr>
                    <c:forEach var="file" items="${files}">
                        <tr>
                            <td>
                              <c:out value="${file.name}" />
                            </td>
                            <td align="center">
                                <c:if test="${file.is_image}">
                                    <a href="${pageContext.request.contextPath}/show?id=${file.id}">
                                        ○
                                    </a>
                                </c:if>
                            </td>
                            <td align="center">
                                <a href="${pageContext.request.contextPath}/download?id=${file.id}">
                                △
                                </a>
                            </td>
                            <td align="center">
                                <a href="${pageContext.request.contextPath}/destroy?id=${file.id}">×</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <a href="${pageContext.request.contextPath}/add">ファイルアップロード画面へ</a>
            </div>
            <div id="footer"></div>
        </div>
    </body>
</html>