import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Employee {
	private String name;
	private int salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

}

public class ReverBySalary {
	public static void main(String[] args) 
	{
		List<Employee> empList = new ArrayList<>();
		Employee emp1 = new Employee("Dipa",55000);
		Employee emp2 = new Employee("Anu",56565);
		Employee emp3 = new Employee("Pinky",70500);

		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		List<Integer> empSal = empList.stream().map(s -> s.getSalary()).sorted(Comparator.reverseOrder()).toList();
		System.out.println(empSal);
	}
}
