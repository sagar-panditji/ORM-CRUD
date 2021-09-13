package harekrishna.LearnORM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Student.Student;
import Student.StudentCRUD;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        System.out.println( "Project is Running" );
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        StudentCRUD crud=context.getBean("StudentCRUD",StudentCRUD.class);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        /*  1 -> insert
         *  2 -> getone
         *  3 -> getAll
         *  4 -> update
         *  5 -> delete
         */
        while(true){
        	System.out.println("Enter Choice - ");
        	int choice = Integer.parseInt(br.readLine());
        	if(choice==1) {
        		int id=Integer.parseInt(br.readLine());
        		String name=br.readLine();
        		Student s=new Student(id,name);
                int result=crud.createStudent(s);
                System.out.println("insertSuccessOrNot "+result);
        	}
        	else if(choice==2) {
        		int id=Integer.parseInt(br.readLine());
        		Student s=crud.getStudent(id);
        		System.out.println(s);
        	}
        	else if(choice==3) {
        		List<Student> l=crud.getAllStudents();
        		System.out.println(l);
        	}
        	else if(choice==4) {
        		int id=Integer.parseInt(br.readLine());
        		crud.updateStudent(id);
        	}
        	else if(choice==5) {
        		int id=Integer.parseInt(br.readLine());
        		crud.deleteStudent(id);
        	}
        	else {
        		System.out.println("Invalid Choice = exit");
        		break;
        	}
        }
    }
}
