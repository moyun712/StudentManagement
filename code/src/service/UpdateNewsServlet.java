package service;

import dao.NewsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateNewsServlet extends HttpServlet {
    public UpdateNewsServlet(){
        super();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        News news = new News(id,title,content);
        NewsDao newsDao = new NewsDao();
        int count = newsDao.updateNews(news);
        if(count==1){
            resp.sendRedirect("admin/manageNews.jsp");
        }else {
            resp.sendRedirect("admin/updateNews.jsp");
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
