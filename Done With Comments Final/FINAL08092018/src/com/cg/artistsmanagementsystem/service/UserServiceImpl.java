package com.cg.artistsmanagementsystem.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.SongBean;
import com.cg.artistsmanagementsystem.dao.DaoUserImpl;
import com.cg.artistsmanagementsystem.dao.IDaoUser;
import com.cg.artistsmanagementsystem.exception.UserException;

public class UserServiceImpl implements IUserService {
	IDaoUser userDao=null;
	/*******************************************************************************************************
	 - Function Name	:	searchComposerSongAssoc
	 - Input Parameters	:	int
	 - Return Type		:	ArrayList<SongBean> Object
	 - Throws			:  	UserException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	07/09/2018
	 - Description		:	Getting Songs Associated with Composer from the Database Table; Calls Dao method searchComposerSongAssoc(int composerId)
	 ********************************************************************************************************/
	@Override
	public ArrayList<SongBean> searchComposerSongAssoc(int composerId) throws UserException  {
		userDao=new DaoUserImpl();
		ArrayList<SongBean> list=userDao.searchComposerSongAssoc(composerId);
		return list;
	}
	/*******************************************************************************************************
	 - Function Name	:	searchArtistSongAssoc
	 - Input Parameters	:	int
	 - Return Type		:	ArrayList<SongBean> Object
	 - Throws			:  	UserException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	07/09/2018
	 - Description		:	Getting Songs Associated with Artist from the Database Table; Calls Dao method searchArtistSongAssoc(int composerId)
	 ********************************************************************************************************/

	@Override
	public ArrayList<SongBean> searchArtistSongAssoc(int artistId) throws UserException  {
		userDao=new DaoUserImpl();
		ArrayList<SongBean> list=userDao.searchArtistSongAssoc(artistId);
		return list;
}
	/*******************************************************************************************************
	 - Function Name	:	searchComposer
	 - Input Parameters	:	int id
	 - Return Type		:	ComposerBean object
	 - Throws			:  	UserException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	03/09/2018
	 - Description		:	Searching Composer in Database; Calls dao method searchComposer(int)
	 ********************************************************************************************************/
	@Override
	public ComposerBean searchComposer(int composerId) throws UserException {
		userDao=new DaoUserImpl();
		ComposerBean composer=userDao.searchComposer(composerId);	
		return composer;
	}
	/*******************************************************************************************************
	 - Function Name	:	searchArtist
	 - Input Parameters	:	int 
	 - Return Type		:	ArtistBean Object
	 - Throws			:  	UserException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	04/09/2018
	 - Description		:	Searching Artist in Database; Calls dao method searchArtist(int)
	 ********************************************************************************************************/	
	@Override
	public ArtistBean searchArtist(int artistId) throws UserException {
		userDao=new DaoUserImpl();
		ArtistBean artist=userDao.searchArtist(artistId);
		return artist;
	}
	/*******************************************************************************************************
	 - Function Name	:	getComposerList
	 - Input Parameters	:	-
	 - Return Type		:	ArrayList Object
	 - Throws			:  	UserException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	06/09/2018
	 - Description		:	Getting ComposerList from the Database Table; Calls Dao method getComposerList()
	 ********************************************************************************************************/
	
	@Override
	public ArrayList<Integer> getComposerList() throws UserException {
		userDao=new DaoUserImpl();
		ArrayList<Integer> composerList=userDao.getComposerList();	
		return composerList;
	}
	/*******************************************************************************************************
	 - Function Name	:	getArtistList
	 - Input Parameters	:	-
	 - Return Type		:	ArrayList Object
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	06/09/2018
	 - Description		:	Getting ArtistList from the Database Table; Calls Dao method getArtistList()
	 ********************************************************************************************************/
	
	@Override
	public ArrayList<Integer> getArtistList() throws UserException {
		userDao=new DaoUserImpl();
		ArrayList<Integer> artistList=userDao.getArtistList();	
		return artistList;
	}
	/*******************************************************************************************************
	 - Function Name	:	validateId
	 - Input Parameters	:	int number
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	07/09/2018
	 - Description		:	Validating the Id
	 ********************************************************************************************************/
	
	@Override
	public boolean validateId(int composerId) {
		if(composerId>0 && composerId<999999)
			return true;
		else 
			return false;
	}
	/*******************************************************************************************************
	 - Function Name	:	validateNumber
	 - Input Parameters	:	String number
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	07/09/2018
	 - Description		:	Validating the number
	 ********************************************************************************************************/
	
	@Override
	public boolean validateNumber(String validatenum) {
		Matcher match=null;
		Pattern patt=Pattern.compile("[0-9]{1,6}");    
		match=patt.matcher(validatenum);
		if(match.matches()==false){
			
			System.out.flush();
			System.err.println("Invalid Id! Maximum Length Must Be 6! Try Again");
			
		}
		return match.matches();
	}
	/*******************************************************************************************************
	 - Function Name	:	validateChoice
	 - Input Parameters	:	String choice
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	07/09/2018
	 - Description		:	Validating the Choices 
	 ********************************************************************************************************/
	
	@Override
	public boolean validateChoice(String choice) {
		Matcher match=null;
		Pattern patt=Pattern.compile("[1-5]");    
		match=patt.matcher(choice);
		if(match.matches()==false){
			
			System.out.flush();
			System.err.println("Invalid choice");
			
		}
		return match.matches();	}
}
