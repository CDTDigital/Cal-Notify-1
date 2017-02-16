package com.informatixinc.calnotify.end_points;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.informatixinc.calnotify.dao.DatabasePool;
import com.informatixinc.calnotify.model.Notification;
import com.informatixinc.calnotify.utils.DatabaseUtils;

public class NotificationTest {
	
	@Test
	public void notificaitonTest(){
		GetNotificationById getNotificationById = new GetNotificationById();
		Notification notification = getNotificationById.getNotifications(getLatestNotification());
		assert(notification.getTitle().length() > 0);
	}
	
	private int getLatestNotification(){
		Connection conn = DatabasePool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("select id from public.notification order by id desc limit 1");
			
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt("id");
			}else{
				throw new RuntimeException("No notifications to test with");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("SQL error statement is " + ps.toString());
		}finally{
			DatabaseUtils.safeClose(conn, ps, rs);
		}
	}

}