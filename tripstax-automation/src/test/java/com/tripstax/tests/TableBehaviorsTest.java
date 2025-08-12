package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TableBehaviorsTest extends BaseTest {

    @Test(description = "Column sorting toggles", enabled = false)
    public void columnSorting() {
        throw new SkipException("Enable after mapping table headers");
    }

    @Test(description = "Global search filters rows", enabled = false)
    public void globalSearchFilters() {
        throw new SkipException("Enable after mapping search input");
    }

    @Test(description = "Pagination controls work", enabled = false)
    public void paginationControls() {
        throw new SkipException("Enable after mapping pagination controls");
    }
}