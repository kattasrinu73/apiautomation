package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(description = "Dashboard loads with KPIs", enabled = false)
    public void dashboardKpisVisible() {
        throw new SkipException("Enable after mapping KPI widget selectors");
    }

    @Test(description = "Date filter updates widgets", enabled = false)
    public void dateFilterUpdatesWidgets() {
        throw new SkipException("Enable after mapping date picker + widget selectors");
    }
}