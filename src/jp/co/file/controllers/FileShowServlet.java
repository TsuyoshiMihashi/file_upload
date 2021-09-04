package jp.co.file.controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.file.models.FileInfo;
import jp.co.file.utils.EntityManagerUtil;

/**
 * 添付ファイルの詳細を表示するクラス.
 */
@WebServlet("/show")
public class FileShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ.
     * @see HttpServlet#HttpServlet()
     */
    public FileShowServlet() {
        super();
    }

    /**
     * 添付ファイルの詳細を表示をするメソッド.
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Request、Responseの文字コードを「UTF-8」に設定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // リクエストパラメータからファイルIDを取得
        String id = request.getParameter("id");

        // EntityManagerのインスタンスを生成
        EntityManager em = EntityManagerUtil.createEntityManager();

        // ファイルIDをキーにファイル情報を取得
        FileInfo file = em.find(FileInfo.class, Integer.parseInt(id));

        // リクエストの属性にファイル情報を設定
        request.setAttribute("file", file);
        // EntityManagerのインスタンスを閉じる
        em.close();


        // jspに遷移
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/files/show.jsp");
        rd.forward(request, response);
    }

}