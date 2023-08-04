package hibernate_onetomany_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_onetomany_uni.dto.Company;
import hibernate_onetomany_uni.dto.Employee;



public class CompanyDao {

	private  EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("ashish").createEntityManager();
	}

	public void saveCompany(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<Employee> list = company.getList();
		for (Employee employee : list) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();
		System.out.println("Saved successfully");
	}

	public void updateCompany(int id, Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Company receivedcompany = entityManager.find(Company.class, id);
		if (receivedcompany != null) {
			company.setId(id);
			company.setList(receivedcompany.getList());
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
			System.out.println("Update Successful");
		} else {
			System.out.println("The Company doesn't exist");
		}

	}

	public void deleteCompany(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Company company = entityManager.find(Company.class, id);

		entityTransaction.begin();
		entityManager.remove(company);
		entityTransaction.commit();
		System.out.println("Delete Successful");
	}

	public Company getCompanyById(int id) {
		EntityManager entityManager = getEntityManager();
		Company company = entityManager.find(Company.class, id);
		return company;
	}

	public List<Company> getAllCompany() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT c FROM Company c");
		List<Company> list = query.getResultList();
		return list;
	}

}