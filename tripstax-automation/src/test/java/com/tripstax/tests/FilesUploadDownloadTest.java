package com.tripstax.tests;

import com.tripstax.base.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class FilesUploadDownloadTest extends BaseTest {

    @Test(description = "Download sample/export file and verify", enabled = false)
    public void downloadFile() {
        throw new SkipException("Enable after mapping download link/button");
    }

    @Test(description = "Upload a valid file and verify result", enabled = false)
    public void uploadValidFile() {
        throw new SkipException("Enable after mapping upload input and result selectors");
    }

    @Test(description = "Reject invalid file type", enabled = false)
    public void uploadInvalidFileType() {
        throw new SkipException("Enable after mapping validation message");
    }
}