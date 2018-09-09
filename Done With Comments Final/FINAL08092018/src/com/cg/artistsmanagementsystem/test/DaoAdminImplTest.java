/**
 * 
 */
package com.cg.artistsmanagementsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.dao.DaoAdminImpl;
import com.cg.artistsmanagementsystem.dao.IDaoAdmin;
import com.cg.artistsmanagementsystem.exception.AdminException;

/**
 * @author ibajaj
 *
 */
public class DaoAdminImplTest {

	IDaoAdmin adminDao=new DaoAdminImpl();
	
	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#login(com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testLogin() throws AdminException {
		UserBean user=new UserBean(155201,"admin");
		assertEquals("A",adminDao.login(user));
		
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#searchComposer(int)}.
	 * @throws AdminException 
	 */
	@Test
	public void testSearchComposer() throws AdminException {
		int composerId=123456;
		assertEquals(null,adminDao.searchComposer(composerId));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#addComposer(com.cg.artistsmanagementsystem.bean.ComposerBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testAddComposer() throws AdminException {
		ComposerBean composer=new ComposerBean();
		composer.setComposerName("COMPOSER");
		composer.setComposerBornDate("02/06/1965");
		composer.setComposerDiedDate("09/01/2018");
		composer.setComposerCaeipiNumber("123456ABCD");
		composer.setComposerMusicSocietyID("100");
		
		UserBean admin=new UserBean(155201,"admin");
		assertNotEquals(-1,adminDao.addComposer(composer, admin));
		
		
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#searchArtist(int)}.
	 * @throws AdminException 
	 */
	@Test
	public void testSearchArtist() throws AdminException {
		int artistId=123456;
		assertEquals(null,adminDao.searchArtist(artistId));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#addArtist(com.cg.artistsmanagementsystem.bean.ArtistBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testAddArtist() throws AdminException {
		ArtistBean artist=new ArtistBean();
		artist.setArtistName("ARTIST");
		artist.setArtistBornDate("09/09/1965");
		artist.setArtistDiedDate("09/09/1999");
		artist.setArtistType("T");
		UserBean admin=new UserBean(155201,"admin");
		assertNotEquals(-1,adminDao.addArtist(artist, admin));
		
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateComposerName(com.cg.artistsmanagementsystem.bean.ComposerBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateComposerName() throws AdminException {
		ComposerBean composer=new ComposerBean();
		UserBean admin=new UserBean(155201,"admin");
		composer.setComposerId(1000);
		composer.setComposerName("composer");
		assertNotEquals(-1,adminDao.updateComposerName(composer, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateComposerBornDate(com.cg.artistsmanagementsystem.bean.ComposerBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateComposerBornDate() throws AdminException {
		ComposerBean composer=new ComposerBean();
		UserBean admin=new UserBean(155201,"admin");
		composer.setComposerBornDate("09/09/2000");
		assertNotEquals(-1,adminDao.updateComposerBornDate(composer, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateComposerDiedDate(com.cg.artistsmanagementsystem.bean.ComposerBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateComposerDiedDate() throws AdminException {
		ComposerBean composer=new ComposerBean();
		UserBean admin=new UserBean(155201,"admin");
		composer.setComposerDiedDate("09/09/2000");
		assertNotEquals(-1,adminDao.updateComposerDiedDate(composer, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateComposerCaeipiNumber(com.cg.artistsmanagementsystem.bean.ComposerBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateComposerCaeipiNumber() throws AdminException {
		ComposerBean composer=new ComposerBean();
		UserBean admin=new UserBean(155201,"admin");
		composer.setComposerCaeipiNumber("123456");
		assertNotEquals(-1,adminDao.updateComposerBornDate(composer, admin));	
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateComposerMusicSocietyId(com.cg.artistsmanagementsystem.bean.ComposerBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateComposerMusicSocietyId() throws AdminException {
		ComposerBean composer=new ComposerBean();
		UserBean admin=new UserBean(155201,"admin");
		composer.setComposerMusicSocietyID("000");
		assertNotEquals(-1,adminDao.updateComposerMusicSocietyId(composer, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateArtistName(com.cg.artistsmanagementsystem.bean.ArtistBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateArtistName() throws AdminException {
		ArtistBean artist=new ArtistBean();
		UserBean admin=new UserBean(155201,"admin");
		artist.setArtistName("artist");
		assertNotEquals(-1,adminDao.updateArtistBornDate(artist, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateArtistType(com.cg.artistsmanagementsystem.bean.ArtistBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateArtistType() throws AdminException {
		ArtistBean artist=new ArtistBean();
		UserBean admin=new UserBean(155201,"admin");
		artist.setArtistType("T");
		assertNotEquals(-1,adminDao.updateArtistType(artist, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateArtistBornDate(com.cg.artistsmanagementsystem.bean.ArtistBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateArtistBornDate() throws AdminException {
		ArtistBean artist=new ArtistBean();
		UserBean admin=new UserBean(155201,"admin");
		artist.setArtistBornDate("10/12/2000");
		assertNotEquals(-1,adminDao.updateArtistBornDate(artist, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#updateArtistDiedDate(com.cg.artistsmanagementsystem.bean.ArtistBean, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testUpdateArtistDiedDate() throws AdminException {
		ArtistBean artist=new ArtistBean();
		UserBean admin=new UserBean(155201,"admin");
		artist.setArtistDiedDate("10/12/2000");
		assertNotEquals(-1,adminDao.updateArtistDiedDate(artist, admin));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#searchSong(int)}.
	 * @throws AdminException 
	 */
	@Test
	public void testSearchSong() throws AdminException {
		
		assertNotEquals(-1,adminDao.searchSong(123456));
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#associateComposer(int, int, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testAssociateComposer() throws AdminException {
		int songId=123456;
		int composerId=123456;
		UserBean admin=new UserBean(155201,"admin");
		assertNotEquals(false,adminDao.associateComposer(composerId, songId, admin));
		
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.dao.DaoAdminImpl#associateArtist(int, int, com.cg.artistsmanagementsystem.bean.UserBean)}.
	 * @throws AdminException 
	 */
	@Test
	public void testAssociateArtist() throws AdminException {
		int songId=123456;
		int artistId=123456;
		UserBean admin=new UserBean(155201,"admin");
		assertNotEquals(false,adminDao.associateArtist(artistId, songId, admin));
	}

}
