package com.example.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "group_variants", schema = "spring-hateoas")
public class GroupVariants {
    private long id;
    private String variantName;
    private Long groupId;
    private ProductGroups productGroupsByGroupId;
    private Collection<OrderItems> orderItemsById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "variant_name")
    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
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

        GroupVariants that = (GroupVariants) o;

        if (id != that.id) return false;
        if (variantName != null ? !variantName.equals(that.variantName) : that.variantName != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (variantName != null ? variantName.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    public ProductGroups getProductGroupsByGroupId() {
        return productGroupsByGroupId;
    }

    public void setProductGroupsByGroupId(ProductGroups productGroupsByGroupId) {
        this.productGroupsByGroupId = productGroupsByGroupId;
    }

    @OneToMany(mappedBy = "groupVariantsByProductVariantId")
    public Collection<OrderItems> getOrderItemsById() {
        return orderItemsById;
    }

    public void setOrderItemsById(Collection<OrderItems> orderItemsById) {
        this.orderItemsById = orderItemsById;
    }
}
