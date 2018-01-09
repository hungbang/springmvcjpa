package com.example.entity;

import javax.persistence.*;


@Entity
@Table(name = "order_items", schema = "spring-hateoas")
public class OrderItems {
    private int id;
    private String price;
    private Long productVariantId;
    private Long orderId;
    private Long productId;
    private GroupVariants groupVariantsByProductVariantId;
    private Orders ordersByOrderId;
    private Products productsByProductId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "product_variant_id", insertable=false, updatable=false)
    public Long getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(Long productVariantId) {
        this.productVariantId = productVariantId;
    }

    @Basic
    @Column(name = "order_id", insertable=false, updatable=false)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "product_id", insertable=false, updatable=false)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItems that = (OrderItems) o;

        if (id != that.id) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (productVariantId != null ? !productVariantId.equals(that.productVariantId) : that.productVariantId != null)
            return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productVariantId != null ? productVariantId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_variant_id", referencedColumnName = "id")
    public GroupVariants getGroupVariantsByProductVariantId() {
        return groupVariantsByProductVariantId;
    }

    public void setGroupVariantsByProductVariantId(GroupVariants groupVariantsByProductVariantId) {
        this.groupVariantsByProductVariantId = groupVariantsByProductVariantId;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public Orders getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public Products getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
