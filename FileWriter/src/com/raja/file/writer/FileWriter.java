package com.raja.file.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileWriter {

	public static void writeToFile(int input,String s)throws IOException {

		if(input>0) {
			//2 power(30)-1 = 1073741823
			String filePath = "C:\\Rajasekhar\\raja.txt";


			File file = new File(filePath);

			int bufferSize = 625000;//5 MB

			try (FileOutputStream fos = new FileOutputStream(file))
			{
				StringBuilder sb = new StringBuilder();
				long start = System.currentTimeMillis();
				for(int i=0; i<input; i++)
				{
					sb.append(s+ "\n");
					if(sb.toString().getBytes().length >= bufferSize)//flush output stream for every 5MB 
					{
						System.out.println("bytes size equal to buffer size="+sb.toString().getBytes().length);
						fos.write(sb.toString().getBytes());
						fos.flush();
						sb.setLength(0);
					}
				}
				if(sb.length() >0) {
					System.out.println("bytes size not equal to buffer size="+sb.toString().getBytes().length);
					fos.write(sb.toString().getBytes());
					fos.flush();
					sb.setLength(0);
				}
				long end = System.currentTimeMillis();
				long timeTaken = end - start;
				System.out.println("Time Taken to write a file in Milliseconds= "+ timeTaken);


			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in); 
		int input = sc.nextInt();
		final String s = "RajasekharRajasekharRajasekharRajasekharRajasekharRajasekharRajasekharRajasekharRajasekharRajasekha";
		//process file
		writeToFile(input,s);
		sc.close();
	}

}

