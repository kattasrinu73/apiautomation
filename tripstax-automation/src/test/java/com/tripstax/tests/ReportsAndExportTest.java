package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ReportsAndExportTest extends BaseTest {

    @Test(description = "Generate report with filters", enabled = false)
    public void generateReport() {
        throw new SkipException("Enable after mapping report form");
    }

    @Test(description = "Export data to CSV/XLSX/PDF", enabled = false)
    public void exportData() {
        throw new SkipException("Enable after mapping export buttons");
    }
}