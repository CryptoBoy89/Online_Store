package dao.impl;

import dao.GoodsDAO;
import entity.GoodsEntity;
import exceptions.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    @Override
    public void addGoods(GoodsEntity goods) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(goods);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void removeGoods(GoodsEntity goods) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        GoodsEntity goodsEntity = manager.find(GoodsEntity.class, goods.getGoodsId());
        if(goodsEntity != null) {
            manager.remove(goodsEntity);
            manager.getTransaction().commit();
            manager.getTransaction().begin();
            manager.createNativeQuery("ALTER TABLE goods AUTO_INCREMENT = 1").executeUpdate();
            manager.getTransaction().commit();
            manager.close();
        }
        else {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Error deleting goods");
        }
    }

    @Override
    public void editGoods(GoodsEntity goods, String new_name) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        GoodsEntity goodsEntity = manager.find(GoodsEntity.class, goods.getGoodsId());
        if(goodsEntity != null) {
            goodsEntity.setName(new_name);
            manager.getTransaction().commit();
            manager.close();
        }
        else {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Goods not found");
        }
    }

    @Override
    public GoodsEntity findGoodsById(int id) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        GoodsEntity goodsEntity = manager.find(GoodsEntity.class, id);
        if(goodsEntity == null) {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Goods not found");
        }
        manager.getTransaction().commit();
        manager.close();
        return goodsEntity;
    }

    @Override
    public List<String> getAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<String> namedQuery = manager.createNamedQuery("GoodsEntity.getAll", String.class);
        List<String> list = namedQuery.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;
    }
}
