package com.unibuc.repository;

import com.unibuc.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository  implements Runnable{
    public ProductRepository() {

        dbURL = "jdbc:mysql://localhost:3306/sys";
        username = "root";
        password = "helloworld";
    }

    Connection conn;
    String dbURL;
    String username;
    String password;


    @Override
    public void run() {
        try {

            conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void disconnect()
    {
        try
        {
            conn.close();
            System.out.println("Disonnected");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getMaxIDProducts() throws SQLException
    {
        String sql = "SELECT MAX(id) AS MaxID FROM product";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet r = statement.executeQuery();
        r.next();
        int result = r.getInt("MaxID");
        return result;
    }

    public List<Product> getProducts() throws SQLException
    {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Product pr = new Product();
            pr.setId(rs.getInt("id"));
            pr.setProduct_name(rs.getString("product_name"));
            pr.setProduct_price(rs.getInt("product_price"));
            pr.setProduct_quantity(rs.getInt("product_quantity"));
            products.add(pr);
        }

        return products;
    }



    public Product addProduct(Product product) throws SQLException
    {
        String sql = "INSERT INTO product (id, product_name, product_price, product_quantity) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        Integer id = getMaxIDProducts()+1;
        statement.setString(1, Integer.toString(id));
        statement.setString(2, product.getProduct_name());
        statement.setString(3, Integer.toString(product.getProduct_price()));
        statement.setString(4, Integer.toString(product.getProduct_quantity()));

        statement.executeUpdate();

        return product;

    }

    public Product updateProduct(Product product) throws SQLException
    {
        String sql = "UPDATE product SET product_name ='"+product.getProduct_name()
                +"', product_price="+product.getProduct_price()
                +", product_quantity="+Integer.toString(product.getProduct_quantity())
                +" WHERE id="+Integer.toString(product.getId());

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.executeUpdate();

        return product;

    }



    public Product removeProduct(Product product) throws SQLException
    {
        String sql = "DELETE FROM product WHERE id=" + product.getId();

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.executeUpdate();

        return product;
    }
}