package service;

import dao.MessageDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Message;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveMessServlet extends HttpServlet {
    public SaveMessServlet(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response. getWriter().append("Served at: ").append(request. getContextPath());
        //得到页面输入的用户、标题、内容
        String name=request.getParameter("name");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        Date date=new Date( );
        SimpleDateFormat sdf=new SimpleDateFormat ( "yyyy-mm-dd hh :mm:ss");
        String time=sdf . format(date);
        Message m=new Message(name, title, content, time, 0);
        MessageDao messagedao=new MessageDao( ) ;
        int count=messagedao.addMessage(m);
        if(count==1)
        {
            response. sendRedirect( "messageBoard.jsp");
        }else
            response. sendRedirect("newMessage.jsp");
    }

}


