package com.cg.artistsmanagementsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.artistsmanagementsystem.dao.DaoUserImpl;
import com.cg.artistsmanagementsystem.dao.IDaoUser;
import com.cg.artistsmanagementsystem.exception.UserException;
	

public class DaoUserImplTest {
	IDaoUser userDao=new DaoUserImpl();
	@Test
	public void testSearchComposer() throws UserException {
		int composerId=123456;
		assertEquals(null,userDao.searchComposer(composerId));
	}

	@Test
	public void testSearchArtist() throws UserException {
		int artistId=123456;
		assertEquals(null,userDao.searchComposer(artistId));
	}

	

}
