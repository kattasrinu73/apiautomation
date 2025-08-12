package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SessionManagementTest extends BaseTest {

    @Test(description = "Session persists across refresh", enabled = false)
    public void sessionPersists() {
        throw new SkipException("Enable after mapping a user-specific marker");
    }

    @Test(description = "Session timeout and re-login flow", enabled = false)
    public void sessionTimeout() {
        throw new SkipException("Enable after deciding idle timeout strategy in tests");
    }
}