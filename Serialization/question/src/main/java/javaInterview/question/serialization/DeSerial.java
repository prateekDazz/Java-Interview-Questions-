package javaInterview.question.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerial {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("Tep.txt");
		ObjectInputStream ois  = new ObjectInputStream(fis);
		Student st = (Student) ois.readObject();
		System.out.println(st.toString());
	}

}
