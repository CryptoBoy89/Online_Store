package dao;

import entity.GoodsEntity;
import exceptions.EntityNotFoundException;
import java.util.List;

public interface GoodsDAO {
    void addGoods(GoodsEntity goods);
    void removeGoods(GoodsEntity goods) throws EntityNotFoundException;
    void editGoods(GoodsEntity goods, String new_name) throws EntityNotFoundException;
    GoodsEntity findGoodsById(int id) throws EntityNotFoundException;
    List<String> getAll();
}
