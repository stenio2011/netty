package com.stenio.netty.bio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.stenio.netty.bio.TimeServerHandler;

public class TimeServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		TimeHandlerExecutePool executePool = new TimeHandlerExecutePool(50, 1000);
		try {
			server = new ServerSocket(90);
			while (true) {
				Socket socket = server.accept();
				executePool.execute(new TimeServerHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
