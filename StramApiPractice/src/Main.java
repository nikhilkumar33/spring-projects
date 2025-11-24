final class Employee1 {
	final private int id;
	final private StringBuffer name;

	public Employee1(int id, StringBuffer stringBuffer) {
		super();
		this.id = id;
		this.name = stringBuffer;
	}
	public int getId() {
		return id;
	}
	public StringBuffer getName() {
		return name;
	}
}

public class Main {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("Nikhil");

		Employee1 emp = new Employee1(11, sb);

		System.out.println(emp.getId() + " " + emp.getName());

		sb.append("Jena");
		System.out.println(emp.getId() + " " + emp.getName());

	}
}
