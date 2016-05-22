package dao.impl;

import dao.AttributeDAO;
import entity.AttributeEntity;
import exceptions.EntityNotFoundException;
import javax.persistence.*;
import java.util.List;

public class AttributeDAOImpl implements AttributeDAO{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    @Override
    public void addAttribute(AttributeEntity attribute) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(attribute);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void removeAttribute(AttributeEntity attribute) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        AttributeEntity attributeEntity = manager.find(AttributeEntity.class, attribute.getCategoryId2());
        if(attributeEntity != null) {
            manager.remove(attributeEntity);
            manager.getTransaction().commit();
            manager.close();
        }
        else {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Error deleting attribute");
        }
    }

    @Override
    public List findAttributeById(int type_id) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createNativeQuery("SELECT attr_key FROM goods_category_attr WHERE category_id2 =:id_param");
        query.setParameter("id_param", type_id);
        List list = query.getResultList();
        if(list.isEmpty()) {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Attribute not found");
        }
        manager.getTransaction().commit();
        manager.close();
        return list;
    }

    @Override
    public List<String> getAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<String> namedQuery = manager.createNamedQuery("AttributeEntity.getAll", String.class);
        List<String> list = namedQuery.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;
    }
}
