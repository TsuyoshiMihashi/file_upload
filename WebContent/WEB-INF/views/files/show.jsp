<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>画像表示画面</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h1>画像表示画面</h1>
        </div>
        <div id="content">
            <table border="1">
                <tr>
                    <th align="center"><c:out value="${file.name}" /></th>
                </tr>
                <tr>
                    <td align="center">
                        <img src="${pageContext.request.contextPath}/show_image?id=${file.id}">
                    </td>
                </tr>
            </table>
            <br>
            <a href="${pageContext.request.contextPath}/list">一覧に戻る</a>
        </div>
        <div id="footer"></div>
    </div>
</body>
</html>