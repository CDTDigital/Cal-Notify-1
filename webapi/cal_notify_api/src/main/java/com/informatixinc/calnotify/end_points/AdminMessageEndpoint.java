package com.informatixinc.calnotify.end_points;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.informatixinc.calnotify.dao.AdminDao;
import com.informatixinc.calnotify.model.AdminMessage;
import com.informatixinc.calnotify.model.PutResponse;
import com.informatixinc.calnotify.utils.AuthMap;

@Path("/adminmessage")
public class AdminMessageEndpoint {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PutResponse sendMessage(AdminMessage message, @Context HttpServletRequest req){
		
		if(!AuthMap.isAdmin(req.getHeader("Authorization"))){
			PutResponse putResponse = new PutResponse();
			putResponse.getErrorResponse().setError(true);
			putResponse.getErrorResponse().setErrorMessage("Not authorized");
			return putResponse;
		}
		
		message.setSentBy(AuthMap.getUserName(req.getHeader("Authorization")));
		
		AdminDao adminDao = new AdminDao();
		return adminDao.addMessage(message);
	}
}