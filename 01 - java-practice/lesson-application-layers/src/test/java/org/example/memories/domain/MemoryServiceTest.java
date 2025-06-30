package org.example.memories.domain;

import org.example.learn.memories.data.DataAccessException;
import org.example.learn.memories.domain.MemoryResult;
import org.example.learn.memories.domain.MemoryService;
import org.example.memories.data.MemoryRepositoryDouble;
import org.example.learn.memories.models.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MemoryServiceTest {

    MemoryService service;

    @BeforeEach
    void setup() {
        MemoryRepositoryDouble repositoryDouble = new MemoryRepositoryDouble();
        service = new MemoryService(repositoryDouble);
    }

    @Test
    void shouldFindTwoPublicMemories() throws DataAccessException {
        List<Memory> memories = service.findPublicMemories();
        assertEquals(2, memories.size());
    }

    @Test
    void shouldFindOnePrivateMemory() throws DataAccessException {
        List<Memory> memories = service.findPrivateMemories();
        assertEquals(1, memories.size());
    }

    @Test
    void shouldNotAddNullFrom() throws DataAccessException {
        Memory memory = new Memory();
        memory.setContent("That one time we...");

        MemoryResult result = service.add(memory);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().get(0).contains("'from'"));
    }

    @Test
    void shouldNotAddEmptyContent() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("Zonda Itscowics");

        MemoryResult result = service.add(memory);
        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().get(0).contains("'content'"));
    }

    @Test
    void shouldNotAddPositiveId() throws DataAccessException {
        Memory memory = new Memory(12, "from", "content", true);

        MemoryResult result = service.add(memory);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().get(0).contains("'id'"));
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("Zonda Itscowics");
        memory.setContent("That one time we...");

        MemoryResult result = service.add(memory);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotUpdateEmptyContent() throws DataAccessException {
        Memory memory = service.findPublicMemories().get(0);
        memory.setContent("\t\n");
        MemoryResult result = service.update(memory);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().get(0).contains("'content'"));
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Memory memory = service.findPrivateMemories().get(0);
        memory.setContent("updated content");

        MemoryResult result = service.update(memory);

        assertTrue(result.isSuccess());
    }

    

}
