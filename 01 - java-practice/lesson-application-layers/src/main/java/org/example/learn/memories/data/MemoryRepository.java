package org.example.learn.memories.data;

import org.example.learn.memories.models.Memory;
import java.util.List;


public interface MemoryRepository {
    List<Memory> findAll() throws DataAccessException;
    Memory findById(int memoryID) throws DataAccessException;
    List<Memory> findSharable(boolean shareable) throws DataAccessException;
    Memory add(Memory memory) throws DataAccessException;
    boolean update(Memory memory) throws DataAccessException;
    boolean deleteById(int memoryId) throws DataAccessException;
}
