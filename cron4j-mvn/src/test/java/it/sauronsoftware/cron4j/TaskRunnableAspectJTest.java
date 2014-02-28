package it.sauronsoftware;

import it.sauronsoftware.cron4j.Scheduler;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class TaskRunnableAspectJTest {

    public class TaskExample implements Runnable {

        public void run() {
            System.out.println("Current system time: " + new Date());
            System.out.println("Another minute ticked away...");
        }

    }

    @BeforeClass
    public static void testSetup() {
    }

    @AfterClass
    public static void testCleanup() {
        // Teardown for data used by the unit tests
    }

    @Test
    public void aspectjTest() {
        // Prepares the task.
        TaskExample task = new TaskExample();
        // Creates the scheduler.
        Scheduler scheduler = new Scheduler();
        // Schedules the task, once every minute.
        scheduler.schedule("* * * * *", task);
        // Starts the scheduler.
        scheduler.start();
        // Stays alive for one minute
        try {
            Thread.sleep(1L * 60L * 1000L);
        } catch (InterruptedException e) {
            ;
        }
        // Stops the scheduler.
        scheduler.stop();
    }
}