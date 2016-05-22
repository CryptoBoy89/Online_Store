package dao;

import entity.AttributeEntity;
import exceptions.EntityNotFoundException;
import java.util.List;

public interface AttributeDAO {
    void addAttribute(AttributeEntity attribute);
    void removeAttribute(AttributeEntity attribute) throws EntityNotFoundException;
    List findAttributeById(int type_id) throws EntityNotFoundException;
    List<String> getAll();
}
