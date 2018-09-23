package restpick.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import restpick.dao.IUserDAO;
import restpick.entities.User;

@RestController
@RequestMapping("/user")
@Api(value="" ,description="Restaurant Picker - User Service" , consumes="application/json")
public class UserController {

		@Autowired
		IUserDAO iuserDao;
		
		@ApiOperation(value = "Get User Details based on the passed User Id and restaurant Id, if passed the -1 it will return all the users list ", response = Iterable.class)
		@ApiResponses(value = {
		        @ApiResponse(code = 200, message = "Successfully values added to database and return value successfully"),
		        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		}
		)
			
	    @RequestMapping(value = "getUserDetails",method = RequestMethod.GET)
	    public List<User> add(@ApiParam(name="restaurantId" , value="Restaruant Id" ) @PathParam("restaurantId") Integer restaurantId,
	    		@ApiParam(name="userId" , value="UserId" ) @PathParam("userId") String userId) {
	        return   iuserDao.getUserDetaiks(restaurantId, userId);
	    }

}
