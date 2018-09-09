package com.cg.artistsmanagementsystem.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.apache.log4j.Logger;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.exception.AdminException;
import com.cg.artistsmanagementsystem.service.AdminServiceImpl;
import com.cg.artistsmanagementsystem.service.IAdminService;

public class AdminUI {
	public static Logger logger=Logger.getRootLogger();
	static IAdminService adminService=null;
    static Scanner scanner=null;
    ComposerBean composer=null;
    ArtistBean artist=null;
    UserBean admin=null;
    /*******************************************************************************************************
	 - Constructor 		:	AdminUI
	 - Input Parameters	:	Parameterized Constructor to save the Login Id of the Admin
	 - Return Type		:	No Return Type
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Showing the admin menu to perform his tasks
	 ********************************************************************************************************/
   
    AdminUI(UserBean admin)
    {	
    	this.admin=admin;
    	System.out.println("------------------------------ADMIN MENU------------------------------");
    	System.out.println("1.Search Composer");
		System.out.println("2.Add Composer");
		System.out.println("3.Edit Composer");
		System.out.println("4.Search Artist");
		System.out.println("5.Add Artist");
		System.out.println("6.Edit Artist");
		System.out.println("7.Assosciate Songs");
		System.out.println("8.Logout");
		System.out.println("9.Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("Enter choice: ");
    }
	public AdminUI() {
		//Default Constructor
	}
	/*******************************************************************************************************
	 - Function Name	:	adminMenu
	 - Input Parameters	:	No Parameters
	 - Return Type		:	void
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Getting input choice from user to perform specific function
	 ********************************************************************************************************/
	public void adminMenu() 
	{	int option;
		scanner=new Scanner(System.in);
		try
		{	
			option=scanner.nextInt();												//Getting choice from user
			switch(option)										//Start of Switch Statement
			{
			/*
			 * Case 1 To search the Composer
			 */
			case 1:	adminService=new AdminServiceImpl();
					scanner=new Scanner(System.in);
					
						try 
						{
							System.out.print("Enter Composer Id to be Searched:");
						String validatenum=null;
						
						do{
							
						validatenum=scanner.nextLine();
						}while(!adminService.validateNumber(validatenum));    //Validating the Composer Id should not be greater than 6 digits
						int composerId=Integer.parseInt(validatenum);
								
							composer=new ComposerBean();
							composer=adminService.searchComposer(composerId);
							if(composer!=null)
							{
								System.out.println(composer);
								logger.info("Composer Search Successful!");
							}
							else
								System.out.println("No Composer Found!!!");
						} 
						catch (AdminException e)
						{	System.err.flush();
							System.err.print(e);
							logger.error(e);
						}
						
					
					
					System.err.flush();
					new AdminUI(admin).adminMenu();
					break;
			/*
			 * Case 2 To add new Composer 
			 */
			case 2: adminService=new AdminServiceImpl();
					try 
				    {	
						composer=populateComposer();		//populate Composer Bean using static populateComposer function 
						
				    		if(composer!=null)
				    		{	
				    			int id=adminService.addComposer(composer,admin);
				    				if(id!=-1)
				    				{
				    					System.out.println("Composer Sucessfully Added With Id: "+id+"!");      //Printing the auto generated id for the new composer 
				    					logger.info("Composer Added!");
				    				}
				    				else
				    					System.out.println("Composer Not Added!");
				    		}		
				    } 
				    catch (AdminException e) 
				    {
							System.err.println(e);
							logger.error(e);
				    }
					
			        System.err.flush();
			        new AdminUI(admin).adminMenu();
				break;
				
				/*
				 * Case 3 To Update Artist Details
				 */
			case 3: updateComposer(admin);	//Update function to update the composer details
					System.err.flush();			
					new AdminUI(admin).adminMenu();
						
				break;
				/*
				 * Case 4 to search the Artist
				 */
			case 4:	adminService=new AdminServiceImpl();
					scanner=new Scanner(System.in);
					String validatenum=null;
					try{
						System.out.print("Enter the Artist Id to be Searched: ");
						do{
							
							validatenum=scanner.nextLine();
						}while(!adminService.validateNumber(validatenum));			//Validating artist id
						
						int artistId=Integer.parseInt(validatenum);
						artist=adminService.searchArtist(artistId);
								if(artist!=null)
								{
									System.out.println(artist);
									logger.info("Artist Search Successful!");
								}
								else
									System.out.println("No Artist Found!!!");
							} 
						catch (AdminException e)
						{
							System.err.println(e);
							logger.error(e);
						}
						
					System.err.flush();
					new AdminUI(admin).adminMenu();
				break;
				/*
				 * Case 5 to add new Artist
				 */
			case 5:	adminService=new AdminServiceImpl();
					try 
			        {		artist=populateArtist();
			        		if(artist!=null)
			        		{
			        			int id=adminService.addArtist(artist,admin);
			        			if(id!=-1)
			        			{
			        				System.out.println("Artist Sucessfully Added With Id: "+id+"!");		//Getting the auto generated id for the new artist added
			        				logger.info("Artist Search Successful!");
			        			}
			        			else
			        				System.out.println("Artist Not Added!");
			        		}
			        
			        }
			        catch (AdminException e) 
			        {
						System.err.println(e);
						logger.error(e);;
			        }
					
			        new AdminUI(admin).adminMenu();
						break;
				/*
				 * Case 6 to update Artist
				 */
			case 6: updateArtist(admin);
					new AdminUI(admin).adminMenu();
					break;
				/*
				 * Case 7 to Associate Songs with Composer or Artist 
				 */
			case 7:	associateSongs(admin);
						new AdminUI(admin).adminMenu();
						break;
				/*
				 * Case 8 to return to main menu
				 */
			case 8:	ClientUI.main(null);
					break;
				/*
				 * Case 9 to terminate the application
				 */
			case 9:	System.out.print("Application Terminated!");
					System.exit(0);
					break;
			default: System.err.flush();
					 System.err.println("Enter a valid option!");
					 new AdminUI(admin).adminMenu();;
			}										//End of Switch
		}
		catch(Exception e)
		{	System.err.flush();
			System.err.println("Enter a Valid Option!");
			logger.error(e);
			new AdminUI(admin).adminMenu();
		}
		
		
		
	}//End of adminMenu Function
	
	
	 /*******************************************************************************************************
	 - Function Name 	:	populateComposer
	 - Input Parameters	:	-
	 - Return Type		:	ComposerBean
	 - Throws			:  	IOException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Getting the Composer Details for the new Composer
	 ********************************************************************************************************/
  	
	public static ComposerBean populateComposer() throws IOException
	{	
		adminService=new AdminServiceImpl();
		scanner=new Scanner(System.in);
		ComposerBean composer=new ComposerBean();
		String name,number,societyId,bornDate,diedDate;
		int i=0;
		System.out.println("Enter the details of new composer:");
		do
		{
			System.out.print("Enter Composer Name(Max 50 Characters): ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			name = br.readLine();
			if(adminService.validateName(name))
				i=1;
			else
				System.out.println("Invalid Name! Enter Again!");
		}while(i!=1);
			
			composer.setComposerName(name);
			int check=0;
		do
		{
			i=0;
			do
			{
				System.out.print("Enter Composer Born Date(dd/mm/yyyy): ");
				bornDate=scanner.nextLine();
				if(adminService.validateDate(bornDate))
					i=1;
				else
					System.out.println("Invalid Date! Enter Again!");
			}while(i!=1);	
				i=0;	
				composer.setComposerBornDate(bornDate);
					
			do
			{
				System.out.print("Enter Died Date(dd/mm/yyyy)(NA if not Applicable): ");
				diedDate=scanner.nextLine();
				if(adminService.validateDate(diedDate))
					i=1;
				else
					System.out.println("Invalid Date! Enter Again!");
			}while(i!=1);	
				
						if("NA".equals(diedDate))
							diedDate=null;
					composer.setComposerDiedDate(diedDate);
					
				check=adminService.validateDates(bornDate,diedDate);
				if(check==0)
					System.out.println("Born Date Should Be Before Today's Date & Died Date Should Be After Born Date!\nEnter Again!");
					
		}while(check!=1);			
		i=0;
		do
		{
			System.out.print("Enter Composer Caeipi Number(Max 10 Digits):");
			number=scanner.nextLine();
			if(adminService.validateCaeipiNumber(number))
				i=1;
			else
				System.out.println("Invalid Caeipi Number! Enter Again!");
		}while(i!=1);
			
			composer.setComposerCaeipiNumber(number);
			i=0;
		do
		{
			System.out.print("Enter Music Society ID(100/101/000): ");
			societyId=scanner.nextLine();
			if(adminService.validateMusicSociety(societyId))
				i=1;
			else
				System.out.println("Invalid Society Id! Enter Again!");
		}while(i!=1);	
				
		composer.setComposerMusicSocietyID(societyId);
			
		
        return composer;
	}
	/*******************************************************************************************************
	 - Function Name 	:	populateArtist
	 - Input Parameters	:	-
	 - Return Type		:	ArtistBean
	 - Throws			:  	IOException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Getting the Artist Details for the new Artist
	 ********************************************************************************************************/
 	
	public static ArtistBean populateArtist() throws IOException
	{
		adminService=new AdminServiceImpl();
		scanner=new Scanner(System.in);
		ArtistBean artist=new ArtistBean();
		String artistName,type,bornDate,diedDate;
		int i=0;
		
		System.out.println("Enter the Details of New Artist:");
		
		do
		{	
			System.out.print("Enter Artist Name(Max 50 Characters): ");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			artistName = buffer.readLine();
			if(adminService.validateName(artistName))
				i=1;
			else
				System.out.println("Invalid Artist Name! Enter Again!");
		}while(i!=1);
		
			i=0;
			artist.setArtistName(artistName);
		
		do
		{	
        	System.out.print("Enter Artist Type(1 Character): ");
        	type=scanner.nextLine();
        	if(adminService.validateType(type.toUpperCase()))
        			i=1;
        	else
        		System.out.println("Invalid Type! Enter Again!");
		}while(i!=1);
        
				        artist.setArtistType(type);
	    
	        int check=0;
	     do
	     {	
	    	 i=0;

		     do
			 {
		    	System.out.print("Enter Artist Born Date(dd/mm/yyyy): ");
				bornDate=scanner.nextLine();
					if(adminService.validateDate(bornDate))
							i=1;
					else
						System.out.println("Invalid Date! Enter Again!");
			    }while(i!=1);
						
		     			i=0;
						
			
			do{
				System.out.print("Enter Died Date(dd/mm/yyyy)(NA if not Applicable): ");
				diedDate=scanner.nextLine();
				if(adminService.validateDate(diedDate))
						i=1;
				else
					System.out.println("Invalid Date! Enter Again!");
			}while(i!=1);
		
				if(diedDate.equals("NA"))
					diedDate=null;
				
			check=adminService.validateDates(bornDate,diedDate);
				if(check==0)
					System.out.println("Born Date Should Be Before Today's Date & Died Date Should Be After Born Date!\nEnter Again!");
				
				
	     }while(check!=1);		
	     
	    artist.setArtistBornDate(bornDate);
	    artist.setArtistDiedDate(diedDate);
		
	   
	    return artist;

	}
	/*******************************************************************************************************
	 - Function Name 	:	updateComposer
	 - Input Parameters	:	UserBean
	 - Return Type		:	void
	 - Throws			:  	IOException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Updating the Composer Details for the already existing Composer
	 ********************************************************************************************************/
	
	public static void updateComposer(UserBean admin) throws IOException
	{	adminService=new AdminServiceImpl();
		scanner=new Scanner(System.in);
		String composerName;
		ComposerBean composer=new ComposerBean();;
		int ch=0,flag=0;
		String bornDate,number,diedDate,societyId,choice;
		String validatenum=null;
		
		try 
		{	
			do
			{	
				System.out.print("Enter the Id of Composer:");
				validatenum=scanner.nextLine();
			}while(!adminService.validateNumber(validatenum));
				int id=Integer.parseInt(validatenum);
				
			composer=adminService.searchComposer(id);
		}	
		catch (AdminException e)
		{
			System.out.print(e);
		}
			
		
				
		if(composer!=null)
		{	flag=0;
			System.out.println("What do you want to update?");
			System.out.println("1.Composer Name\n2.Composer Born Date\n3.Composer Died Date");
			System.out.println("4.Composer Caeipi Number\n5.Composer Music Society\n6.Return to Previous Menu\n7.Exit");
			
				try
				{	
					do
					{
						System.out.print("Enter Choice: ");
						choice=scanner.nextLine();
						Pattern p=Pattern.compile("[1-7]");
						Matcher m=p.matcher(choice);
						if(m.matches())
							ch=Integer.parseInt(choice);
						else ch=0;
						switch(ch)
						{
						case 1: do{
									System.out.print("Enter new Composer name: ");
									BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
									composerName = buffer.readLine();
							        if(adminService.validateName(composerName))
							        	flag=1;
							        else
										System.out.println("Invalid Name! Enter Again!");
								}while(flag!=1);
						        flag=0;	
									composer.setComposerName(composerName);
						        	if(adminService.updateComposerName(composer,admin))
						        	{
						        		System.out.println("Composer Name Updated Successfully!");
						        		logger.info("Composer Name Updated Successfully!");
						        	}
						        	else
					        		System.out.println("Composer Name Not Updated!");
						      
						        	break;
						case 2: do{
									System.out.print("Enter New Composer Born Date(dd/mm/yyyy): ");
									bornDate=scanner.nextLine();
										if(adminService.validateDate(bornDate))
											flag=1;
										else
											System.out.println("Invalid Date! Enter Again!");
								}while(flag!=1);
								flag=0;
								composer.setComposerBornDate(bornDate);
								if(adminService.updateComposerBornDate(composer,admin))
								{
									System.out.println("Composer Born Date Updated Successfully!");
									logger.info("Composer Born Date Updated Successfully!");
								}
								else
									System.out.println("Composer Born Date Not Updated!");
								break;
						case 3:	do{
									System.out.print("Enter New Composer Died Date(dd/mm/yyyy)(NA if not applicable): ");
									diedDate=scanner.nextLine();
									if(adminService.validateDate(diedDate))
										flag=1;
									else
										System.out.println("Invalid Date! Enter Again!");
								}while(flag!=1);
								flag=0;
								if(diedDate.equals("NA"))
									diedDate=null;
								
								composer.setComposerDiedDate(diedDate);
								
								if(adminService.updateComposerDiedDate(composer,admin))
								{
									System.out.println("Composer Died Date Updated Successfully!");
									logger.info("Composer Died Date Updated Successfully!");
								}
								else
									System.out.println("Composer Died Date Not Updated!");
								break;
								
						case 4:	do{
									System.out.print("Enter New Composer Caepei Number: ");
									number=scanner.nextLine();
									if(adminService.validateCaeipiNumber(number))
										flag=1;
									else
										System.out.println("Invalid Caeipi Number! Enter Again!");
								}while(flag!=1);	
								
								flag=0;
								composer.setComposerCaeipiNumber(number);
									
								if(adminService.updateComposerCaeipiNumber(composer,admin))
								{
									System.out.println("Composer Caeipi Number Updated Successfully!");
									logger.info("Composer Caeipi Number Updated Successfully!");
								}
								else
									System.out.println("Composer Caeipi Number Not Updated!");
								break;
								
						case 5: do{
									System.out.print("Enter New Music Society Id(100/101/000):");
									societyId=scanner.nextLine();
									if(adminService.validateMusicSociety(societyId))
										flag=1;
									else
										System.out.println("Invalid Music Society Id! Enter Again!");
								}while(flag!=1);
									
								if(adminService.updateComposerMusicSocietyId(composer,admin))
								{
									System.out.println("Composer Music Society Id Updated Successfully!");
									logger.info("Composer Music SocietyId Updated Successfully!");
								}
								else
									System.out.println("Composer Music Society Not Updated!");
								
								break;
						case 6: new AdminUI(admin).adminMenu();
								break;
								
						case 7: System.exit(0);
								break;
										
						default:System.out.println("Invalid! Enter Correct Option!");
						}
					}while(ch<1||ch>7);	
				}
				catch(AdminException e)
				{
					System.err.println(e+"Updation Could Not Be Completed! Please Try Again!");
				}
				
			}	
		else
			System.out.println("No Composer Found!!!");
		
		
	}
	/*******************************************************************************************************
	 - Function Name 	:	updateArtist
	 - Input Parameters	:	UserBean
	 - Return Type		:	void
	 - Throws			:  	IOException
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Updating the Artist Details for the already existing Artist
	 ********************************************************************************************************/
	
	public static void updateArtist(UserBean admin) throws IOException
	{
		adminService=new AdminServiceImpl();
		scanner=new Scanner(System.in);
		ArtistBean artist=new ArtistBean();
		int ch,flag=0;
		String name,s,choice,bornDate,diedDate;
		
			try 
			{
				String validatenum=null;
				do{
					System.out.print("Enter the Id of Artist:");
					validatenum=scanner.nextLine();
				}while(!adminService.validateNumber(validatenum));
				int id=Integer.parseInt(validatenum);
				
				artist=adminService.searchArtist(id);
			}
			
			catch(AdminException e)
			{
				System.err.println(e);
			}
			
				
		if(artist!=null)
		{				
			flag=0;
			System.out.println("What do you want to update?");
			System.out.println("1.Artist Name\n2.Artist Type\n3.Artist Born Date\n4.Artist Died Date\n5.Return to Previous Menu");
			System.out.println("6.Logout\n7.Exit");
		
				try
				{
					do
					{	System.out.flush();
						System.out.print("Enter Choice: ");
						choice=scanner.nextLine();
						Pattern p=Pattern.compile("[1-7]");
						Matcher m=p.matcher(choice);
						if(m.matches())
							ch=Integer.parseInt(choice);
						else ch=0;
					
					switch(ch)
							{
							case 1: do
									{
									System.out.print("Enter new Artist name: ");
									BufferedReader buffer1 = new BufferedReader(new InputStreamReader(System.in));
									name = buffer1.readLine();
							        if(adminService.validateName(name))
							        		flag=1;
							        else
							        	System.out.println("Invalid Name! Enter Again!");
									}while(flag!=1);
							        	
										flag=0;
										artist.setArtistName(name);
							        	if(adminService.updateArtistName(artist,admin))
							        	{
							        		System.out.println("Artist Name Updated Successfully!");
							        		logger.info("Artist Name Updated Successfully!");
							        	}
							        	else
							        		System.out.println("Artist Name Not Updated!");
							       
							         break;
							case 2: do
									{
									System.out.print("Enter New Artist Type(1 Character): ");
										s=scanner.nextLine();
										if(adminService.validateType(s))
											flag=1;
										else
											System.out.println("Type Must Be Of 1 Character! Enter Again!");
									}while(flag!=1);	
										flag=0;
									artist.setArtistType(s.toUpperCase());
										if(adminService.updateArtistType(artist,admin))
										{
											System.out.println("Artist Type Updated Successfully!");
											logger.info("Artist Type Updated Successfully!");
										}
										else
											System.out.println("Artist Type Not Updated");
								
								break;
								
							case 3: do
									{
										System.out.print("Enter Artist Born Date(dd/mm/yyyy): ");
										bornDate=scanner.nextLine();
										if(adminService.validateDate(bornDate))
											flag=1;
										else
											System.out.println("Invalid Date! Enter Again!");
									}while(flag!=1);	
										flag=0;
										artist.setArtistBornDate(bornDate);
										if(adminService.updateArtistBornDate(artist,admin))
										{
											System.out.println("Artist Born Date Updated Successfully!");
											logger.info("Artist Born Date Updated Successfully!");
										}
										else
											System.out.println("Artist Born Date Not Updated!");
								break;
								
							case 4:	do
									{
									System.out.print("Enter Died Date(dd/mm/yyyy)(NA if not Applicable): ");
									diedDate=scanner.nextLine();
									if(adminService.validateDate(diedDate))
											flag=1;
									else
										System.out.println("Invalid Date! Enter Again!");
									}while(flag!=1);
										
										if(diedDate.equals("NA"))
												diedDate=null;
										artist.setArtistDiedDate(diedDate);
										if(adminService.updateArtistDiedDate(artist,admin))
										{
											System.out.println("Artist Died Date Updated Successfully!");
											logger.info("Artist Died Date Updated Successfully!");
										}
										else
											System.out.println("Artist Died Date Not Updated!");
								break;
							case 5: new AdminUI(admin).adminMenu();
								break;
								
							case 6: ClientUI.main(null);
								break;
							
							case 7:System.exit(0);
									logger.info("Application Terminated!");
									break;
						default:	System.out.flush();
									System.err.flush();
									System.err.println("Enter Valid Option!");	
							}
					}while(ch<1||ch>7);
					}
			
				catch(AdminException e)
				{
					System.out.flush();
					System.err.println(e+"Updation Could Not Be Completed! Please Try Again!");
					logger.equals("Updation Not Completed!");
				}
			
		}
			else
			System.out.println("No Artist Found!");
				System.err.flush();
	}	
	/*******************************************************************************************************
	 - Function Name 	:	associateSongs
	 - Input Parameters	:	UserBean
	 - Return Type		:	void
	 - Throws			:  	-
	 - Author			:	Ishita Bajaj
	 - Creation Date	:	01/09/2018
	 - Description		:	Associating Songs with the Composer or Artist
	 ********************************************************************************************************/
	
	 
	public static void associateSongs(UserBean admin)
	{
		adminService=new AdminServiceImpl();
		scanner=new Scanner(System.in);
		int flag=0,ch=0;
		String choice;
		
			System.out.println("1.Assosciate Song With Composer");
			System.out.println("2.Assosciate Song With Artist");
			System.out.println("3.Return to Previous Menu");
			System.out.println("4.Logout");
			System.out.println("5.Exit");
		
				try
				{	System.err.flush();
					do
					{	
						System.out.print("Enter Choice: ");
						choice=scanner.nextLine();
						Pattern p=Pattern.compile("[1-7]");
						Matcher m=p.matcher(choice);
						if(m.matches())
							ch=Integer.parseInt(choice);
						else ch=0;
					
					switch(ch)
					{
						case 1: System.out.println("------------Composer List:-------------- ");
								ArrayList<Integer> composerList=new ArrayList<>();
								composerList=adminService.getComposerList();
								Iterator itr=composerList.iterator();
								while(itr.hasNext())
								{
									System.out.println(itr.next());
								}
								System.out.println("----------------------------------------");
								try 
								{
									String validatenum=null;
									do{
										System.out.print("Enter Composer Id: ");
										validatenum=scanner.nextLine();
									}while(!adminService.validateNumber(validatenum));
									int composerId=Integer.parseInt(validatenum);
									
									ComposerBean composer=adminService.searchComposer(composerId);
									if(composer!=null)
									{
										
										validatenum=null;
										do{
											System.out.print("Enter Song Id: ");
											validatenum=scanner.nextLine();
										}while(!adminService.validateNumber(validatenum));
										int songId=Integer.parseInt(validatenum);
										
										if(adminService.searchSong(songId))
										{
											if(adminService.associateComposer(composerId,songId,admin))
											{
												System.out.println("Composer Assosciated With Song Sucessfully!");
												logger.info("Composer Assosciated With Song Sucessfully!");
											}
											else
												System.out.println("Composer Not Assosciated With Song!");
										}else
											{
											System.out.println("Song not Found in the Database!");
											logger.warn("Song not Found in the Database!");
											}
									}
									else
									{
										System.out.println("No Composer Found!");
										logger.warn("No Composer Found!");
									}
								}catch(AdminException e)
								{
								System.err.println(e);
								}
								break;
					
						case 2: 	flag=0;
									System.out.println("-------------Artist List:---------------");
									ArrayList<Integer> artistList=new ArrayList<>();
									artistList=adminService.getArtistList();
									Iterator it=artistList.iterator();
									while(it.hasNext())
									{
										System.out.println(it.next());
									}
									System.out.println("----------------------------------------");
									String validatenum=null;
									try
									{	
										do{
											//System.out.flush();
											System.err.flush();
											System.out.print("Enter Artist Id: ");
											validatenum=scanner.nextLine();
										}while(!adminService.validateNumber(validatenum));
									
										int artistId=Integer.parseInt(validatenum);	
										ArtistBean artist=adminService.searchArtist(artistId);
										if(artist!=null)
										{	
											validatenum=null;
											
											do{
												System.err.flush();
												System.out.flush();
												System.out.print("Enter Song Id: ");
												validatenum=scanner.nextLine();
											}while(!adminService.validateNumber(validatenum));
											int songId=Integer.parseInt(validatenum);
											
												
											if(adminService.searchSong(songId))
												if(adminService.associateArtist(artistId, songId, admin))
												{
													System.out.println("Artist Assosciated With Song Successfully!");
													logger.info("Artist Assosciated With Song Successfully!");
												}
												else
													System.out.println("Artist Not Assosciated With Song!");
											else
											{
												System.out.println("Song Not Found in the Database!");
												logger.warn("Song Not Found in the Database!");
											}
										}
										else
											{
											System.out.println("No Artist Found!");
											logger.warn("No Artist Found!");
											}
										
										}
										catch(AdminException e)
										{
											System.err.println(e);
											logger.error(e);
										}
										
								break;
						case 3: new AdminUI(admin).adminMenu();
								break;
						
						case 4: ClientUI.main(null);
								break;
							
						case 5: System.exit(0);
								break;
							
						default:System.out.flush();
								System.err.println("Invalid Option! Enter Again!");
								break;
					}		
				}while(ch<1||ch>5);
				}
				catch(AdminException e)
				{
					System.err.println(e);
					logger.error(e);
					
				}
			
	}
}
