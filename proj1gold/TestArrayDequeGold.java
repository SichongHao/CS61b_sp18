import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testADG() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String failureMessage = new String();

        for (int i = 0; i < 50; i += 1) {
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
                Integer actualStudent = sad.removeFirst();      // 实际值
                Integer expectedSolution = ads.removeFirst();   // 期望值
                assertEquals(failureMessage, expectedSolution, actualStudent);
                failureMessage = failureMessage + "removeFirst()\n";
            } else {
                Integer actualStudent = sad.removeLast();      // 实际值
                Integer expectedSolution = ads.removeLast();   // 期望值
                assertEquals(failureMessage, expectedSolution, actualStudent);
                failureMessage = failureMessage + "removeLast()\n";
            }
        }

    }
}
