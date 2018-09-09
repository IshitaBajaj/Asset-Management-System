package com.cg.artistsmanagementsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;

public class ComposerBeanTest {

	@Test
	public void testGetComposerId() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerId(1);
		assertEquals(1,composer.getComposerId());
	}

	@Test
	public void testGetComposerName() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerName("COMPOSER");
		assertEquals("COMPOSER",composer.getComposerName());
	}

	@Test
	public void testGetComposerBornDate() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerBornDate("12/12/2009");
		assertEquals("12/12/2009",composer.getComposerBornDate());
	}

	@Test
	public void testGetComposerDiedDate() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerDiedDate("09/09/2009");
		assertEquals("09/09/2009",composer.getComposerDiedDate());
	}

	@Test
	public void testGetComposerCaeipiNumber() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerCaeipiNumber("123456ABCD");
		assertEquals("123456ABCD",composer.getComposerCaeipiNumber());
	}

	@Test
	public void testGetComposerMusicSocietyID() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerMusicSocietyID("100");
		assertEquals("100",composer.getComposerMusicSocietyID());
	}

	@Test
	public void testGetCreatedBy() {
		ArtistBean artist=new ArtistBean();
		artist.setCreatedBy(155201);
		assertEquals(155201,artist.getCreatedBy());
	}

	@Test
	public void testGetCreatedOn() {
		ComposerBean composer=new ComposerBean();
		composer.setCreatedOn("01/01/2002");
		assertEquals("01/01/2002",composer.getCreatedOn());
	}

	@Test
	public void testGetUpdatedBy() {
		ComposerBean composer=new ComposerBean();
		composer.setUpdatedBy(155203);
		assertEquals(155203,composer.getUpdatedBy());
	}

	@Test
	public void testGetUpdatedOn() {
		ComposerBean composer=new ComposerBean();
		composer.setUpdatedOn("01/01/2001");
		assertEquals("01/01/2001",composer.getUpdatedOn());
	}

	@Test
	public void testGetComposerDeletedFlag() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerDeletedFlag('F');
		assertEquals('F',composer.getComposerDeletedFlag());
	}

	@Test
	public void testGetComposerMusicSociety() {
		ComposerBean composer=new ComposerBean();
		composer.setComposerMusicSociety("ABC");
		assertEquals("ABC",composer.getComposerMusicSociety());
	}

}
