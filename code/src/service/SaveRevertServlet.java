package service;

import dao.MessageDao;
import dao.ReplyDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Message;
import model.Reply;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveRevertServlet extends HttpServlet {
    public SaveRevertServlet(){
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response. getWriter().append("Served at: ").append(request. getContextPath());
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //得到页面输入的用户、标题、内容
        int mid = Integer.parseInt(request.getParameter("messageID"));
        String name=request.getParameter("name");
        String content=request.getParameter("content");
        Date date=new Date( );
        SimpleDateFormat sdf=new SimpleDateFormat ( "yyyy-MM-dd hh :mm:ss");
        String time=sdf.format(date);
        Reply reply=new Reply(content,name,time,mid);
        ReplyDao replyDao=new ReplyDao( ) ;
        int count=replyDao.addReply(reply);
        if(count==1) {
            MessageDao messageDao = new MessageDao();
            messageDao.updateCount(mid);
            response.sendRedirect("revertMessage.jsp?messageID=" + mid);
        }
    }

}
