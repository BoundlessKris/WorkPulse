package com.model;

import java.util.Objects;

public class GigCategory {
    private int categoryId;
    private String name;
    private Integer parentCategoryId;

    public GigCategory() {
    }

    public GigCategory(int categoryId, String name, Integer parentCategoryId) {
        this.categoryId = categoryId;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    @Override
    public String toString() {
        return "GigCategory{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", parentCategoryId=" + parentCategoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GigCategory that = (GigCategory) o;
        return categoryId == that.categoryId && Objects.equals(name, that.name) && Objects.equals(parentCategoryId, that.parentCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, parentCategoryId);
    }
    // Helper method to check if this is a top-level category
    public boolean isTopLevelCategory() {
        return parentCategoryId == null;
    }
    // Helper method to check if this category is a child of another category
    public boolean isChildOf(int parentId) {
        return parentCategoryId != null && parentCategoryId == parentId;
    }
}
