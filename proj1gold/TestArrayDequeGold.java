import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testADG() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String failureMessage = "";

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne > 0.75) {
                sad.addLast(i);
                ads.addLast(i);
                failureMessage = failureMessage + "addLast(" + i + ")\n";
            } else if(numberBetweenZeroAndOne > 0.5) {
                sad.addFirst(i);
                ads.addFirst(i);
                failureMessage = failureMessage + "addFirst(" + i + ")\n";
            } else if (numberBetweenZeroAndOne > 0.25) {
                int actualStudent = sad.removeFirst();      // 实际值
                int expectedSolution = ads.removeFirst();   // 期望值
                failureMessage = failureMessage + "removeFirst()\n";
                assertEquals(failureMessage, expectedSolution, actualStudent);
            } else {
                int actualStudent = sad.removeLast();      // 实际值
                int expectedSolution = ads.removeLast();   // 期望值
                failureMessage = failureMessage + "removeLast()\n";
                assertEquals(failureMessage, expectedSolution, actualStudent);
            }
        }

    }
}
