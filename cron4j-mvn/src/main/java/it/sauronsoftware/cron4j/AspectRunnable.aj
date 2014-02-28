package it.sauronsoftware.cron4j;

public aspect AspectRunnable {
	before() : execution(public void execute(TaskExecutionContext)) {
		System.out.println("Before execute in TaskRunnable");
	}

	after() : execution(public void execute(TaskExecutionContext)) {
		System.out.println("After execute in TaskRunnable");
	}
}