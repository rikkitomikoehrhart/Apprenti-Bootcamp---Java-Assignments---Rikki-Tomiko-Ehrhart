import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UtilityTest {
    Utility util = new Utility();
    Visit samplePatientVisit;
    Visit[] visitList;
    @BeforeEach
    void setUp() {
        samplePatientVisit = TestData.getExamplePatientVisit();
        visitList = TestData.getPatientVisits();
    }





}
