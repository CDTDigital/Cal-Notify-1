package com.informatixinc.calnotify.end_points;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.informatixinc.calnotify.dao.NotificationDao;
import com.informatixinc.calnotify.model.Notification;
import com.informatixinc.calnotify.model.Session;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = { "getusernotifications" })
@Path("/getusernotifications")
public class GetUserNotifications {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get notifications specific to a particular user")
	public ArrayList<Notification> getUserNotifications(
			@ApiParam(value = "Object holding user session data", required = true) Session session) {
		NotificationDao notificationDao = new NotificationDao();
		return notificationDao.getUserNotifications(session);
	}

}
