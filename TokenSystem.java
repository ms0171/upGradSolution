package upGrad;

import java.util.*;

public class TokenSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int events = sc.nextInt();
		TreeSet<Student> t = new TreeSet<Student>();
		while (events > 0) {
			String op = sc.next();
			if (op.equalsIgnoreCase("ENTER")) {
				String name = sc.next();
				double cgpa = sc.nextDouble();
				int token = sc.nextInt();
				t.add(new Student(token, name, cgpa));
			} else if (op.equalsIgnoreCase("SERVED")) {
				if (t.size() > 0) {
					Student s = t.first();
					t.remove(s);
				}
			}
			events--;
		}
		if (t.size() == 0) {
			System.out.println("EMPTY");
		}
		for (Student student : t) {
			System.out.println(student.getFname());
		}
		sc.close();
	}
}

class Student implements Comparable<Student> {
	private int token;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public int compareTo(Student s) {
		int out = 0;
		out = -1 * (new Double(cgpa)).compareTo(new Double(s.cgpa));
		if (out == 0) {
			out = fname.compareTo(s.fname);
			if (out == 0) {
				out = (new Integer(token).compareTo(new Integer(s.token)));
			}
		}
		return out;
	}
}