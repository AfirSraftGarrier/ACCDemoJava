/**
 * 
 * ACCTestJava - ACC Java Test Platform
 * Copyright (c) 2014, AfirSraftGarrier, afirsraftgarrier@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package com.acc.demo.java.pre;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

public class ExecutorServiceTest {
	private static int BEGIN = 0;

	public static void excute(ExecutorService executorService, int excuteSize) {
		for (int i = 0; i < excuteSize; i++) {
			final int index = i;
			final int indexName = BEGIN + index;
			try {
				executorService.execute(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(100);
							System.out.println("success:" + indexName);
						} catch (InterruptedException interruptedException) {
							System.out.println("InterruptedException:"
									+ indexName);
						}
					}
				});
			} catch (RejectedExecutionException rejectedExecutionException) {
				System.out.println("RejectedExecutionException:" + indexName);
			}
		}
		BEGIN += excuteSize;
	}

	private static void shutdown(ExecutorService executorService) {
		System.out.println("shut down");
		executorService.shutdown();
	}

	private static void shutdownnow(ExecutorService executorService) {
		System.out.println("shut down now with rest size:"
				+ executorService.shutdownNow().size());
	}

	private static void test(ExecutorService executorService,
			boolean isShutdownnow, int size) {
		excute(executorService, size);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		if (isShutdownnow) {
			shutdownnow(executorService);
		} else {
			shutdown(executorService);
		}
		excute(executorService, 2);
	}

	private static void testShutdown(ExecutorService executorService, int size) {
		test(executorService, false, size);
	}

	private static void testShutdownnow(ExecutorService executorService,
			int size) {
		test(executorService, true, size);
	}

	public static void main(String[] args) {
		System.out.println("Please input your test number:");
		int testNum = new java.util.Scanner(System.in).nextInt();
		switch (testNum) {
		case 1:
			testShutdownnow(Executors.newSingleThreadExecutor(), 5);
			break;
		case 2:
			testShutdownnow(Executors.newSingleThreadExecutor(), 100);
			break;
		case 3:
			testShutdown(Executors.newSingleThreadExecutor(), 5);
			break;
		case 4:
			testShutdown(Executors.newSingleThreadExecutor(), 100);
			break;
		case 5:
			excute(Executors.newSingleThreadExecutor(), 100);
			break;
		case 6:
			testShutdownnow(Executors.newFixedThreadPool(3), 5);
			break;
		case 7:
			testShutdownnow(Executors.newFixedThreadPool(3), 100);
			break;
		case 8:
			testShutdown(Executors.newFixedThreadPool(3), 5);
			break;
		case 9:
			testShutdown(Executors.newFixedThreadPool(3), 100);
			break;
		case 10:
			excute(Executors.newFixedThreadPool(3), 100);
			break;
		case 11:
			testShutdownnow(Executors.newCachedThreadPool(), 5);
			break;
		case 12:
			testShutdownnow(Executors.newCachedThreadPool(), 1000);
			break;
		case 13:
			testShutdown(Executors.newCachedThreadPool(), 5);
			break;
		case 14:
			testShutdown(Executors.newCachedThreadPool(), 100);
			break;
		case 15:
			excute(Executors.newCachedThreadPool(), 100);
			break;
		case 16:
			excute(Executors.newCachedThreadPool(new ThreadFactory() {

				@Override
				public Thread newThread(Runnable r) {
					return new Thread(r);
				}
			}), 5);
			break;
		}
	}

}
