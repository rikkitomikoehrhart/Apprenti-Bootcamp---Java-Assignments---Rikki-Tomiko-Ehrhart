package com.example.jdbc_example.demo.repository;

import com.example.jdbc_example.demo.model.Pet;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetJdbcRepository {

    private DataSource dataSource = initDataSource();


    private DataSource initDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/pet_management");
        ds.setURL("newuser");
        ds.setPassword("NewUser113!");
        return ds;
    }


    public Pet add(Pet pet) {
        final String sql = "INSERT INTO pet (name, type) VALUES (?, ?);";

        try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted <= 0) return null;
            try (ResultSet keys = statement.getGeneratedKeys()){
                if (keys.next()) {
                    pet.setPetId(keys.getInt(1));
                    return pet;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        final String sql = "SELECT pet_id, name, type FROM pet;";

        try (Connection conn = dataSource.getConnection(); Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("pet_id"));
                pet.setName(rs.getString("name"));
                pet.setType(rs.getString("type"));
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pets;
    }


    public boolean update(Pet pet) {
        final String sql = "UPDATE pet SET name = ?, type = ?, WHERE pet_id = ?;";

        try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.setInt(3, pet.getPetId());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteById(int petId) {
        final String sql = "DELETE FROM pet WHERE pet_id = ?;";

        try (Connection conn = dataSource.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, petId);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }







}
