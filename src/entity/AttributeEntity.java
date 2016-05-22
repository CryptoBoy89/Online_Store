package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goods_category_attr", schema = "", catalog = "webshop")
@NamedQuery(name = "AttributeEntity.getAll", query = "SELECT attrKey FROM AttributeEntity")
public class AttributeEntity implements Serializable{

    private int categoryId2;
    private String attrKey;

    public AttributeEntity(String attrKey, int categoryId2) {
        this.attrKey = attrKey;
        this.categoryId2 = categoryId2;
    }

    public AttributeEntity() {
    }

    @Id
    @Column(name = "category_id2")
    public int getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(int categoryId2) {
        this.categoryId2 = categoryId2;
    }

    @Basic
    @Column(name = "attr_key")
    public String getAttrKey() {
        return attrKey;
    }

    public void setAttrKey(String attrKey) {
        this.attrKey = attrKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeEntity that = (AttributeEntity) o;

        if (getCategoryId2() != that.getCategoryId2()) return false;
        return getAttrKey().equals(that.getAttrKey());

    }

    @Override
    public int hashCode() {
        int result = getCategoryId2();
        result = 31 * result + getAttrKey().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AttributeEntity{" +
                "categoryId2=" + categoryId2 +
                ", key='" + attrKey + '\'' +
                '}';
    }
}
