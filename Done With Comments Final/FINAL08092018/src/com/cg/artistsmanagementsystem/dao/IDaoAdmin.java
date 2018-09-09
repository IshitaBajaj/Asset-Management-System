/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

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
public interface IDaoAdmin {
	public abstract String login(UserBean adminBean) throws AdminException;

	public abstract ComposerBean searchComposer(int composerId) throws AdminException;

	public abstract int addComposer(ComposerBean composer, UserBean admin) throws AdminException;

	public abstract ArtistBean searchArtist(int artistId) throws AdminException;

	public abstract int addArtist(ArtistBean artist, UserBean admin) throws AdminException;

	public abstract boolean updateComposerName(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerBornDate(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerDiedDate(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerCaeipiNumber(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateComposerMusicSocietyId(ComposerBean composer,
			UserBean admin) throws AdminException;

	public abstract boolean updateArtistName(ArtistBean artist, UserBean admin) throws AdminException;

	public abstract boolean updateArtistType(ArtistBean artist, UserBean admin) throws AdminException;

	public abstract boolean updateArtistBornDate(ArtistBean artist,
			UserBean admin) throws AdminException;

	public abstract boolean updateArtistDiedDate(ArtistBean artist,
			UserBean admin) throws AdminException;

	public abstract boolean searchSong(int songId) throws AdminException;

	public abstract boolean associateComposer(int composerId, int songId,
			UserBean admin) throws AdminException;

	public abstract boolean associateArtist(int artistId, int songId,
			UserBean admin) throws AdminException;

	public abstract ArrayList<Integer> getComposerList() throws AdminException;

	public abstract ArrayList<Integer> getArtistList() throws AdminException;


}
