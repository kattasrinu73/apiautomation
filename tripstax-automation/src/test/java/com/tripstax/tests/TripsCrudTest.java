package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TripsCrudTest extends BaseTest {

    @Test(description = "Create new record with required fields", enabled = false)
    public void createRecordRequired() {
        throw new SkipException("Enable after mapping create flow");
    }

    @Test(description = "Edit existing record and verify", enabled = false)
    public void editRecord() {
        throw new SkipException("Enable after mapping edit flow");
    }

    @Test(description = "Delete/archive record with confirm", enabled = false)
    public void deleteRecord() {
        throw new SkipException("Enable after mapping delete/archive flow");
    }
}