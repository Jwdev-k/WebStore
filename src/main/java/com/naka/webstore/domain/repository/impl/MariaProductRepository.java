package com.naka.webstore.domain.repository.impl;

import com.naka.webstore.domain.Product;
import com.naka.webstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MariaProductRepository implements ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Product> result = jdbcTemplate.query(
                "SELECT * FROM products", params, new ProductMapper());
        return result;
    }

    public static final class ProductMapper implements RowMapper<Product> {
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getString("ID"));
            product.setName(rs.getString("PROD_NAME"));
            product.setDescription(rs.getString("DESCRIPTION"));
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
            product.setManufacturer(rs.getString("MANUFACTURER"));
            product.setCategory(rs.getString("CATEGORY"));
            product.setCondition(rs.getString("PROD_CONDITION"));
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
            product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
            return product;
        }
    }

    public void updateStock(String productId, long noOfUnits) {
        String SQL = "UPDATE PRODUCTS SET "
                + "UNITS_IN_STOCK = :unitsInStock WHERE ID = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("unitsInStock", noOfUnits);
        params.put("id", productId);

        jdbcTemplate.update(SQL, params);
    }

    public List<Product> getProductsByCategory(String category) {
        String SQL = "SELECT * FROM PRODUCTS " +
                "WHERE LCASE(CATEGORY) = :category";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category.toLowerCase());
        if (params.get(null) == null) {
            return null;
        }
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }

    public List<Product> getProductsByFilter(
            Map<String, List<String>> filterParams) {
        String SQL = "SELECT * FROM PRODUCTS WHERE CATEGORY "
                + "IN (:categories) AND MANUFACTURER IN (:brands)";
        return jdbcTemplate.query(SQL, filterParams, new ProductMapper());
    }

    public Product getProductById(String productID) {
        String SQL = "SELECT * FROM PRODUCTS WHERE ID = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", productID);

        return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
    }


    public void addProduct(Product product) {
        String SQL = "INSERT INTO PRODUCTS "
                + "VALUES (:id, :prod_name, :description, :price, :manufacturer, :category, :condition, :inStock, :inOrder, :discontinued)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", product.getProductId());
        params.put("prod_name", product.getName());
        params.put("description", product.getDescription());
        params.put("price", product.getUnitPrice());
        params.put("manufacturer", product.getManufacturer());
        params.put("category", product.getCategory());
        params.put("condition", product.getCondition());
        params.put("inStock", product.getUnitsInStock());
        params.put("inOrder", product.getUnitsInOrder());
        params.put("discontinued", product.isDiscontinued());

        jdbcTemplate.update(SQL, params);
    }
}
