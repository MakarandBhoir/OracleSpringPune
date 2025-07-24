package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oracle.model.Account;
import com.oracle.util.DBUtil;

public class AccountDAOImpl implements AccountDAO {

    public void create(Account account) throws Exception {
        String sql = "INSERT INTO account (id, account_number, balance) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, account.getId());
            ps.setString(2, account.getAccountNumber());
            ps.setDouble(3, account.getBalance());
            ps.executeUpdate();
        }
    }

    public Account read(int id) throws Exception {
        String sql = "SELECT * FROM account WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("id"));
                acc.setAccountNumber(rs.getString("account_number"));
                acc.setBalance(rs.getDouble("balance"));
                return acc;
            }
        }
        return null;
    }

    public void update(Account account) throws Exception {
        String sql = "UPDATE account SET account_number = ?, balance = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, account.getAccountNumber());
            ps.setDouble(2, account.getBalance());
            ps.setInt(3, account.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws Exception {
        String sql = "DELETE FROM account WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}