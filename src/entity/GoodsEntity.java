package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goods", schema = "", catalog = "webshop")
@NamedQuery(name = "GoodsEntity.getAll", query = "SELECT name from GoodsEntity")
public class GoodsEntity implements Serializable {

    private int goodsId;
    private String name;
    private int categoryId1;

    public GoodsEntity(int goodsId, String name, int categoryId1) {
        this.goodsId = goodsId;
        this.name = name;
        this.categoryId1 = categoryId1;

    }

    public GoodsEntity(String name, int categoryId1) {
        this.name = name;
        this.categoryId1 = categoryId1;
    }

    public GoodsEntity() {
    }

    @Id
    @Column(name = "goods_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "category_id1")
    public int getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(int categoryId1) {
        this.categoryId1 = categoryId1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (goodsId != that.goodsId) return false;
        if (categoryId1 != that.categoryId1) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + categoryId1;
        return result;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", categoryId1=" + categoryId1 +
                '}';
    }
}
