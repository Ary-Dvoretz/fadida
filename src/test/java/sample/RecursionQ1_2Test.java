package sample;

import org.junit.Assert;
import org.junit.Test;

public class RecursionQ1_2Test {

    private RecursionQ1_2 subject = new RecursionQ1_2();

    @Test
    public void sample1() {
        int edits = subject.edit("geek", "gesek");
        Assert.assertEquals(1, edits);
    }

    @Test
    public void sample2() {
        int edits = subject.edit("Sunday", "Saturday");
        Assert.assertEquals(4, edits);
    }

    @Test
    public void sample3() {
        int edits = subject.edit("ab", "bc");
        Assert.assertEquals(2, edits);
    }

    @Test
    public void sample4() {
        int edits = subject.edit("ab", "ab");
        Assert.assertEquals(0, edits);
    }

}
