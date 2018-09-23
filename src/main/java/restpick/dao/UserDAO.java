package restpick.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import restpick.entities.User;

@Repository
@Transactional
public class UserDAO implements IUserDAO  {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EntityManager entityManager;
	
	 public String insert(User user) {
		  entityManager.persist(user);
		  return user.getUserId();
		 }
	 @Override
	 @SuppressWarnings("unchecked")
	 public List<User> getUserDetaiks(int restId, String userId) {
		 TypedQuery<User> query = (TypedQuery<User>) entityManager.createNativeQuery("SELECT c FROM User c where userId='"+userId+"' and restaurant_Id="+restId, User.class);
			  List<User> results = query.getResultList();
	  return results;
	 }
	 
	 public List<User> findAll() {
	  TypedQuery<User> query = entityManager.createNamedQuery("query_find_all_user", User.class);
	  return query.getResultList();
	 }
}
