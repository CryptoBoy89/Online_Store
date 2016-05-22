package dao.impl;

import dao.ValueDAO;
import entity.ValueEntity;
import exceptions.EntityNotFoundException;
import javax.persistence.*;
import java.util.List;

public class ValueDAOImpl implements ValueDAO{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    @Override
    public void addValue(ValueEntity value) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(value);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void removeValue(ValueEntity value) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        ValueEntity valueEntity = manager.find(ValueEntity.class, value.getGoodsId());
        if(valueEntity != null) {
            manager.remove(valueEntity);
            manager.getTransaction().commit();
            manager.close();
        }
        else {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Error deleting value");
        }
    }

    @Override
    public List findValueById(int goods_id) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createNativeQuery("SELECT value_entity FROM attr_value WHERE goods_id1 =:id_param");
        query.setParameter("id_param", goods_id);
        List list = query.getResultList();
        if(list.isEmpty()) {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Value not found");
        }
        manager.getTransaction().commit();
        manager.close();
        return list;
    }

    @Override
    public List<String> getAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<String> namedQuery = manager.createNamedQuery("ValueEntity.getAll", String.class);
        List<String> list = namedQuery.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;
    }
}
