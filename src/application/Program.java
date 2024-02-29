package application;

import entities.Department;
import entities.Employee;
import entities.Address;

import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();

		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Telefone: ");
		String phone = sc.nextLine();

		Department dept = new Department(departmentName, payDay, new Address(email, phone));

		System.out.print("Quantos funcionários tem o departamento? ");
		int numEmployees = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= numEmployees; i++) {
			System.out.println("Dados do funcionário " + i + ":");
			System.out.print("Nome: ");
			String employeeName = sc.nextLine();

			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			sc.nextLine();

			dept.addEmployee(new Employee(employeeName, salary));
		}

		showReport(dept);

		sc.close();
	}

	private static void showReport(Department dept) {
		System.out.println("\nFOLHA DE PAGAMENTO:");
		System.out.println("Departamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()));
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários:");

		for (Employee employee : dept.getEmployees()) {
			System.out.println(employee.getName());
		}

		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}
}
