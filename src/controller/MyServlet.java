package controller;

import dao.AttributeDAO;
import dao.CategoryDAO;
import dao.GoodsDAO;
import dao.ValueDAO;
import dao.impl.*;
import entity.AttributeEntity;
import entity.CategoryEntity;
import entity.GoodsEntity;
import entity.ValueEntity;
import exceptions.EntityNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer writer = response.getWriter();
        CategoryEntity instance1 = new CategoryEntity("Books");
        CategoryEntity instance2 = new CategoryEntity("Phones");
        GoodsEntity goodsInstance1 = new GoodsEntity("Math",1);
        GoodsEntity goodsInstance2 = new GoodsEntity("Programming",1);
        GoodsEntity goodsInstance3 = new GoodsEntity("Samsung",2);
        AttributeEntity attributeInstance1 = new AttributeEntity("Number of pages",1);
        AttributeEntity attributeInstance2 = new AttributeEntity("Year",1);
        AttributeEntity attributeInstance3 = new AttributeEntity("Price",2);
        ValueEntity valueInstance1 = new ValueEntity(1,"500","Number of pages");
        ValueEntity valueInstance2 = new ValueEntity(1,"2016","Year");
        ValueEntity valueInstance3 = new ValueEntity(2,"27000","Price");

        CategoryDAO category = FactoryEntity.getInstance().getCategoryDAO();
        GoodsDAO goods = FactoryEntity.getInstance().getGoodsDAO();
        AttributeDAO attribute = FactoryEntity.getInstance().getAttributeDAO();
        ValueDAO value = FactoryEntity.getInstance().getValueDAO();

        category.addCategory(instance1);
        category.addCategory(instance2);

        goods.addGoods(goodsInstance1);
        goods.addGoods(goodsInstance2);
        goods.addGoods(goodsInstance3);

        attribute.addAttribute(attributeInstance1);
        attribute.addAttribute(attributeInstance2);
        attribute.addAttribute(attributeInstance3);

        value.addValue(valueInstance1);
        value.addValue(valueInstance2);
        value.addValue(valueInstance3);


        try {
            category.editCategory(instance2, "Toys");
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        try {
            goods.editGoods(goodsInstance3,"Terminator");
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }


        writer.write("<html><body><h1>" + category.getAll() + "</h1></body></html>");
        writer.write("<html><body><h1>" + goods.getAll() + "</h1></body></html>");
        writer.write("<html><body><h1>" + attribute.getAll() + "</h1></body></html>");
        writer.write("<html><body><h1>" + value.getAll() + "</h1></body></html>");

    }
}
