package jp.co.file.controllers;

import java.io.IOException;
import java.util.List;

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
 * アップロードファイル一覧を表示するクラス.
 */
@WebServlet("/list")
public class FileListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileListServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Request、Responseの文字コードを「UTF-8」に設定
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // EntityManagerのインスタンスを生成
        EntityManager em = EntityManagerUtil.createEntityManager();

        // ファイル情報を全件取得
        List<FileInfo> files = em.createNamedQuery("getAllFiles", FileInfo.class).getResultList();

        // リクエストの属性にファイル情報を設定
        request.setAttribute("files", files);

        // EntityManagerのインスタンスを閉じる
        em.close();

        // jspに遷移
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/files/list.jsp");
        rd.forward(request, response);
    }
}
