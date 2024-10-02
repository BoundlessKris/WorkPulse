package com.dao.impl;

import com.dao.interfaces.GigPriceDao;
import com.model.GigPrice;
import com.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GigPriceDaoImpl implements GigPriceDao {

    @Override
    public GigPrice create(GigPrice gigPrice) throws Exception {
        String sql = "INSERT INTO gig_prices (gig_id, tier_name, price, description) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, gigPrice.getGigId());
            ps.setString(2, gigPrice.getTierName());
            ps.setBigDecimal(3, gigPrice.getPrice());
            ps.setString(4, gigPrice.getDescription());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating gig price failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    gigPrice.setPriceId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating gig price failed, no ID obtained.");
                }
            }
        }
        return gigPrice;
    }

    @Override
    public GigPrice findById(int id) throws Exception {
        String sql = "SELECT * FROM gig_prices WHERE price_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractGigPriceFromResultSet(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<GigPrice> findByGigId(int gigId) throws Exception {
        List<GigPrice> prices = new ArrayList<>();
        String sql = "SELECT * FROM gig_prices WHERE gig_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, gigId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    prices.add(extractGigPriceFromResultSet(rs));
                }
            }
        }
        return prices;
    }

    @Override
    public GigPrice update(GigPrice gigPrice) throws Exception {
        String sql = "UPDATE gig_prices SET gig_id = ?, tier_name = ?, price = ?, description = ? WHERE price_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, gigPrice.getGigId());
            ps.setString(2, gigPrice.getTierName());
            ps.setBigDecimal(3, gigPrice.getPrice());
            ps.setString(4, gigPrice.getDescription());
            ps.setInt(5, gigPrice.getPriceId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating gig price failed, no rows affected.");
            }
        }
        return gigPrice;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM gig_prices WHERE price_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private GigPrice extractGigPriceFromResultSet(ResultSet rs) throws SQLException {
        GigPrice gigPrice = new GigPrice();
        gigPrice.setPriceId(rs.getInt("price_id"));
        gigPrice.setGigId(rs.getInt("gig_id"));
        gigPrice.setTierName(rs.getString("tier_name"));
        gigPrice.setPrice(rs.getBigDecimal("price"));
        gigPrice.setDescription(rs.getString("description"));
        return gigPrice;
    }

	@Override
	public GigPrice findBasePrice(int gigId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GigPrice> findByPriceRange(double minPrice, double maxPrice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMultipleTiers(int gigId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GigPrice findHighestTier(int gigId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}