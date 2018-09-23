package restpick.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restpick.entities.CalHistory;

@Repository
@Transactional
public class BasicDAO {
	@Autowired
	EntityManager entityManager;

	public void saveCalc(int a, int b, int sum) {
		
		entityManager.persist(new CalHistory(a, b, sum));
	}

	


	
}
