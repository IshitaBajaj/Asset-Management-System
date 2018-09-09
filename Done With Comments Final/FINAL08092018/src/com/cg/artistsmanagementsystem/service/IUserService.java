/**
 * 
 */
package com.cg.artistsmanagementsystem.service;

import java.util.ArrayList;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.SongBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.exception.AdminException;
import com.cg.artistsmanagementsystem.exception.UserException;

/**
 * @author ibajaj
 *
 */
public interface IUserService {

	ArrayList<SongBean> searchComposerSongAssoc(int composerId) throws UserException;

	ComposerBean searchComposer(int composerId) throws UserException;

	ArtistBean searchArtist(int artistId) throws UserException;

	ArrayList<SongBean> searchArtistSongAssoc(int artistId) throws UserException;

	ArrayList<Integer> getComposerList() throws UserException;

	ArrayList<Integer> getArtistList() throws UserException;

	boolean validateId(int composerId);

	boolean validateNumber(String validatenum);

	boolean validateChoice(String choice);
	
	
}
