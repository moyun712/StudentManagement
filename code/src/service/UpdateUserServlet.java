package service;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {
    public  UpdateUserServlet(){
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int id =Integer.parseInt(request.getParameter("id"));
        User user  = new User(username,password,id);
        UserDao userDao = new UserDao();
        int count = userDao.alter_user(user);
        if(count == 1){
            response.sendRedirect("/admin/showUserList.jsp");
        }else {
            response.sendRedirect("/admin/addManager.jsp");
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doGet(request,response);
    }
}
