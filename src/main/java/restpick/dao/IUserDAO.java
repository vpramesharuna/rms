package restpick.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import restpick.entities.User;

@Repository
@Transactional
public interface IUserDAO {
	
	public List<User> getUserDetaiks(int restId, String userId);
		
}
