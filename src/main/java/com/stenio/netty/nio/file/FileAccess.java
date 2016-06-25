package com.stenio.netty.nio.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileAccess {
	public static void main(String[] args) {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("E:/test.txt", "rw");
			FileChannel fc = file.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(48);

			int bytesRead = fc.read(buf);

			while (bytesRead != -1) {
				System.out.println("Read " + bytesRead);
				buf.flip();
				while (buf.hasRemaining()) {
					char ch = (char) buf.get();
					System.out.print(ch);
				}
				buf.clear();
				bytesRead = fc.read(buf);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
