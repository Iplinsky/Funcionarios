package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Entre com a quantidade de funcionários: ");
		int f = sc.nextInt();
		
		for (int i=1; i<=f; i++) {
			
			System.out.println("Funionário #" + i + ": " );
			System.out.print("Terceirizado (s/n)? ");
			char t = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Horas: ");
			int hours = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			if (t == 's') {
				System.out.print("Taxa adicional: ");
				double additionalCharge = sc.nextDouble();
					list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				list.add(new Employee(name, hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Pagamento: ");
		System.out.println();
		
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - R$ " + String.format("%.2f", emp.payment()));
		}		

		sc.close();
	}

}
