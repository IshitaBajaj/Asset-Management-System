/**
 * 
 */
package com.cg.artistsmanagementsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.artistsmanagementsystem.bean.ArtistBean;

/**
 * @author ibajaj
 *
 */
public class ArtistBeanTest {

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getArtistId()}.
	 */
	@Test
	public void testGetArtistId() {
		ArtistBean artist=new ArtistBean();
		artist.setArtistId(1);
		assertEquals(1,artist.getArtistId());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getArtistName()}.
	 */
	@Test
	public void testGetArtistName() {
		ArtistBean artist=new ArtistBean();
		artist.setArtistName("ARTIST");
		assertEquals("ARTIST",artist.getArtistName());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getArtistType()}.
	 */
	@Test
	public void testGetArtistType() {
		ArtistBean artist=new ArtistBean();
		artist.setArtistType("A");
		assertEquals("A",artist.getArtistType());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getArtistBornDate()}.
	 */
	@Test
	public void testGetArtistBornDate() {
		ArtistBean artist=new ArtistBean();
		artist.setArtistBornDate("12/12/2009");
		assertEquals("12/12/2009",artist.getArtistBornDate());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getArtistDiedDate()}.
	 */
	@Test
	public void testGetArtistDiedDate() {
		ArtistBean artist=new ArtistBean();
		artist.setArtistDiedDate("09/09/2009");
		assertEquals("09/09/2009",artist.getArtistDiedDate());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getCreatedBy()}.
	 */
	@Test
	public void testGetCreatedBy() {
		ArtistBean artist=new ArtistBean();
		artist.setCreatedBy(155201);
		assertEquals(155201,artist.getCreatedBy());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getCreatedOn()}.
	 */
	@Test
	public void testGetCreatedOn() {
		ArtistBean artist=new ArtistBean();
		artist.setCreatedOn("09/09/2018");;
		assertEquals("09/09/2018",artist.getCreatedOn());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getUpdateBy()}.
	 */
	@Test
	public void testGetUpdateBy() {
		ArtistBean artist=new ArtistBean();
		artist.setUpdatedBy(155202);;
		assertEquals(155202,artist.getUpdateBy());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getUpdatedOn()}.
	 */
	@Test
	public void testGetUpdatedOn() {
		ArtistBean artist=new ArtistBean();
		artist.setUpdatedOn("09/12/2018");
		assertEquals("09/12/2018",artist.getUpdatedOn());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.ArtistBean#getArtistDeletedFlag()}.
	 */
	@Test
	public void testGetArtistDeletedFlag() {
		ArtistBean artist=new ArtistBean();
		artist.setArtistDeletedFlag('F');
		assertEquals('F',artist.getArtistDeletedFlag());
	}

}
