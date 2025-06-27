package org.example;

import org.example.learn.memories.data.DataAccessException;
import org.example.learn.memories.data.MemoryFileRepository;
import org.example.learn.memories.domain.MemoryResult;
import org.example.learn.memories.domain.MemoryService;
import org.example.learn.memories.models.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MemoryFileRepositoryTest {
    static final String SEED_FILE_PATH = "./data/memories-seed.txt";
    static final String TEST_FILE_PATH = "./data/memories-test.txt";

    MemoryFileRepository repository = new MemoryFileRepository(TEST_FILE_PATH);

    @BeforeEach
    void setupTest() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);

        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataAccessException {
        List<Memory> actual = repository.findAll();
        assertEquals(3, actual.size());
    }

    @Test
    void findShareable() throws DataAccessException {
        List<Memory> actual = repository.findSharable(true);
        assertEquals(2, actual.size());     // seed data has 2 shareable memories

        actual = repository.findSharable(false);
        assertEquals(1, actual.size());     // 1 non-shareable memory
    }

    @Test
    void findById() throws DataAccessException {
        Memory memory = repository.findById(2);
        assertNotNull(memory);
        assertEquals("Uncle Sherwin", memory.getFrom());
        assertTrue(memory.isShareable());

        memory = repository.findById(1024);
        assertNull(memory);         // id 1024 does not exist, expect null
    }

    @Test
    void add() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("A Friend");
        memory.setContent("A special memory.");

        Memory actual = repository.add(memory);
        assertEquals(4, actual.getId());

        List<Memory> all = repository.findAll();
        assertEquals(4, all.size());

        actual = all.get(3);        // the newly added memory
        assertEquals(4, actual.getId());
        assertEquals("A Friend", actual.getFrom());         // confirm all fields
        assertEquals("A special memory.", actual.getContent());
        assertFalse(actual.isShareable());
    }

    @Test
    void update() throws DataAccessException {
        Memory memory = repository.findById(2);
        memory.setFrom("Sherwin");      // was Uncle Sherwin
        memory.setShareable(false);     // was true
        assertTrue(repository.update(memory));


        memory = repository.findById(2);
        assertNotNull(memory);          // confirm the memory exists
        assertEquals("Sherwin", memory.getFrom());      // confirm memory was updated
        assertFalse(memory.isShareable());

        Memory doesNotExist = new Memory();
        doesNotExist.setId(1024);
        assertFalse(repository.update(doesNotExist));     // can't update a memory that doesn't exists
    }

    @Test
    void deleteById() throws DataAccessException {
        int count = repository.findAll().size();
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(1024));
        assertEquals(count - 1, repository.findAll().size());
    }
    


}
