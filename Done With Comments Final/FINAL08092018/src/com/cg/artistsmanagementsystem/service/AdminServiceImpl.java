package com.cg.artistsmanagementsystem.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.SongBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.dao.DaoAdminImpl;
import com.cg.artistsmanagementsystem.dao.DaoUserImpl;
import com.cg.artistsmanagementsystem.dao.IDaoAdmin;
import com.cg.artistsmanagementsystem.exception.AdminException;
import com.cg.artistsmanagementsystem.exception.UserException;

public class AdminServiceImpl implements IAdminService {
	IDaoAdmin adminDao=null;//Global Reference to IDaoAdmin Interface
	/*******************************************************************************************************
	 - Function Name	:	login
	 - Input Parameters	:	UserBean object
	 - Return Type		:	String type
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	0/09/2018
	 - Description		:	Validating User Whether an Admin or User; Calls dao method login(UserBean)
	 ********************************************************************************************************/
	@Override
	public String login(UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		String type=adminDao.login(admin);
		return type;
		
	}
	/*******************************************************************************************************
	 - Function Name	:	searchComposer
	 - Input Parameters	:	int id
	 - Return Type		:	ComposerBean object
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	03/09/2018
	 - Description		:	Searching Composer in Database; Calls dao method searchComposer(int)
	 ********************************************************************************************************/
	@Override
	public ComposerBean searchComposer(int composerId) throws AdminException {
		adminDao=new DaoAdminImpl();
		ComposerBean composer=adminDao.searchComposer(composerId);	
		return composer;
	}
	/*******************************************************************************************************
	 - Function Name	:	addComposer
	 - Input Parameters	:	ComposerBean object,UserBean object
	 - Return Type		:	int
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	0/09/2018
	 - Description		:	Searching Composer in Database; Calls dao method searchComposer(int)
	 ********************************************************************************************************/
	@Override
	public int addComposer(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		int id=adminDao.addComposer(composer,admin);
		return id;
	}
	/*******************************************************************************************************
	 - Function Name	:	validateName
	 - Input Parameters	:	String name
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Validating String to Contain only Alphabets and have Maximum Length as 50
	 ********************************************************************************************************/
	@Override
	public boolean validateName(String name) {
		Pattern p=Pattern.compile("[A-Za-z ]{1,50}");
		Matcher m=p.matcher(name);
		boolean status=m.matches();
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	validateDate
	 - Input Parameters	:	String date
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Validating String to be in proper dd/mm/yyyy format
	 ********************************************************************************************************/
	@Override
	public boolean validateDate(String bornDate) {
		boolean status=true;
		if("NA".equals(bornDate))
			return status;
		else
		{
			Pattern p=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
			Matcher m=p.matcher(bornDate);
			status=m.matches();
		}
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	validateCaeipiNumber
	 - Input Parameters	:	String number
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Validating String to Contain Numbers or Alphabets and have Maximum Length as 10
	 ********************************************************************************************************/
	@Override
	public boolean validateCaeipiNumber(String number) {
		Pattern p=Pattern.compile("[0-9A-Z]{1,10}");
		Matcher m=p.matcher(number);
		boolean status=m.matches();
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	searchArtist
	 - Input Parameters	:	int 
	 - Return Type		:	ArtistBean Object
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	04/09/2018
	 - Description		:	Searching Artist in Database; Calls dao method searchArtist(int)
	 ********************************************************************************************************/	
	@Override
	public ArtistBean searchArtist(int artistId) throws AdminException {
		adminDao=new DaoAdminImpl();
		ArtistBean artist=adminDao.searchArtist(artistId);
		return artist;
	}
	/*******************************************************************************************************
	 - Function Name	:	addArtist
	 - Input Parameters	:	ArtistBean object, UserBean object
	 - Return Type		:	int
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	04/09/2018
	 - Description		:	Adding Artist in Database; Calls dao method addArtist(ArtistBean object, UserBean object)
	 ********************************************************************************************************/	
	@Override
	public int addArtist(ArtistBean artist, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		int id=adminDao.addArtist(artist,admin);
		return id;
	}
	/*******************************************************************************************************
	 - Function Name	:	validateType
	 - Input Parameters	:	String type
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Validating String to Contain only Alphabets and have Maximum Length as 1
	 ********************************************************************************************************/

	@Override
	public boolean validateType(String type) {
		Pattern p=Pattern.compile("[a-zA-Z]");
		Matcher m=p.matcher(type);
		boolean status=m.matches();
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateComposerName
	 - Input Parameters	:	String number
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ComposerName; Calls Dao Method updateComposerName(ComposerBean composer,UserBean admin)
	 ********************************************************************************************************/

	@Override
	public boolean updateComposerName(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerName(composer,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateComposerBornDate
	 - Input Parameters	:	ComposerBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ComposerBornDate; Calls Dao Method updateComposerBornDate(ComposerBean composer,UserBean admin)
	 ********************************************************************************************************/

	@Override
	public boolean updateComposerBornDate(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerBornDate(composer,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateComposerDiedDate
	 - Input Parameters	:	ComposerBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ComposerDiedDate; Calls Dao Method updateComposerDiedDate(ComposerBean composer,UserBean admin)
	 ********************************************************************************************************/

	@Override
	public boolean updateComposerDiedDate(ComposerBean composer, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerDiedDate(composer,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateComposerCaeipiNumber
	 - Input Parameters	:	ComposerBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ComposerCaeipiNumber; Calls Dao Method updateComposerCaeipiNumber(ComposerBean composer,UserBean admin)
	 ********************************************************************************************************/

	@Override
	public boolean updateComposerCaeipiNumber(ComposerBean composer,
			UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerCaeipiNumber(composer,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateComposerMusicSocietyId
	 - Input Parameters	:	ComposerBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ComposerMusicSocietyId; Calls Dao Method updateComposerMusicSocietyId(ComposerBean composer,UserBean admin)
	 ********************************************************************************************************/
	@Override
	public boolean updateComposerMusicSocietyId(ComposerBean composer,
			UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateComposerMusicSocietyId(composer,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateArtistName
	 - Input Parameters	:	ArtistBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ArtistName; Calls Dao Method updateArtistName(ArtistBean artist,UserBean admin)
	 ********************************************************************************************************/
	
	@Override
	public boolean updateArtistName(ArtistBean artist, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateArtistName(artist,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateArtistType
	 - Input Parameters	:	ArtistBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ArtistType; Calls Dao Method updateArtistType(ArtistBean artist,UserBean admin)
	 ********************************************************************************************************/
	@Override
	public boolean updateArtistType(ArtistBean artist, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateArtistType(artist,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateArtistBornDate
	 - Input Parameters	:	ArtistBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ArtistBornDate; Calls Dao Method updateArtistBornDate(ArtistBean artist,UserBean admin)
	 ********************************************************************************************************/
	
	@Override
	public boolean updateArtistBornDate(ArtistBean artist, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateArtistBornDate(artist,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	updateArtistDiedDate
	 - Input Parameters	:	ArtistBean object, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Updating ArtistDiedDate; Calls Dao Method updateArtistDiedDate(ArtistBean artist,UserBean admin)
	 ********************************************************************************************************/
	
	@Override
	public boolean updateArtistDiedDate(ArtistBean artist, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.updateArtistDiedDate(artist,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	searchSong
	 - Input Parameters	:	int
	 - Return Type		:   boolean	
	 -Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Searching Song in the Database; Calls Dao Method searchSong(int)
	 ********************************************************************************************************/
	
	@Override
	public boolean searchSong(int songId) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.searchSong(songId);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	associateComposer
	 - Input Parameters	:	int composerId, int songId, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Associating Songs with Composer; Calls Dao Method associateComposer(int composerId,int songId,UserBean object)
	 ********************************************************************************************************/
	
	@Override
	public boolean associateComposer(int composerId, int songId, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.associateComposer(composerId,songId,admin);
		return status;
	}
	/*******************************************************************************************************
	 - Function Name	:	associateArtist
	 - Input Parameters	:	int ArtistId, int songId, UserBean Object
	 - Return Type		:	boolean
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	05/09/2018
	 - Description		:	Associating Songs with Artist; Calls Dao Method associateArtist(int artistId,int songId,UserBean object)
	 ********************************************************************************************************/
	
	@Override
	public boolean associateArtist(int artistId, int songId, UserBean admin) throws AdminException {
		adminDao=new DaoAdminImpl();
		boolean status=adminDao.associateArtist(artistId,songId,admin);
		return status;	
		}
	/*******************************************************************************************************
	 - Function Name	:	validateDates
	 - Input Parameters	:	String bornDate, String diedDate
	 - Return Type		:	int
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	06/09/2018
	 - Description		:	Validating BornDate and DiedDate
	 ********************************************************************************************************/
	@Override
	public int validateDates(String bornDate, String diedDate) {
		int check=0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String today=LocalDate.now().format(formatter);
		LocalDate t=LocalDate.parse(today, formatter);
		LocalDate d1=LocalDate.parse(bornDate, formatter);
		if((t.compareTo(d1))>0)
			if(diedDate!=null)
			{
				LocalDate d2=LocalDate.parse(diedDate, formatter);
				if(d2.compareTo(d1)>0)
				{
					check=0;
				}
			}
			else 
				check=1;
		
		return check;
	}
	/*******************************************************************************************************
	 - Function Name	:	validateMusicSociety
	 - Input Parameters	:	String societyId
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	06/09/2018
	 - Description		:	Validating SocietyId, It should be specified in the table
	 ********************************************************************************************************/
	
	@Override
	public boolean validateMusicSociety(String societyId) {
		if("000".equals(societyId)||"100".equals(societyId)||"101".equals(societyId))
			return true;
		else
			return false;
	}
	/*******************************************************************************************************
	 - Function Name	:	getComposerList
	 - Input Parameters	:	-
	 - Return Type		:	ArrayList Object
	 - Throws			:  	AdminException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	06/09/2018
	 - Description		:	Getting ComposerList from the Database Table; Calls Dao method getComposerList()
	 ********************************************************************************************************/
	
	@Override
	public ArrayList<Integer> getComposerList() throws AdminException {
		adminDao=new DaoAdminImpl();
		ArrayList<Integer> composerList=adminDao.getComposerList();	
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
	public ArrayList<Integer> getArtistList() throws AdminException {
		adminDao=new DaoAdminImpl();
		ArrayList<Integer> artistList=adminDao.getArtistList();	
		return artistList;
	}
	
	/*******************************************************************************************************
	 - Function Name	:	validateNumber
	 - Input Parameters	:	String number
	 - Return Type		:	boolean
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	07/09/2018
	 - Description		:	Validating the Choices 
	 ********************************************************************************************************/
	
public boolean validateNumber(String number) {
		
		Matcher match=null;
		Pattern patt=Pattern.compile("[0-9]{1,6}");    
		match=patt.matcher(number);
		if(match.matches()==false){
			
			System.out.flush();
			System.err.println("Invalid Id! Maximum Length Must Be 6! Enter Again");
			
		}
		return match.matches();
	}
}
