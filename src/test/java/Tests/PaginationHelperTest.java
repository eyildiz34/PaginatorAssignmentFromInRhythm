package Tests;
import PaginationHelper.PaginationHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PaginationHelperTest {
    private PaginationHelper helper;
    Logger log=Logger.getLogger(Logger.class);
    @BeforeMethod
    public void setup() {

        helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
    }

    @Test(priority = 1, description = "Testing item count", enabled = true)
    public void getItemCount() {
        log.debug("Checking itemcount is not null");
        Assert.assertNotNull(helper.itemCount());
        log.debug("item count should match 6");
        Assert.assertEquals(6, helper.itemCount());
        log.debug("Checking item count should not be equal to a string value");
        Assert.assertNotEquals('z', helper.itemCount());
    }

    @Test(priority = 2, description = "Testing Page count", enabled = true)
    public void getPageCount() {
        log.debug("Checking page count is not null");
        Assert.assertNotNull(helper.pageCount());
        log.debug("Page count should match 2");
        Assert.assertEquals(2, helper.pageCount());
        log.debug("Checking page count should not be equal to a string value");
        Assert.assertNotEquals('k', helper.pageCount());
    }

    @Test(priority = 3, description = "Test for page item count if it should match required values", enabled = true)
    public void getPageItemCount() {
        log.debug("Checking if first page has only 4 values");
        Assert.assertEquals(4, helper.pageItemCount(0));
        log.debug("Checking if second page has only 2 items");
        Assert.assertEquals(2, helper.pageItemCount(1));
        //These tests are negative test cases with different scenarios
        Assert.assertEquals(-1, helper.pageItemCount(2));
        Assert.assertNotEquals(-1, helper.pageItemCount(1));
        Assert.assertNotEquals('w', helper.pageItemCount(1));
        Assert.assertNotEquals(53, helper.pageItemCount(1));
    }

    @Test(priority = 1, description = "Test for page index if it should match required values", enabled = true)
    public void getPageIndex() {
        /**
         * Page and Items are zero based index
         * helper.pageIndex(3); //should == 0
         * helper.pageIndex(4); //should == 0
         * helper.pageIndex(6); //should == 1
         * helper.pageIndex(10); //should == -1
         * helper.pageIndex(-15); //should == -1
         */
        Assert.assertEquals(0, helper.pageIndex(3));
        Assert.assertEquals(1, helper.pageIndex(4));
        Assert.assertEquals(1, helper.pageIndex(5));
        Assert.assertEquals(-1, helper.pageIndex(10));
        Assert.assertEquals(-1, helper.pageIndex(-15));
        Assert.assertNotEquals(-2,helper.pageIndex(5));
        Assert.assertNotEquals(1, helper.pageIndex(2));
        Assert.assertNotEquals(-2,helper.pageIndex(20));
        Assert.assertNotEquals('t',helper.pageIndex(-10));
    }

    @AfterMethod
    public void tearDown(){
        helper=null;
    }

}
