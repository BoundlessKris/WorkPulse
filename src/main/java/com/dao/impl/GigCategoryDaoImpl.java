package com.dao.impl;

import com.dao.interfaces.GigCategoryDao;
import com.model.GigCategory;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GigCategoryDaoImpl implements GigCategoryDao {

    @Override
    public GigCategory create(GigCategory category) throws Exception {
        String sql = "INSERT INTO gig_categories (name, parent_category_id) VALUES (?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, category.getName());
            if (category.getParentCategoryId() != null) {
                ps.setInt(2, category.getParentCategoryId());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating gig category failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    category.setCategoryId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating gig category failed, no ID obtained.");
                }
            }
        }
        return category;
    }

    @Override
    public GigCategory findById(int id) throws Exception {
        String sql = "SELECT * FROM gig_categories WHERE category_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractGigCategoryFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<GigCategory> findAll() throws Exception {
        List<GigCategory> categories = new ArrayList<>();
        String sql = "SELECT * FROM gig_categories";
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                categories.add(extractGigCategoryFromResultSet(rs));
            }
        }
        return categories;
    }

    @Override
    public GigCategory update(GigCategory category) throws Exception {
        String sql = "UPDATE gig_categories SET name = ?, parent_category_id = ? WHERE category_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, category.getName());
            if (category.getParentCategoryId() != null) {
                ps.setInt(2, category.getParentCategoryId());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            ps.setInt(3, category.getCategoryId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating gig category failed, no rows affected.");
            }
        }
        return category;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM gig_categories WHERE category_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private GigCategory extractGigCategoryFromResultSet(ResultSet rs) throws SQLException {
        GigCategory category = new GigCategory();
        category.setCategoryId(rs.getInt("category_id"));
        category.setName(rs.getString("name"));
        category.setParentCategoryId(rs.getInt("parent_category_id"));
        if (rs.wasNull()) {
            category.setParentCategoryId(null);
        }
        return category;
    }

	@Override
	public List<GigCategory> findSubcategories(int parentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GigCategory> findTopLevelCategories() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GigCategory findParentCategory(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countGigsInCategory(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasGigs(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
