package dao;

import entity.ValueEntity;
import exceptions.EntityNotFoundException;
import java.util.List;

public interface ValueDAO {
    void addValue(ValueEntity value);
    void removeValue(ValueEntity value) throws EntityNotFoundException;
    List findValueById(int goods_id) throws EntityNotFoundException;
    List<String> getAll();
}
