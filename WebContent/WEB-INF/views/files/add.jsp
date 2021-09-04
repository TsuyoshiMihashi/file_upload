<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ファイルアップロード画面</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>ファイルアップロード画面</h1>
            </div>
            <div id="content">
                <form method="POST" enctype="multipart/form-data"
                    action="${pageContext.request.contextPath}/upload">
                    <input name="uploadFile" type="file"/>
                    <br>
                    <br>
                    <input type="submit" value="送信"/>
                </form>
                <br>
                <a href="${pageContext.request.contextPath}/list">一覧に戻る</a>
            </div>
            <div id="footer"></div>
        </div>
    </body>
</html>
