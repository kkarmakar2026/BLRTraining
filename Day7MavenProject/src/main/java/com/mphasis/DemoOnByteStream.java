package com.mphasis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoOnByteStream {

  public static void main(String[] args) throws Exception {
//        
//       
//        BufferedReader reader = new BufferedReader(new FileReader("assests/data.txt"));
//        String data;
//        while ((data = reader.readLine()) != null) {
//            System.out.println(data);
//        }
//        reader.close();  
//
//     
//        BufferedWriter writer = new BufferedWriter(new FileWriter("assests/data.txt"));
//        writer.write("This is modification with buffered writer");
//        writer.close();  
  
//	  FileOutputStream fos = new FileOutputStream("assests/info.txt");  
//	  String text = "Koushik Karmakar";
//	  fos.write(text.getBytes());
//	  fos.close();
//
//	  System.out.println("Data written successfully!");
//
//	  FileInputStream fis = new FileInputStream("assests/info.txt");   
//	  int b;
//	  while ((b = fis.read()) != -1)
//	      System.out.println((char) b);
//
//	  
//	  byte[] arr = new byte[(int) new File("assests/info.txt").length()];  
//	  fis = new FileInputStream("assests/info.txt");  
//	  fis.read(arr);
//	  fis.close();
//
//	  System.out.println(new String(arr));
//	  
//	  Bottle b = new Bottle(1, "Cello", 700, "Blue");
//
//	// Corrected path spelling
//	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("assests/bottleinfo.txt"));
//	oos.writeObject(b);
//	oos.close();
	  
	  Bottle b = new Bottle(1, "Cello", 700, "Blue");
	  ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("assests/bottleinfo.txt"));
	  oos.writeObject(b);
	  oos.close();

	  ObjectInputStream ois = new ObjectInputStream(new FileInputStream("assests/bottleinfo.txt"));
	  Bottle obj = (Bottle) ois.readObject();
	  ois.close();

	  System.out.println(obj);

	  
	  

  }
}
