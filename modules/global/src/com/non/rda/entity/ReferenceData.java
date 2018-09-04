package com.non.rda.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NamePattern("%s|referenceValue")
@Table(name = "NONRDA_REFERENCE_DATA")
@Entity(name = "nonrda$ReferenceData")
public class ReferenceData extends StandardEntity {
    private static final long serialVersionUID = 8967790840730615565L;

    @NotNull
    @Column(name = "REFERENCE_CATEGORY", nullable = false)
    protected String referenceCategory;

    @NotNull
    @Column(name = "REFERENCE_CODE", nullable = false, unique = true)
    protected String referenceCode;

    @NotNull
    @Column(name = "REFERENCE_VALUE", nullable = false)
    protected String referenceValue;

    @NotNull
    @Column(name = "SORT_ORDER", nullable = false)
    protected Long sortOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    protected ReferenceData parent;

    public void setParent(ReferenceData parent) {
        this.parent = parent;
    }

    public ReferenceData getParent() {
        return parent;
    }


    public void setReferenceCategory(String referenceCategory) {
        this.referenceCategory = referenceCategory;
    }

    public String getReferenceCategory() {
        return referenceCategory;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceValue(String referenceValue) {
        this.referenceValue = referenceValue;
    }

    public String getReferenceValue() {
        return referenceValue;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() {
        return sortOrder;
    }


}