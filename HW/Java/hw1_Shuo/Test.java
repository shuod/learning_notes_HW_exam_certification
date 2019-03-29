public class Test {
	public static void main(String[] args) throws Exception{

		ArrayList<Employee> list = new ArrayList<Employee>();

		list.add(new Employee("Shuo",22));
		list.add(new Employee("Naveen",21));
		list.add(new Employee("Shyme",23));

		// sort using Comparator
		Collections.sort(list,new MyComparator());     

		//output the result
		for (int i = 0; i < list.size(); i++) {
			Employee e = list.get[i];
			System.out.println(e);
		}
	}
}