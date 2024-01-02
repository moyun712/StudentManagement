package service;


import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteProductServlet extends HttpServlet {

    public DeleteProductServlet(){
        super();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at : ").append(req.getContextPath());
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDao productDao = new ProductDao();
        int count = productDao.deleteProduct(id);
        if(count==1){
            resp.sendRedirect("admin/manageProduct.jsp");
        }
    }

}
