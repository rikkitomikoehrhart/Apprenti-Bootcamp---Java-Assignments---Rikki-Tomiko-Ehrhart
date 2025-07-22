package org.example.data;


import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Item;
import org.example.model.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public class ItemFromDatabase implements ItemRepo {
    private final JdbcTemplate jdbcTemplate;

    public ItemFromDatabase(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Item getItemById(int id) throws RecordNotFoundException, InternalErrorException {
        String sql = "SELECT * FROM Item WHERE ItemID = ?;";
        return jdbcTemplate.queryForObject(sql, itemRowMapper(), id);
    }

    @Override
    public List<Item> getAllAvailableItems(LocalDate today) throws InternalErrorException {
        String sql = "SELECT * FROM Item WHERE StartDate >= ? AND (EndDate <= ? OR EndDate IS NULL)";
        return jdbcTemplate.query(sql, itemRowMapper(), today, today);
    }

    @Override
    public List<Item> getItemsByCategory(LocalDate today, int itemCategoryID) throws InternalErrorException {
        String sql = "SELECT * FROM Item WHERE StartDate >= ? AND ItemCategoryID = ?;";
        return jdbcTemplate.query(sql, itemRowMapper(), today, itemCategoryID);
    }

    @Override
    public List<ItemCategory> getAllItemCategories() throws InternalErrorException {
        String sql = "SELECT * FROM ItemCategory";
        return jdbcTemplate.query(sql, itemCategoryRowMapper());
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

    private RowMapper<ItemCategory> itemCategoryRowMapper() {
        return (rs, rowNum) -> {
            ItemCategory itemCategory = new ItemCategory();

            itemCategory.setItemCategoryID(rs.getInt("ItemCategoryID"));
            itemCategory.setItemCategoryName(rs.getString("ItemCategoryName"));

            return itemCategory;
        };
    }
}
