import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    public void emptyArrayShouldThrowException() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {};
        int change = 1;
        Exception e = assertThrows(IllegalArgumentException.class, () -> {cc.getChange(arr, change);});
        assertEquals("Invalid coin array.", e.getMessage());
    }

    @Test
    public void test1() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {1, 5, 10, 25};
        int change = 42;
        int[] expectedArr = new int[]{25,10,5,1,1};
        int[] result;
        try {
            result = cc.getChange(arr, change);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            result = new int[]{0,1,2,3,4};
        }
        assertArrayEquals(expectedArr, result);
    }

    @Test
    public void test2() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {1};
        int change = 5;
        int[] expectedArr = new int[]{1,1,1,1,1};
        int[] result;
        try {
            result = cc.getChange(arr, change);
        } catch (Exception e) {
            result = new int[0];
        }
        assertArrayEquals(expectedArr, result);
    }

    @Test
    public void test3() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = {1,5};
        int change = 5;
        int[] expectedArr = new int[]{5};
        int[] result;
        try {
            result = cc.getChange(arr, change);
        } catch (Exception e) {
            result = new int[0];
        }
        assertArrayEquals(expectedArr, result);
    }

    @Test
    public void test4() {
        ChangeCalculator cc = new ChangeCalculator();
        int[] arr = new int[]{1,4,6,10};
        int change = 9;
        int[] expectedArr = new int[]{1,4,4};
        int[] result;
        try {
            result = cc.getChange(arr, change);
        } catch (Exception e) {
            result = new int[0];
        }
        assertArrayEquals(expectedArr, result);
    }
}
