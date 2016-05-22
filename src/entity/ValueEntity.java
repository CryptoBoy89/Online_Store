package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attr_value", schema = "", catalog = "webshop")
@NamedQuery(name = "ValueEntity.getAll", query = "SELECT value FROM ValueEntity ")
public class ValueEntity implements Serializable {

    private int goodsId;
    private String value;
    private String keyRef;

    public ValueEntity(int goodsId, String value, String keyRef) {
        this.goodsId = goodsId;
        this.value = value;
        this.keyRef = keyRef;
    }

    public ValueEntity() {
    }

    @Id
    @Column(name = "goods_id1")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "value_entity")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Basic
    @Column(name = "key_ref")
    public String getKeyRef() {
        return keyRef;
    }

    public void setKeyRef(String keyRef) {
        this.keyRef = keyRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueEntity that = (ValueEntity) o;

        if (getGoodsId() != that.getGoodsId()) return false;
        if (!getValue().equals(that.getValue())) return false;
        return getKeyRef().equals(that.getKeyRef());

    }

    @Override
    public int hashCode() {
        int result = getGoodsId();
        result = 31 * result + getValue().hashCode();
        result = 31 * result + getKeyRef().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ValueEntity{" +
                "goodsId=" + goodsId +
                ", value='" + value + '\'' +
                ", key='" + keyRef + '\'' +
                '}';
    }
}
