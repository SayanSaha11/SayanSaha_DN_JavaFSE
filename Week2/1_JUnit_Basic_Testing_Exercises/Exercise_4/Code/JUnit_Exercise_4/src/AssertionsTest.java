import org.junit.*;

import static org.junit.Assert.*;

public class AssertionsTest {

    @BeforeClass
    public static void setupClass() {
        System.out.println(">>> @BeforeClass: Run once before all tests");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println(">>> @AfterClass: Run once after all tests");
    }

    @Before
    public void setup() {
        System.out.println("  > @Before: Run before each test");
    }

    @After
    public void tearDown() {
        System.out.println("  > @After: Run after each test");
    }

    @Test
    public void testAddition() {
        System.out.println("    - testAddition()");
        assertEquals(5, 2 + 3);
    }

    @Test
    public void testBooleanConditions() {
        System.out.println("    - testBooleanConditions()");
        assertTrue(10 > 1);
        assertFalse(1 > 10);
    }

    @Test
    public void testNulls() {
        System.out.println("    - testNulls()");
        Object obj = null;
        assertNull(obj);
        obj = new Object();
        assertNotNull(obj);
    }
}
