/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class DaoAdminImpl implements IDaoAdmin{
	Connection con=null;
	boolean status;
	String adminPwd;
	
	@Override
	public String login(UserBean user) throws AdminException {
		String type="F";
		try{
			
		con=DBUtil.getConnection();
		status=false;
		PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.LOGIN);
		preparedStatement.setInt(1,user.getUserId());
		preparedStatement.setString(2,user.getUserPwd());
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next())
		{	
			type=resultSet.getString(1);
		}
			
		}
		catch(NullPointerException e)
		{	
			throw new AdminException(e+"Error in Logging In!\nPlease Try Again! ");
			
		}catch(ClassNotFoundException e)
		{	
			throw new AdminException(e+"Error in Logging In!\nPlease Try Again! ");
			
		}
		catch(SQLException e)
		{	
			throw new AdminException(e+"Error in Logging In!\nPlease Try Again! ");
			
		}
		return type;
	}

	@Override
	public ComposerBean searchComposer(int composerId) throws AdminException {
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
				throw new AdminException("Unable to Search Composer!");
			}
		return composer;
		
	}

	@Override
	public int addComposer(ComposerBean composer, UserBean admin) throws AdminException {
		int id=-1;;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.ADD_COMPOSER);
			preparedStatement.setString(1,composer.getComposerName());
			preparedStatement.setString(2,composer.getComposerBornDate());
			preparedStatement.setString(3, composer.getComposerDiedDate());
			preparedStatement.setString(4, composer.getComposerDiedDate());
			preparedStatement.setString(5,composer.getComposerCaeipiNumber());
			preparedStatement.setString(6,composer.getComposerMusicSocietyID());
			preparedStatement.setInt(7, admin.getUserId());
			preparedStatement.setInt(8, admin.getUserId());
			preparedStatement.setString(9,"F");
			
			int i=preparedStatement.executeUpdate();
			if(i==1)
			{
				PreparedStatement pstmt=con.prepareStatement(IQueryMapper.SELECT_COMPOSER_ID);
				ResultSet resultSet=pstmt.executeQuery();
				resultSet.next();
				id=resultSet.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Composer Could Not Be Added!");
		}
		return id;
	}

	@Override
	public ArtistBean searchArtist(int artistId) throws AdminException {
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
			System.out.println(e);
			throw new AdminException("Unable to Search Artist!!!");
		}
		return artist;
	}

	@Override
	public int addArtist(ArtistBean artist, UserBean admin) throws AdminException {
		int id=-1;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.ADD_ARTIST);
			preparedStatement.setString(1,artist.getArtistName());
			preparedStatement.setString(2, artist.getArtistType());
			preparedStatement.setString(3,artist.getArtistBornDate());
			preparedStatement.setString(4,artist.getArtistDiedDate());
			preparedStatement.setString(5,artist.getArtistDiedDate());
			preparedStatement.setInt(6, admin.getUserId());
			preparedStatement.setInt(7, admin.getUserId());
			preparedStatement.setString(8,"F");
			int i=preparedStatement.executeUpdate();
			
			if(i==1)
			{
				PreparedStatement pstmt=con.prepareStatement(IQueryMapper.SELECT_ARTIST_ID);
				ResultSet resultSet=pstmt.executeQuery();
				resultSet.next();
				id=resultSet.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new AdminException("Artist Could Not Be Added!");
		}
		return id;
	}

	@Override
	public boolean updateComposerName(ComposerBean composer, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_COMPOSER_NAME);
			preparedStatement.setString(1,composer.getComposerName());
			preparedStatement.setInt(2,admin.getUserId());
			preparedStatement.setInt(3,composer.getComposerId());
			
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
		}
		return status;
	}

	@Override
	public boolean updateComposerBornDate(ComposerBean composer, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_COMPOSER_BORNDATE);
			preparedStatement.setString(1,composer.getComposerBornDate());
			preparedStatement.setInt(2, admin.getUserId());
			preparedStatement.setInt(3, composer.getComposerId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
			
		}
		return status;
	}

	@Override
	public boolean updateComposerDiedDate(ComposerBean composer, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_COMPOSER_DIEDDATE);
			preparedStatement.setString(1, composer.getComposerDiedDate());
			preparedStatement.setString(2, composer.getComposerDiedDate());
			preparedStatement.setInt(3, admin.getUserId());
			preparedStatement.setInt(4, composer.getComposerId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
		}
		return status;
	}

	@Override
	public boolean updateComposerCaeipiNumber(ComposerBean composer,
			UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_COMPOSER_CAEIPINUMBER);
			preparedStatement.setString(1, composer.getComposerCaeipiNumber());
			preparedStatement.setInt(2, admin.getUserId());
			preparedStatement.setInt(3, composer.getComposerId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.print(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
		}
		return status;
	}

	@Override
	public boolean updateComposerMusicSocietyId(ComposerBean composer,
			UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_COMPOSER_MUSICSOCIETYID);
			preparedStatement.setString(1, composer.getComposerMusicSocietyID());
			preparedStatement.setInt(2, admin.getUserId());
			preparedStatement.setInt(3, composer.getComposerId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed");
		}
		return status;
	}

	@Override
	public boolean updateArtistName(ArtistBean artist, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_ARTIST_NAME);
			preparedStatement.setString(1, artist.getArtistName());
			preparedStatement.setInt(2, admin.getUserId());
			preparedStatement.setInt(3, artist.getArtistId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
		}
		return status;
	}

	@Override
	public boolean updateArtistType(ArtistBean artist, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_ARTIST_TYPE);
			preparedStatement.setString(1, artist.getArtistType());
			preparedStatement.setInt(2, admin.getUserId());
			preparedStatement.setInt(3, artist.getArtistId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
		}
		return status;
	}

	@Override
	public boolean updateArtistBornDate(ArtistBean artist, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_ARTIST_BORNDATE);
			preparedStatement.setString(1, artist.getArtistBornDate());
			preparedStatement.setInt(2, admin.getUserId());
			preparedStatement.setInt(3, artist.getArtistId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
		}
		return status;
	}

	@Override
	public boolean updateArtistDiedDate(ArtistBean artist, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.UPDATE_ARTIST_DIEDDATE);
			preparedStatement.setString(1, artist.getArtistDiedDate());
			preparedStatement.setString(2, artist.getArtistDiedDate());
			preparedStatement.setInt(3, admin.getUserId());
			preparedStatement.setInt(4, artist.getArtistId());
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Update Operation Could Not Be Completed!");
		}
		return status;
	}

	@Override
	public boolean searchSong(int songId) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.SEARCH_SONG);
			preparedStatement.setInt(1, songId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				status=true;
		}
		catch(Exception e)
		{
			throw new AdminException(e+"Song Not Found!");
		}
		return status;
	}

	@Override
	public boolean associateComposer(int composerId, int songId, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.ASSOSCIATE_SONG_COMPOSER);
			preparedStatement.setInt(1, composerId);
			preparedStatement.setInt(2, songId);
			preparedStatement.setInt(3, admin.getUserId());
			preparedStatement.setInt(4, admin.getUserId());
			
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException("Song Cannot Be Associated With Composer!");
		}
		return status;
	}

	@Override
	public boolean associateArtist(int artistId, int songId, UserBean admin) throws AdminException {
		status=false;
		try{
			con=DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(IQueryMapper.ASSOSCIATE_SONG_ARTIST);
			preparedStatement.setInt(1, artistId);
			preparedStatement.setInt(2, songId);
			preparedStatement.setInt(3, admin.getUserId());
			preparedStatement.setInt(4, admin.getUserId());
			
			int i=preparedStatement.executeUpdate();
			if(i==1)
				status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new AdminException(e.getMessage()+"\n Song Cannot Be Associated With Artist!");
		}
		return status;
	}

	@Override
	public ArrayList<Integer> getComposerList() throws AdminException {
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
			System.out.println(e);
			throw new AdminException(e.getMessage()+"\n No Composers Found!");
		}
		return composerList;
	}

	@Override
	public ArrayList<Integer> getArtistList() throws AdminException {
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
			System.out.println(e);
			throw new AdminException(e.getMessage()+"\n No Composers Found!");
		}
		return artistList;
	}

	
}
