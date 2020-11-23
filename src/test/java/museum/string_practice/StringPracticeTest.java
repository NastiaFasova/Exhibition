package museum.string_practice;

import museum.string_practice.StringPractice;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StringPracticeTest {

    private StringPractice practice = new StringPractice();

    @Test
    public void ConcatDiffTypes_ConcatStringAndList_Ok() {
        String str = "Concatenation";
        String expected1 = "Concatenation147";
        String expected2 = "Concatenation1.54.47.1";
        String actual1 = practice.concatDiffTypes(str, List.of(1, 4, 7));
        String actual2 = practice.concatDiffTypes(str, List.of(1.5, 4.4, 7.1));
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void StrBuilderUse_CreateStringWithStringBuilder_Ok() {
        String[] strings = new String[] {"Str", "Builder", "use"};
        String expected = "Str*Builder*use*";
        String actual = practice.strBuilderUse(strings, "*");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StrSplitUse_SplitStringBySymbol_Ok() {
        String str = "str split use";
        String str2 = "str~split~use";
        String[] expected1 = new String[]{"str", "split",  "use"};
        String[] expected2 = new String[]{"str", "split",  "use"};
        String[] actual1 = practice.strSplitUse(str, " ");
        String[] actual2 = practice.strSplitUse(str2, "~");

        Assert.assertArrayEquals(expected1, actual1);
        Assert.assertArrayEquals(expected2, actual2);
    }
}