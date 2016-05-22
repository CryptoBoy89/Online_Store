package dao.impl;

import dao.CategoryDAO;
import entity.CategoryEntity;
import exceptions.EntityNotFoundException;
import javax.persistence.*;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    @Override
    public void addCategory(CategoryEntity category) {
        EntityManager manager = factory.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(category);
            manager.getTransaction().commit();
            manager.close();
    }

    @Override
    public void removeCategory(CategoryEntity category) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        CategoryEntity categoryEntity = manager.find(CategoryEntity.class, category.getCategoryId());
        if(categoryEntity != null) {
            manager.remove(categoryEntity);
            manager.getTransaction().commit();
            manager.getTransaction().begin();
            manager.createNativeQuery("ALTER TABLE goods_category AUTO_INCREMENT = 1").executeUpdate();
            manager.getTransaction().commit();
            manager.close();
        }
        else {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Error deleting category");
        }
    }

    @Override
    public void editCategory(CategoryEntity category, String new_name) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        CategoryEntity categoryEntity = manager.find(CategoryEntity.class, category.getCategoryId());
        if(categoryEntity != null) {
            categoryEntity.setName(new_name);
            manager.getTransaction().commit();
            manager.close();
        }
        else {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Category not found");
        }
    }

    @Override
    public CategoryEntity findCategoryById(int id) throws EntityNotFoundException {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        CategoryEntity category = manager.find(CategoryEntity.class, id);
        if(category == null) {
            manager.getTransaction().rollback();
            manager.close();
            throw new EntityNotFoundException("Category not found");
        }
            manager.getTransaction().commit();
            manager.close();
            return category;
    }

    @Override
    public List<String> getAll() {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<String> namedQuery = manager.createNamedQuery("CategoryEntity.getAll", String.class);
        List<String> list = namedQuery.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return list;
    }
}
