package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goods_category", schema = "", catalog = "webshop")
@NamedQuery(name = "CategoryEntity.getAll", query = "SELECT name from CategoryEntity")
public class CategoryEntity implements Serializable{

    private int categoryId;
    private String name;

    public CategoryEntity(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public CategoryEntity() {
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (categoryId != that.categoryId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
