package com.service.impl;

import com.dao.interfaces.GigCategoryDao;
import com.model.GigCategory;
import com.service.interfaces.GigCategoryService;
import java.util.List;
import java.util.ArrayList;

public class GigCategoryServiceImpl implements GigCategoryService {
    private GigCategoryDao gigCategoryDao;

    public GigCategoryServiceImpl(GigCategoryDao gigCategoryDao) {
        this.gigCategoryDao = gigCategoryDao;
    }

    @Override
    public GigCategory createCategory(GigCategory category) throws Exception {
        validateCategory(category);
        return gigCategoryDao.create(category);
    }

    @Override
    public GigCategory getCategoryById(int id) throws Exception {
        GigCategory category = gigCategoryDao.findById(id);
        if (category == null) {
            throw new Exception("Category not found with id: " + id);
        }
        return category;
    }

    @Override
    public List<GigCategory> getAllCategories() throws Exception {
        return gigCategoryDao.findAll();
    }

    @Override
    public GigCategory updateCategory(GigCategory category) throws Exception {
        validateCategory(category);
        GigCategory existingCategory = getCategoryById(category.getCategoryId());
        if (existingCategory == null) {
            throw new Exception("Category not found for update with id: " + category.getCategoryId());
        }
        return gigCategoryDao.update(category);
    }

    @Override
    public void deleteCategory(int id) throws Exception {
        GigCategory category = getCategoryById(id);
        if (category == null) {
            throw new Exception("Category not found for deletion with id: " + id);
        }
        gigCategoryDao.delete(id);
    }

    @Override
    public List<GigCategory> getSubcategories(int parentId) throws Exception {
        return gigCategoryDao.findSubcategories(parentId);
    }

    @Override
    public List<GigCategory> getTopLevelCategories() throws Exception {
        return gigCategoryDao.findTopLevelCategories();
    }

    @Override
    public GigCategory getParentCategory(int categoryId) throws Exception {
        return gigCategoryDao.findParentCategory(categoryId);
    }

    @Override
    public int countGigsInCategory(int categoryId) throws Exception {
        return gigCategoryDao.countGigsInCategory(categoryId);
    }

    @Override
    public boolean categoryHasGigs(int categoryId) throws Exception {
        return gigCategoryDao.hasGigs(categoryId);
    }

    @Override
    public List<GigCategory> getCategoryHierarchy(int categoryId) throws Exception {
        List<GigCategory> hierarchy = new ArrayList<>();
        GigCategory category = getCategoryById(categoryId);
        while (category != null) {
            hierarchy.add(0, category);
            category = getParentCategory(category.getCategoryId());
        }
        return hierarchy;
    }

    private void validateCategory(GigCategory category) throws IllegalArgumentException {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }
    }
}