import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDAO;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("welcome to student mangement app");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		while(true) {
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Student");
			System.out.println("Press 4 to ShOW ALL Student");
			System.out.println("Press 5 to EXIT Student");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				
				System.out.println("Enter User Name : ");
				String name = br.readLine();
				System.out.println("Enter User Phone : ");
				String phone = br.readLine();
				System.out.println("Enter User City  : ");
				String city = br.readLine();
				
				Student st = new Student(name,phone,city);
				Boolean ansBoolean = StudentDAO.insertStudenttoDB(st);
				if(ansBoolean==true) {
					System.out.println("Query Executed Success");
				}else {
					System.out.println("Failure..");
				}

				
				
			}else if(c==2) {
				System.out.println("Enter Student ID");
				Integer idInteger = Integer.parseInt(br.readLine());
				Boolean ansBoolean = StudentDAO.deleteStudenttoDB(idInteger);
				if(ansBoolean==true) {
					System.out.println("Query Executed Success");
				}else {
					System.out.println("Failure..");
				}
			}else if(c==3) {
				System.out.println("Enter Student ID");
				Integer idInteger = Integer.parseInt(br.readLine());
				Boolean ansBoolean = StudentDAO.findStudentById(idInteger);
				if(ansBoolean==true) {
					System.out.println("Query Executed Success");
				}else {
					System.out.println("Failure..");
				}
			}else if(c==4) {
				Boolean ansBoolean = StudentDAO.showAllStudents();
				if(ansBoolean==true) {
					System.out.println("Query Executed Success");
				}else {
					System.out.println("Failure..");
				}
			}else if(c == 5){
				System.out.println("Exit..");
			}else {
				System.out.println("Please Enter valid input ");
			}
			
		}

	}

}
