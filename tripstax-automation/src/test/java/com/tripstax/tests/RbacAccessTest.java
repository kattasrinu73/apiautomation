package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class RbacAccessTest extends BaseTest {

    @Test(description = "Viewer cannot access admin modules", enabled = false)
    public void viewerRestrictedModules() {
        throw new SkipException("Enable after creating role-based test users");
    }

    @Test(description = "Admin can access Users & Roles", enabled = false)
    public void adminAccessUsersRoles() {
        throw new SkipException("Enable after mapping admin module selectors");
    }
}