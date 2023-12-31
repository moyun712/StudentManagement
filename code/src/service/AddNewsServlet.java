package service;

import dao.NewsDao;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;
import model.User;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNewsServlet extends HttpServlet {
    public AddNewsServlet(){
        super();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at : ").append(req.getContextPath());
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Date date=new Date( );
        SimpleDateFormat sdf=new SimpleDateFormat ( "yyyy-MM-dd hh :mm:ss");
        String time=sdf.format(date);
        News news = new News(title,content,time);
        NewsDao newsDao = new NewsDao();
        if(newsDao.addNews(news)==1){
            resp.sendRedirect("admin/manageNews.jsp");
        }else {
            resp.sendRedirect("admin/addNews.jsp");
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
