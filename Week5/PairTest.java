

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PairTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PairTest
{
    /**
     * Default constructor for test class PairTest
     */
    public PairTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void firstCase()
    {
        Pair<Integer,Integer> pair1 = new Pair<Integer,Integer>(3, 5);
        Pair<Integer,Integer> pair2 = new Pair<Integer,Integer>(6, 5);
        Pair<Integer,Integer> pair3 = new Pair<Integer,Integer>(0, 5);
        assertEquals("05", pair3.toString());
        assertEquals("65", pair2.toString());
        assertEquals("35", pair1.toString());
        pair2.setKey(7);
        assertEquals("75", pair2.toString());
        pair3.setValue(9);
        assertEquals("09", pair3.toString());
    }
}

