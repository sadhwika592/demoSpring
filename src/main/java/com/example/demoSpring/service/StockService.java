package com.example.demoSpring.service;

import com.example.demoSpring.dto.StockDTO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private static final String DB_URL = "jdbc:postgresql://endeavourtech.ddns.net:50271/CrudDB";
    private static final String USER = "endeavour_test_area";
    private static final String PASS = "Endeavour01";

    // ---------- GET with Pagination ----------
    public List<StockDTO> getPaginatedStocks(int pageNum, int pageSize) {
        List<StockDTO> stocks = new ArrayList<>();
        int offset = (pageNum - 1) * pageSize;

        String sql = "SELECT * FROM endeavour_test_area.get_stocks_sadhwikafunction(?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, offset);
            stmt.setInt(2, pageSize);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    StockDTO stock = new StockDTO(
                            rs.getInt("stock_id"),
                            rs.getString("stock_name"),
                            rs.getString("symbol"),
                            rs.getDouble("price")
                    );
                    stocks.add(stock);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;
    }

    // ---------- POST (Insert Stock) ----------
    public String addStock(StockDTO stock) {
        String sql = "INSERT INTO endeavour_test_area.stocks_sadhwika (stock_name, symbol, price) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, stock.getStockName());
            stmt.setString(2, stock.getSymbol());
            stmt.setDouble(3, stock.getPrice());
            stmt.executeUpdate();

            return "Stock inserted successfully!";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error inserting stock: " + e.getMessage();
        }
    }
}
