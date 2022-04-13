package com.example.dethi.controller;

import com.example.dethi.entity.Product;
import com.example.dethi.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        ProductModel model = new ProductModel();
        List<Product> listObj = model.findAll();
        req.setAttribute("listObj",listObj);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}