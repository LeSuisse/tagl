package it.sauronsoftware;

import it.sauronsoftware.cron4j.CronParser;
import it.sauronsoftware.cron4j.TaskTable;

import java.io.File;
import java.io.IOException;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CronParserTest {

    @BeforeClass
    public static void testSetup() {
    }

    @AfterClass
    public static void testCleanup() {
        // Teardown for data used by the unit tests
    }

    @Test(expected = IOException.class)
    public void testFileNotFound() throws IOException {
        File file = new File("notfound.file");
        CronParser.parse(file);
    }

    @Test
    public void parseTest() throws IOException {
        String line = "* * * * * test";
        TaskTable table = CronParser.parse(new ByteArrayInputStream(line.getBytes()));
        assertEquals(1, table.size());
    }
}