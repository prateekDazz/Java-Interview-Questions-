package javaInterview.question.serialization;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial {
	public static void main(String[] args) throws IOException {
		ObjectOutputStream ooj  = null;
		FileOutputStream fos  = null;
		try
		{
			Student s = new Student(1,"Prateek",12908);
			 fos =  new FileOutputStream("Tep.txt");
			
			 ooj =  new ObjectOutputStream(fos);
			
			ooj.writeObject(s);
			
			System.out.println("writong student datat to text file");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			ooj.close();
			fos.close();
			
		}
		
	}

}
