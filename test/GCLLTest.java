import org.junit.Assert;
import org.junit.Test;

public class GCLLTest {
    @Test
    public void testAdd_emptyList()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        Assert.assertEquals("first->|1|->|1|", list.toString());
    }

    @Test
    public void testAdd_oneElement()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.add(2);
        Assert.assertEquals("first->|1|->|2|->|1|", list.toString());
    }

    @Test
    public void testAdd_multipleElements()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals("first->|1|->|3|->|2|->|1|", list.toString());
    }

    @Test
    public void testFind_true()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertTrue(list.find(2));
    }

    @Test
    public void testFind_false()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertFalse(list.find(4));
    }

    @Test
    public void testGetFirst_empty()
    {
        GCLL<Integer> list = new GCLL<>();
        Assert.assertNull(list.getFirst());
    }

    @Test
    public void testGetFirst_nonEmpty()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        Assert.assertEquals((Object) 1, list.getFirst());
    }

 /*    @Test
    public void testGetLast_empty()
    {
        GCLL<Integer> list = new GCLL<>();
        Assert.assertNull(list.getLast());
    }

   @Test
    public void testGetLast_nonEmpty()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        Assert.assertEquals(1, list.getLast());
    }*/

    @Test
    public void testRemove_true()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertTrue(list.remove(2));
    }

    @Test
    public void testRemove_false()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertFalse(list.remove(4));
    }

    @Test
    public void testAdvance_oneElement()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.advance(1);
        Assert.assertEquals("first->|1|->|1|", list.toString());
    }

    @Test
    public void testAdvance_multipleElements()
    {
        GCLL<Integer> list = new GCLL<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.advance(1);
        Assert.assertEquals("first->|3|->|2|->|1|->|3|", list.toString());
    }

}
