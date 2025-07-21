package org.example.data;


import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public class ItemFromDatabase implements ItemRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public Item getItemById(int id) throws RecordNotFoundException, InternalErrorException {
        String sql = "SELECT * FROM Item WHERE ItemID = ?;";
        Item item;

        try {
            item = jdbcTemplate.queryForObject(sql, itemRowMapper(), id);
            return item;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Item> getAllAvailableItems(LocalDate today) throws InternalErrorException {
        return List.of();
    }

    @Override
    public List<Item> getItemsByCategory(LocalDate today, int itemCategoryID) throws InternalErrorException {
        return List.of();
    }

    @Override
    public List<ItemCategory> getAllItemCategories() throws InternalErrorException {
        return List.of();
    }



    private RowMapper<Item> itemRowMapper() {
        return (rs, rowNum) -> {
            Item item = new Item();

            item.setItemID(rs.getInt("ItemID"));
            item.setItemCategoryID(rs.getInt("ItemCategoryID"));
            item.setItemName(rs.getString("ItemName"));
            item.setItemDescription(rs.getString("ItemDescription"));
            item.setStartDate(rs.getObject("StartDate", LocalDate.class));
            item.setEndDate(rs.getObject("EndDate", LocalDate.class));
            item.setUnitPrice(rs.getBigDecimal("UnitPrice"));


            return item;
        };
    }
}
