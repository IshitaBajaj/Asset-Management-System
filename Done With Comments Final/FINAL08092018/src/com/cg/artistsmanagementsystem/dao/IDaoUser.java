/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

import java.util.ArrayList;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.SongBean;
import com.cg.artistsmanagementsystem.exception.UserException;


/**
 * @author ibajaj
 *
 */
public interface IDaoUser {
	

	public abstract ArrayList<SongBean> searchArtistSongAssoc(int artistId) throws UserException;

	public abstract ArrayList<SongBean> searchComposerSongAssoc(int composerId) throws UserException;

	public abstract ComposerBean searchComposer(int composerId) throws UserException;

	public abstract ArtistBean searchArtist(int artistId) throws UserException;

	public abstract ArrayList<Integer> getComposerList() throws UserException;

	public abstract ArrayList<Integer> getArtistList() throws UserException;
}
