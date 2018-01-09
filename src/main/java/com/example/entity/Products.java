package com.example.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Products {
    private long id;
    private String created;
    private String description;
    private String name;
    private String price;
    private String userId;
    private Long groupId;
    private Collection<OrderItems> orderItemsById;
    private ProductGroups productGroupsByGroupId;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "group_id", insertable=false, updatable=false)
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (id != products.id) return false;
        if (created != null ? !created.equals(products.created) : products.created != null) return false;
        if (description != null ? !description.equals(products.description) : products.description != null)
            return false;
        if (name != null ? !name.equals(products.name) : products.name != null) return false;
        if (price != null ? !price.equals(products.price) : products.price != null) return false;
        if (userId != null ? !userId.equals(products.userId) : products.userId != null) return false;
        if (groupId != null ? !groupId.equals(products.groupId) : products.groupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productsByProductId")
    public Collection<OrderItems> getOrderItemsById() {
        return orderItemsById;
    }

    public void setOrderItemsById(Collection<OrderItems> orderItemsById) {
        this.orderItemsById = orderItemsById;
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    public ProductGroups getProductGroupsByGroupId() {
        return productGroupsByGroupId;
    }

    public void setProductGroupsByGroupId(ProductGroups productGroupsByGroupId) {
        this.productGroupsByGroupId = productGroupsByGroupId;
    }
}
