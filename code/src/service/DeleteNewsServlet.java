package service;

import dao.NewsDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteNewsServlet extends HttpServlet {
    public DeleteNewsServlet(){
        super();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at : ").append(req.getContextPath());
        int id = Integer.parseInt(req.getParameter("id"));
        NewsDao newsDao = new NewsDao();
        int count = newsDao.deleteNews(id);
        if(count==1){
            resp.sendRedirect("admin/manageNews.jsp");
        }
    }

}
