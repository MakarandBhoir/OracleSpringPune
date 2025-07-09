package com.oracle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.oracle.model.Student;

@Repository
public class StudentDao {

    private final JdbcTemplate jdbc;

    public StudentDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

//    public void init() {
//        jdbc.execute("CREATE TABLE student (id INT PRIMARY KEY, name VARCHAR(50), age INT)");
//        jdbc.update("INSERT INTO student (id, name, age) VALUES (1, 'Alice', 20)");
//        jdbc.update("INSERT INTO student (id, name, age) VALUES (2, 'Bob', 22)");
//    }

    public void init() {
        jdbc.execute("CREATE TABLE student (id NUMBER PRIMARY KEY, name VARCHAR2(50), age NUMBER)");
        jdbc.update("INSERT INTO student (id, name, age) VALUES (1, 'Alice', 20)");
        jdbc.update("INSERT INTO student (id, name, age) VALUES (2, 'Bob', 22)");
    }
    
    public void destroy() {
    	jdbc.execute("DROP TABLE student");
    }
    
    public List<Student> findAll() {
        return jdbc.query("SELECT * FROM student", new StudentMapper());
    }

    public void save(Student s) {
        jdbc.update("INSERT INTO student (id, name, age) VALUES (?, ?, ?)", s.getId(), s.getName(), s.getAge());
    }

    static class StudentMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
        }
    }
}