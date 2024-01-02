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

public class UpdateProductServlet extends HttpServlet {
    public UpdateProductServlet(){
        super();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String type = req.getParameter("type");
        int price = Integer.parseInt(req.getParameter("price"));
        String picture = req.getParameter("picture");
        String content = req.getParameter("content");
        Product product = new Product(id,name,brand,type,price,content,picture);
        ProductDao productDao = new ProductDao();
        int count = productDao.updateProduct(product);
        if(count==1){
            resp.sendRedirect("admin/manageProduct.jsp");
        }else {
            resp.sendRedirect("admin/updateProduct.jsp");
        }

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
