package jp.co.file.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.file.models.FileInfo;
import jp.co.file.utils.EntityManagerUtil;

/**
 * ファイルをダウンロードするクラス.
 */
@WebServlet("/download")
public class FileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ.
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
    }

    /**
     * ファイルをダウンロードするメソッド.
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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

        // ファイルデータを取得
        byte[] fileData = file.getData();

        // ファイル名を取得
        String fileName = new String(file.getName().getBytes("Windows-31J"), "ISO8859_1");

        // レスポンスオブジェクトのヘッダー情報を設定
        response.setContentType("application/octet-stream");
        // ヘッダーにファイル名を設定
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        // ファイルサイズをResponseのメッセージボディのサイズに設定
        response.setContentLength(fileData.length);

        // try-with-resources文を利用して、OutputStreamの変数を宣言
        try (
                // ResponseのOutputStreamを代入
                OutputStream os = response.getOutputStream();
                ){

            // OutputStreamをファイルデータに書き込む
            os.write(fileData);

            // OutputStreamを強制的に書き込み
            os.flush();
            os.close();

            // EntityManagerのインスタンスを閉じる
            em.close();

        } catch (IOException e) {
            throw e;
        }

    }

}