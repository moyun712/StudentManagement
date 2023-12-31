package service;

import dao.NewsDao;
import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;
import model.Product;

import java.io.IOException;

public class AddProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at : ").append(req.getContextPath());
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String type = req.getParameter("type");
        int price = Integer.parseInt(req.getParameter("price"));
        String content = req.getParameter("content");
        String picture = req.getParameter("picture");
        Product product = new Product(id,name,brand,type,price,content,picture);
        ProductDao productDao = new ProductDao();
        int count = productDao.updateProduct(product);
        if(count == 1){
            resp.sendRedirect("admin/manageProduct.jsp");
        }else {
            resp.sendRedirect("admin/addProduct.jsp");
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
