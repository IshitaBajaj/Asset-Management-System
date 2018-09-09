/**
 * 
 */
package com.cg.artistsmanagementsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.artistsmanagementsystem.bean.SongBean;

/**
 * @author ibajaj
 *
 */
public class SongBeanTest {

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.SongBean#getSongId()}.
	 */
	@Test
	public void testGetSongId() {
		SongBean song=new SongBean();
		song.setSongId(1);
		assertEquals(1,song.getSongId());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.SongBean#getSongName()}.
	 */
	@Test
	public void testGetSongName() {
		SongBean song=new SongBean();
		song.setSongName("SONG");
		assertEquals("SONG",song.getSongName());
	}

	/**
	 * Test method for {@link com.cg.artistsmanagementsystem.bean.SongBean#getSongDuration()}.
	 */
	@Test
	public void testGetSongDuration() {
		SongBean song=new SongBean();
		song.setSongDuration("06:50");
		assertEquals("06:50",song.getSongDuration());
	}

}
