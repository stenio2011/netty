package com.stenio.netty.nio;

public class TimeClient {
	public static void main(String[] args) {
		new Thread(new TimeClientHandler("127.0.0.1", 90)).start();
	}
}
