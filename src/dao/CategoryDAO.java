package dao;

import entity.CategoryEntity;
import exceptions.EntityNotFoundException;
import java.util.List;

public interface CategoryDAO {
     void addCategory(CategoryEntity category);
     void removeCategory(CategoryEntity category) throws EntityNotFoundException;
     void editCategory(CategoryEntity category, String new_name) throws EntityNotFoundException;
     CategoryEntity findCategoryById(int id) throws EntityNotFoundException;
     List<String> getAll();
}
