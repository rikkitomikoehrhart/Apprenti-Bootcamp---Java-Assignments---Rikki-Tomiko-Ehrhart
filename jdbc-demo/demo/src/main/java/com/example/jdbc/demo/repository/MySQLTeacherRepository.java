package com.example.jdbc.demo.repository;

import com.example.jdbc.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class MySQLTeacherRepository implements TeacherRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Teacher> getAll() {
        // "Where the magic happens"
        String sql = "SELECT * FROM Teacher ORDER BY LastName";

        try {
            return jdbcTemplate.query(sql, teacherRowMapper());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return List.of();
    }

    private RowMapper<Teacher> teacherRowMapper() {
        return (rs, rowNum) -> {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(rs.getInt("TeacherID"));
            teacher.setFirstName(rs.getString("FirstName"));
            teacher.setLastName(rs.getString("LastName"));

            return teacher;
        };
    }

    @Override
    public Teacher add(Teacher teacher) {
        String sql = "INSERT INTO Teacher (FirstName, LastName) VALUES (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();


        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, teacher.getFirstName());
                ps.setString(2, teacher.getLastName());

                return ps;
            }, keyHolder);

            teacher.setTeacherId(keyHolder.getKey().intValue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return teacher;
    }


    @Override
    public Optional<Teacher> getById(int teacherID) {
        String sql = "SELECT * FROM Teacher WHERE TeacherID = ?";

        try {
            Teacher teacher = jdbcTemplate.queryForObject(sql, teacherRowMapper(), teacherID);
            return Optional.of(teacher);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Teacher update(Teacher teacher) {
        String sql = "UPDATE Teacher SET FirstName = ?, LastName = ? WHERE TeacherID = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, teacher.getFirstName(), teacher.getLastName(), teacher.getTeacherId());

            if (rowsAffected == 0) {
                throw new RuntimeException("Teacher with ID " + teacher.getTeacherId() + " is not found!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return teacher;
    }

    @Override
    public boolean delete(int teacherID) {
        String sql = "DELETE FROM Teacher WHERE TeacherID = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, teacherID);
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
