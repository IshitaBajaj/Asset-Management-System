/*
 * ISHITA BAJAJ - 155201
 */
package com.cg.artistsmanagementsystem.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.service.AdminServiceImpl;
import com.cg.artistsmanagementsystem.service.IAdminService;
/*
 * MAIN CLASS-ClientUI
 */
public class ClientUI {

	public static Logger logger=Logger.getRootLogger();//Logger for tracking the state of application
	public static void main(String[] args) {
		
		int option;
		char choice='y';
		Scanner scanner=new Scanner(System.in);
		/*
		 * Main Menu of the Application 
		 * 1.Login: Displays the menu for admin or user as per the provided credentials
		 * 2.Exit: Terminated the Application
		 * The application runs until the admin/user explicitly exits the run application
		 */
		System.out.println("*******************************************************************");
		System.out.println("           MEDIA COMPOSER AND ARTISTS MANAGEMENT SYSTEM");
		System.out.println("******************************************************************");
		System.out.println("Menu:");
		System.out.println("1.Login");
		System.out.println("2.Exit");
		
		do																		//Start of Do-While 
		{
			try
			{
			System.out.print("Enter Your Choice:");								//Enter option to login or exit
			option=scanner.nextInt();
			
			switch(option)
			{
				/*
				 * Case 1: To login using valid credentials 
				 * If LoginId/Password are of admin it will display Admin Menu
				 * If LoginId/Password are of user it will display User Menu 
				 */
				case 1:	IAdminService adminService=new AdminServiceImpl();
						try{
							System.out.print("Enter Login Id: ");
							int id=scanner.nextInt();
							System.out.print("Enter Password: ");
							String pwd=scanner.next();
							UserBean user=new UserBean();
						
							user.setUserId(id);
							user.setUserPwd(pwd);
							String type=adminService.login(user);
							if("A".equals(type))
							{
								System.out.println("Login Successful!");
								logger.info("Admin Logged In!");		//Log the details for admin login
								new AdminUI(user).adminMenu();			//Admin Login
							}
							else if("U".equals(type)){
								System.out.println("Login Successful!");
								logger.info("User Logged In!");			//Log the details for user login
								new UserUI().userMenu();				//User Login
							}
							else
							{	System.out.flush();
								System.err.flush();
								System.err.println("Invalid Username/Password!");
								logger.warn("Invalid Credentials!");	//Log the details for unauthorized attempt to login	
							}
						}
						catch(InputMismatchException e)
						{	System.err.flush();
							System.err.println("Enter Integer Only!\n");
							logger.error("Invalid Inputs");
						}catch (Exception e) {
							
							System.err.flush();
							System.err.println(e);;
							logger.error(e);
						}
						
						break;
				
				case 2: System.out.println("Application Terminated!");
						logger.info("Application Terminated!");			//Log the details for Application Termination
						System.exit(0);									//Exiting the application
						break;
				default:System.err.print("Please Enter a Valid Option!\n");		
						ClientUI.main(null);
			}															//End of Switch
			scanner.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.out.flush();
				System.err.println("Please Enter a Valid Option!");
				scanner.next();
				ClientUI.main(null);
				
			}
			
			System.out.print("Do you want to continue? Press 'N' to exit else to continue. ");
			choice=scanner.next().charAt(0);
					}while(choice!='N'&&choice!='n');					//End of Do-While
}
	


}
