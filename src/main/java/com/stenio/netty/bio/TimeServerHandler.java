package com.stenio.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServerHandler implements Runnable {

	private Socket socket;

	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			String command = in.readLine();
			String response = "";
			if ("get".equals(command)) {
				response = sf.format(new Date());
				Thread.sleep(5000);
			} else {
				response = "error command";
			}
			out.println(response);
		} catch (IOException |

		InterruptedException e)

		{
			e.printStackTrace();
		} finally

		{
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}

				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
