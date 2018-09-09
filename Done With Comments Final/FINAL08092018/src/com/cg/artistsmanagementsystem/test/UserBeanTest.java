/**
 * 
 */
package com.cg.artistsmanagementsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.artistsmanagementsystem.bean.UserBean;

/**
 * @author ibajaj
 *
 */
public class UserBeanTest {

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.UserBean#getUserId()}.
	 */
	@Test
	public void testGetUserId() {
		UserBean user=new UserBean();
		user.setUserId(1);
		assertEquals(1,user.getUserId());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.UserBean#getUserPwd()}.
	 */
	@Test
	public void testGetUserPwd() {
		UserBean user=new UserBean();
		user.setUserPwd("Password");
		assertEquals("Password",user.getUserPwd());
	}

}
