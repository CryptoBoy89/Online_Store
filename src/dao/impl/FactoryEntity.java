package dao.impl;

import dao.AttributeDAO;
import dao.CategoryDAO;
import dao.GoodsDAO;
import dao.ValueDAO;

public class FactoryEntity {

    private static CategoryDAO categoryDAO = null;
    private static GoodsDAO goodsDAO = null;
    private static AttributeDAO attributeDAO = null;
    private static ValueDAO valueDAO = null;
    private static FactoryEntity instance = null;

    public static FactoryEntity getInstance() {
        if(instance == null){
            return  new FactoryEntity();
        }
        return instance;
    }

    public CategoryDAO getCategoryDAO() {
        if(categoryDAO == null) {
            return new CategoryDAOImpl();
        }
        return categoryDAO;
    }

    public GoodsDAO getGoodsDAO() {
        if(goodsDAO == null) {
            return new GoodsDAOImpl();
        }
        return goodsDAO;
    }

    public AttributeDAO getAttributeDAO() {
        if(attributeDAO == null) {
            return new AttributeDAOImpl();
        }
        return attributeDAO;
    }

    public ValueDAO getValueDAO() {
        if(valueDAO == null) {
            return new ValueDAOImpl();
        }
        return valueDAO;
    }
}
