package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oracle.model.Account;
import com.oracle.model.Customer;
import com.oracle.util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {
    private AccountDAO accountDAO = new AccountDAOImpl();

    public void create(Customer customer) throws Exception {
        String sql = "INSERT INTO customer (id, name, email, account_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getEmail());
            ps.setInt(4, customer.getAccount().getId());
            ps.executeUpdate();
        }
    }

    public Customer read(int id) throws Exception {
        String sql = "SELECT * FROM customer WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));

                Account acc = accountDAO.read(rs.getInt("account_id"));
                c.setAccount(acc);
                return c;
            }
        }
        return null;
    }

    public void update(Customer customer) throws Exception {
        String sql = "UPDATE customer SET name = ?, email = ?, account_id = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setInt(3, customer.getAccount().getId());
            ps.setInt(4, customer.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM customer WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
