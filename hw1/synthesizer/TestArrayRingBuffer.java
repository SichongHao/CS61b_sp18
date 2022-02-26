package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        assertTrue(arb.isEmpty());
        arb.enqueue(33);
        arb.enqueue(44);
        arb.enqueue(55);
        assertFalse(arb.isFull());
        arb.enqueue(66);
        assertTrue(arb.isFull());
        assertEquals(33, arb.dequeue());
        assertEquals(44, arb.peek());
        assertEquals(44, arb.peek());
    }

    @Test
    public void iterableTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        arb.enqueue(33);
        arb.enqueue(44);
        arb.enqueue(55);

        //iteration
        for (Object i : arb) {
            System.out.println(i);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
