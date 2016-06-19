package com.stenio.netty.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeHandlerExecutePool {

	private ExecutorService executor;

	public TimeHandlerExecutePool(int maxPoolSize, int queueSize) {
		executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
	}

	public void execute(Runnable task) {
		executor.execute(task);
	}

}
