import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable, Comparable, Cloneable {
	private double GPA;
	private String name;
	
	public Student(String n, double gpa) {
		name = n;
		GPA = gpa;
	}
	private Student(Student s) {
		this.GPA = s.GPA;
		this.name = s.name;
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		writeObjectToFile();
		Student z = readObjectFromFile();
		
		if(z != null) {
			System.out.println(z.toString());
		}
		Student a = new Student("bob", 1.0);
		Student b = new Student("rick", 1.5);
		Student c = new Student("morty", 2.0);
		Student d = new Student("jake", 2.5);
		Student e = new Student("steve", 3.0);
		Student f = new Student("jan", 3.5);
		Student g = new Student("william", 4.0);
		Student h = new Student("grace", 4.5);
		Student i = new Student("dave", 0.0);
		Student j = new Student("waluigi", 4.5);


		System.out.println( " a compareTo b :" + a.compareTo(b));
		System.out.println( " b compareTo a :" + b.compareTo(a));
		System.out.println( " b compareTo c :" + b.compareTo(c));
		System.out.println( " c compareTo g :" + c.compareTo(g));
		System.out.println( " h compareTo d :" + h.compareTo(d));
		System.out.println( " h compareTo j :" + h.compareTo(j));
		System.out.println( " e compareTo a :" + e.compareTo(a));
		System.out.println( " f compareTo j :" + f.compareTo(j));
		System.out.println( " g compareTo i :" + g.compareTo(i));
		System.out.println( " i compareTo g :" + i.compareTo(g));
	}

	private static Student readObjectFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.obj"));
		Student one = (Student) is.readObject();
	
		is.close();
		
		return one;
	}

	private static void writeObjectToFile() throws FileNotFoundException, IOException {
		Student nguyen = new Student("Nguyen", 3.5);

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.obj"));
		os.writeObject(nguyen);
			
		os.close();		
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setGPA(Double gpa) {
		if(gpa >= 0)
			GPA = gpa;
	}

	public double getGPA() {
		return GPA;
	}

	@Override
	public int compareTo(Object that) {
		if(that != null && that instanceof Student) {
			Student copy = (Student) that;
			if((int)(this.GPA - copy.GPA) == 0) {
				if(this.GPA - copy.GPA > 0)
					return 1;
				else if (this.GPA - copy.GPA < 0)
					return -1;
				else
					return 0;
			}
			return (int)(this.GPA - copy.GPA);
		}
		return 0;
	}

	@Override
	public Object clone() {
		return new Student(this);
	}

	public String toString() {
	    return "Name: " + name + "  GPA: " + GPA;
    }
}
