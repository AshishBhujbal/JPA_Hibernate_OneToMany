package hibernate_onetomany_uni.controller;

import java.util.ArrayList;
import java.util.List;

import hibernate_onetomany_uni.dao.CompanyDao;
import hibernate_onetomany_uni.dto.Company;
import hibernate_onetomany_uni.dto.Employee;

public class CompanyController {

	public static void main(String[] args) {

		
		CompanyDao dao = new CompanyDao();
		
//		Company company = new Company();
//		company.setName("XYZ PVT LTD");
//		company.setGst("RECG67087PHT");

//		Employee emp1 = new Employee();
//		emp1.setName("shubham shelke");
//		emp1.setAddress("Wagholi");
//		emp1.setPhone(2453678915l);// added l at last -> beacause long data type
//		
//		Employee emp2 = new Employee();
//		emp2.setName("Rajesh suraywanshi");
//		emp2.setAddress("Pune");
//		emp2.setPhone(7894561253l);
//		
//		Employee emp3 = new Employee();
//		emp3.setName("ashish bhujbal");
//		emp3.setAddress("solapur");
//		emp3.setPhone(2574986321l);
		
		// list of employee
//		List<Employee> list = new ArrayList<Employee>();
//		list.add(emp1);
//		list.add(emp2);
//		list.add(emp3);
//		
//		
//		company.setList(list);
	
//		dao.saveCompany(company);
		
		System.out.println(dao.getCompanyById(1));
		
	}

}
