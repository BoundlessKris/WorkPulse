package com.service.interfaces;

import com.model.GigCategory;
import java.util.List;

public interface GigCategoryService {
    GigCategory createCategory(GigCategory category) throws Exception;
    GigCategory getCategoryById(int id) throws Exception;
    List<GigCategory> getAllCategories() throws Exception;
    GigCategory updateCategory(GigCategory category) throws Exception;
    void deleteCategory(int id) throws Exception;
    List<GigCategory> getSubcategories(int parentId) throws Exception;
    List<GigCategory> getTopLevelCategories() throws Exception;
    GigCategory getParentCategory(int categoryId) throws Exception;
    int countGigsInCategory(int categoryId) throws Exception;
    boolean categoryHasGigs(int categoryId) throws Exception;
    List<GigCategory> getCategoryHierarchy(int categoryId) throws Exception;
}
