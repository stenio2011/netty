package com.stenio.netty.nio;

public class TimeServer {
	public static void main(String[] args) {
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(90);
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
	}
}
