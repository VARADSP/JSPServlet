package day7.assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Scanner;

/* Class PersistantEmpList contains methods to serialize employee data from hash table and deserialize it
 * @author: Varad Parlikar
 *  Created Date: 2019/06/26
 */
public class PersistantEmpList {
	/* method serialize is used to serialize the data
	 * @Hashtable<Integer,EmployeeDetail> it is a hash table for storing the EmployeeDetail objects containing employee specific data
	 * @String filename contains file name to be used for serialization
	 * return type : void
	 */
	static void serialize(Hashtable<Integer, EmployeeDetail> empTable, String filename) throws IOException {
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(file);
		// Method for serialization of object
		out.writeObject(empTable);
		out.close();
		file.close();
		System.out.println("Employee Table has been serialized");
	}

	/* method deserialize is used to deserialize the data
	 * @String filename contains file name to be used for serialization
	 * return type : Hashtable<Integer,EmployeeDetail>
	 */
	static Hashtable<Integer, EmployeeDetail> deSerialize(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		Hashtable<Integer, EmployeeDetail> empTable = (Hashtable<Integer, EmployeeDetail>) in.readObject();
		System.out.println("Employee Table has been deserialized");
		in.close();
		return empTable;
	}

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			Hashtable<Integer, EmployeeDetail> empTable = new Hashtable();
			int empCount = 1;
			String answer;
			do {
				System.out.println("Enter employee name ");
				String name = scanner.next();
				System.out.println("Enter employee age ");
				Integer age = scanner.nextInt();
				System.out.println("Enter employee salary ");
				Double salary = scanner.nextDouble();
				empTable.put(empCount++, new EmployeeDetail(name, age, salary));
				System.out.println("Want to add another employee (Y|N) ?");
				answer = scanner.next();
			} while (answer.equals("Y"));
			scanner.close();
			// Serializing the data
			System.out.println("Serializing the employee table");
			serialize(empTable, "file.ser");
			empTable.clear();

			System.out.println("Employee Table size : " + empTable.size());

			// deSerializing the data
			System.out.println("Deserializing the data");
			empTable = deSerialize("file.ser");

			for (EmployeeDetail e : empTable.values()) {
				System.out.println("Employee Name :" + e.name);
				System.out.println("Employee Age :" + e.age);
				System.out.println("Employee Salary :" + e.salary);
			}
		} catch (Exception e) {
			System.out.println("Invalid input entered");
			e.printStackTrace();
		}
	}
}