package Student;
import java.util.Scanner;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

@Transactional // iski madad se hum write operations bhi perfrom kr sakte hai
public class StudentCRUD {

	private HibernateTemplate ht;
	public HibernateTemplate getHt() {
		return ht;
	}
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	public Student getStudent(int sid) {
		Student s=this.ht.get(Student.class,sid);
		return s;
	}
	public List<Student> getAllStudents(){
		List<Student> l = this.ht.loadAll(Student.class);
		return l;
	}
	public int createStudent(Student s) {
		int result = (Integer) this.ht.save(s);
		return result;
	}
	public void updateStudent(int sid) {
		String name=new Scanner(System.in).next();
		Student s=this.ht.get(Student.class,sid);
		s.setName(name);
		this.ht.update(s);
	}
	
	public void deleteStudent(int sid) {
		Student s=this.ht.load(Student.class,sid);
		this.ht.delete(s);
	}
	
	
}
	
