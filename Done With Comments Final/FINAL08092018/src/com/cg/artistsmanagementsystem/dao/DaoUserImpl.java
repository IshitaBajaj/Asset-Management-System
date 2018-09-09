/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

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
public class DaoUserImpl implements IDaoUser{
	public static Logger logger=Logger.getRootLogger();
	Connection con=null;
	boolean status;
	String userPwd;
	
	@Override
	public ComposerBean searchComposer(int composerId) throws UserException {
		ComposerBean composer=null;
		try{
			
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.COMPOSER_SEARCH);
			preparedStatement.setInt(1,composerId);
			ResultSet rs=preparedStatement.executeQuery();
			//System.out.println(rs.next());
			if(rs.next())
			{
				composer=new ComposerBean();
				composer.setComposerId(rs.getInt(1));
				composer.setComposerName(rs.getString(2));
				composer.setComposerBornDate(rs.getString(3));
				if(rs.getString(4)==null)
					composer.setComposerDiedDate("------------");
				else
					composer.setComposerDiedDate(rs.getString(4));
				composer.setComposerCaeipiNumber(rs.getString(5));
				composer.setComposerMusicSocietyID(rs.getString(6));
				composer.setCreatedBy(rs.getInt(7));
				composer.setCreatedOn(rs.getString(8));
				composer.setUpdatedBy(rs.getInt(9));
				composer.setUpdatedOn(rs.getString(10));
				composer.setComposerMusicSociety(rs.getString(11));
				
			}
			}
			catch(Exception e)
			{	System.out.println(e);
				logger.error(e+"Unable to search Composer!");
				throw new UserException("Unable to Search Composer!");
			}
		return composer;

	}
	@Override
	public ArtistBean searchArtist(int artistId) throws UserException {
		ArtistBean artist=null;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.ARTIST_SEARCH);
			preparedStatement.setInt(1,artistId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{	artist=new ArtistBean();
				artist.setArtistId(resultSet.getInt(1));
				artist.setArtistName(resultSet.getString(2));
				artist.setArtistType(resultSet.getString(3));
				artist.setArtistBornDate(resultSet.getString(4));
				if(resultSet.getString(5)==null)
					artist.setArtistDiedDate("---------------");
				else
					artist.setArtistDiedDate(resultSet.getString(5));
				artist.setCreatedBy(resultSet.getInt(6));
				artist.setCreatedOn(resultSet.getString(7));
				artist.setUpdatedBy(resultSet.getInt(8));
				artist.setUpdatedOn(resultSet.getString(9));
			}
		}
		catch(Exception e)
		{
			logger.error(e+"Unable to Search Artist!!!");
			throw new UserException(e+"Unable to Search Artist!!!");
		}
		return artist;
	}
	@Override
	public ArrayList<SongBean> searchComposerSongAssoc(int composerId) throws UserException {
		ArrayList<SongBean> list=new ArrayList<>();
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.SEARCH_COMPOSER_SONGASSOC);
			preparedStatement.setInt(1, composerId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				SongBean song=new SongBean();
				song.setSongId(resultSet.getInt(1));
				song.setSongName(resultSet.getString(2));
				song.setSongDuration(resultSet.getString(3));
				list.add(song);
			}
		}
		catch(Exception e)
		{
			logger.error(e+"Song Not Found!");
			throw new UserException(e+"\n Song Not Found!");
		}
		return list;
	}

	@Override
	public ArrayList<SongBean> searchArtistSongAssoc(int artistId) throws UserException {
		ArrayList<SongBean> list=new ArrayList<>();
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.SEARCH_ARTIST_SONGASSOC);
			preparedStatement.setInt(1, artistId);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				SongBean song=new SongBean();
				song.setSongId(resultSet.getInt(1));
				song.setSongName(resultSet.getString(2));
				song.setSongDuration(resultSet.getString(3));
				list.add(song);
			}
		}
		catch(Exception e)
		{
			logger.error(e+"\nSong Not Found!");
			throw new UserException(e+"\n Song Not Found!");
		}
		return list;
	}
	@Override
	public ArrayList<Integer> getComposerList() throws UserException {
		ArrayList<Integer> composerList=new ArrayList<>();
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.GET_COMPOSER_LIST);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				composerList.add(resultSet.getInt(1));
			}
		}
		catch(Exception e)
		{
			logger.error(e+"\n No Composers Found!");
			throw new UserException(e+"\n No Composers Found!");
		}
		return composerList;
	}
	@Override
	public ArrayList<Integer> getArtistList() throws UserException {
		ArrayList<Integer> artistList=new ArrayList<>();
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.GET_ARTIST_LIST);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				artistList.add(resultSet.getInt(1));
			}
		}
		catch(Exception e)
		{
			logger.error(e+"\n No Composers Found!");
			throw new UserException(e+"\n No Composers Found!");
		}
		return artistList;
	}

	

}
