package com.example.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "product_groups", schema = "spring-hateoas")
public class ProductGroups {
    private long id;
    private String created;
    private String groupName;
    private String price;
    private Collection<GroupVariants> groupVariantsById;
    private Collection<Products> productsById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created")
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroups that = (ProductGroups) o;

        if (id != that.id) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productGroupsByGroupId")
    public Collection<GroupVariants> getGroupVariantsById() {
        return groupVariantsById;
    }

    public void setGroupVariantsById(Collection<GroupVariants> groupVariantsById) {
        this.groupVariantsById = groupVariantsById;
    }

    @OneToMany(mappedBy = "productGroupsByGroupId")
    public Collection<Products> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Products> productsById) {
        this.productsById = productsById;
    }
}
