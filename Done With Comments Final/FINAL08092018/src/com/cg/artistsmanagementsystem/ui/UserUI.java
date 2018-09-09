package com.cg.artistsmanagementsystem.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.SongBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.exception.AdminException;
import com.cg.artistsmanagementsystem.exception.UserException;
import com.cg.artistsmanagementsystem.service.AdminServiceImpl;
import com.cg.artistsmanagementsystem.service.IAdminService;
import com.cg.artistsmanagementsystem.service.IUserService;
import com.cg.artistsmanagementsystem.service.UserServiceImpl;

/**
 * @author ibajaj
 *
 */
public class UserUI {
	public static Logger logger=Logger.getRootLogger();
	static IUserService userService=null;
    static Scanner scanner=null;
    ComposerBean composer=null;
    ArtistBean artist=null;
    UserBean admin=null;
    /*******************************************************************************************************
	 - Constructor 		:	UserUI
	 - Input Parameters	:	Default Constructor 
	 - Return Type		:	No Return Type
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Showing the User Menu to perform his tasks
	 ********************************************************************************************************/
  
	UserUI()
	{
		System.out.println("------------------------------USER MENU------------------------------");
    	System.out.println("1.Search Songs");
		System.out.println("2.Logout");
		System.out.println("3.Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("Enter choice: ");
	}

	public void userMenu() {
		int option;
		scanner=new Scanner(System.in);							
		try{
			
			option=scanner.nextInt();									//Getting the Input from User
			switch(option)												//Switch to call the  respective functions
			{
			/*
			 * Case 1 To Associate Songs With Composer or Artist
			 */
			case 1:	ArrayList<SongBean> list=new ArrayList<>();
					try
					{
						list=searchSong();			//seachSong function to check whether the Song exists in the database or not
						if(list!=null)
						{	
							if(list.isEmpty())
							{
								System.out.println("No Songs Associated With Given Id!");
								logger.info("No Associated Songs Found!");
							}
							else
							{
								Iterator<SongBean> itr=list.iterator();
								while(itr.hasNext())
								{
									SongBean song=(SongBean)itr.next();
									System.out.println(song);
								}
								logger.info("Associated Songs Found and Displayed!");
							}
						}
					}
					catch(UserException e)
					{
						System.err.println(e);
						logger.error(e);
					}
					System.err.flush();
					new UserUI().userMenu();
				break;
				/*
				 * Case 2 to return to the main menu
				 */
			case 2:	ClientUI.main(null);
				break;
				/*
				 * Case 3 to terminate the application
				 */
			case 3: System.out.println("Application Terminated!");
					logger.info("Application Terminated!");
					System.exit(0);			
				break;
				
			default:System.err.flush();
					System.err.println("Enter Valid Option!");
					new UserUI().userMenu();
			}
			
		}
		catch(InputMismatchException e)
		{
			System.err.println("Enter Valid Option!");
			new UserUI().userMenu();
		}
	}
	/*******************************************************************************************************
	 - Function Name	:	searchSong
	 - Input Parameters	:   -	
	 - Return Type		:	ArrayList
	 - Throws			:  	UserException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	03/09/2018
	 - Description		:	searching songs in database based on composer or artist
	 ********************************************************************************************************/
 
	public static ArrayList<SongBean> searchSong() throws UserException
	{	userService=new UserServiceImpl();
		String choice;
		/*
		 * Menu to check whether user wants songs based on Composer or Artist
		 * or wants to return to other menus
		 */
		ArrayList<SongBean> list=null;
		System.out.println("1.Search Songs Based on Composer");
		System.out.println("2.Search Songs Based on Artist");
		System.out.println("3.Return to Previous Menu");
		System.out.println("4.Logout");
		System.out.println("5.Exit");
		
		int ch=0;
		
			try
			{
				scanner.nextLine();
				do
				{
					System.out.print("Enter Choice: ");
					choice=scanner.nextLine();
				}while(!userService.validateChoice(choice));
				ch=Integer.parseInt(choice);
				//Switch case to check for choices of user
				switch(ch)
				{
				/*
				 * Case 1 To search Songsbased on Composer
				*/
				case 1:	System.out.println("------------Composer List:-------------- ");
							ArrayList<Integer> composerList=new ArrayList<>();
							composerList=userService.getComposerList();
							Iterator itr=composerList.iterator();
							while(itr.hasNext())
							{
								System.out.println(itr.next());
							}
							System.out.println("----------------------------------------");
							int composerId=0,flag=0;
							
							
							try
							{	String validatenum=null;
								do{
									System.out.print("Enter Composer Id: ");
									validatenum=scanner.nextLine();
								}while(!userService.validateNumber(validatenum));
								composerId=Integer.parseInt(validatenum);
								ComposerBean composer=userService.searchComposer(composerId);
								if(composer!=null)
								{	list=new ArrayList<>();
									list=userService.searchComposerSongAssoc(composerId);
								}else
								{
									System.out.println("Composer Does Not Exists!");
									logger.warn("Composer Not Found!");
								}
							}
							catch(UserException e)
							{
								System.err.println(e);
								logger.error(e);
							}			
							break;
							/*
							 * Case 2 To search Songs based on Artist
							*/		
				case 2:	System.out.println("-------------Artist List:---------------");
							ArrayList<Integer> artistList=new ArrayList<>();
							artistList=userService.getArtistList();
							Iterator it=artistList.iterator();
							while(it.hasNext())
							{
								System.out.println(it.next());
							}
							System.out.println("----------------------------------------");
							int artistId=0,check=0;
							
							try
							{	String validatenum=null;
								do{
									System.out.flush();
									System.out.print("Enter Artist Id: ");
									validatenum=scanner.nextLine();
								}while(!userService.validateNumber(validatenum));
								artistId=Integer.parseInt(validatenum);
								
								ArtistBean artist=userService.searchArtist(artistId);
								if(artist!=null)
								{
									list=new ArrayList<>();
									list=userService.searchArtistSongAssoc(artistId);
								}else
								{
									System.out.println("Artist Does Not Exists!");
									logger.warn("Artist Not Found!");
								}
																}
							catch(InputMismatchException e)
							{
								System.out.println("Id Should Be Numeric!(Max 10 Digits) Enter Again!");
							}
						break;
					/*
					 * Case 3 To return to user menu
					*/
					case 3:	new UserUI().userMenu();
							break;
					/*
					 * Case 4 To return to main menu
					*/
					case 4: ClientUI.main(null);
							break;
					/*
					 * Case 5 To terminate the application
					 * 					*/
					case 5: System.exit(0);
							break;
							
					default:System.out.flush();
							System.err.println("Please enter a valid option!");				
				}				//End of Switch
				
			}catch(Exception e)
			{
				System.err.println("Please enter a valid option!");
			}
			
				
		return list;			//End of Function Returning the list
		
	}
}
