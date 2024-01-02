package service;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    public  DeleteUserServlet(){
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int level = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        int count = userDao.delete_user(level);
        if(count == 1){
            response.sendRedirect("admin/showUserList.jsp");
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doGet(request,response);
    }
}
