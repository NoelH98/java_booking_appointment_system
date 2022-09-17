package main;

import java.util.*;
import java.io.*;

public class AppointmentBooking {
	
	
	  static ArrayList<String> coName = new ArrayList<String>();
	  static ArrayList<String> coGender = new ArrayList<String>();
	  static ArrayList<String> coPassword = new ArrayList<String>();
	  static ArrayList<Integer> coAge = new ArrayList<Integer>();
	  
	  
	  static ArrayList<String> clientName = new ArrayList<String>();
	  static ArrayList<String> clientGender = new ArrayList<String>();
	  static ArrayList<String> clientPassword = new ArrayList<String>();
	  static ArrayList<Integer> clientAge = new ArrayList<Integer>();
	  
	  static ArrayList<String> clientGenderApp = new ArrayList<String>();
	  static ArrayList<String> clientPasswordApp = new ArrayList<String>();
	  static ArrayList<String> clientNameApp = new ArrayList<String>();
	  static ArrayList<Integer> clientAgeApp = new ArrayList<Integer>();
	  static ArrayList<Byte> coID = new ArrayList<Byte>();
	  
	 
	  public static void dataAdd() {
		  
		  coName.add("Arsene Wenger");
		  coName.add("Jose Mourihno");
		  coName.add("Pep Guardiola");
		  coName.add("Jurgen Klopp");
		  coName.add("Luis Enrique");
		  
		  coGender.add("M");
		  coGender.add("M");
		  coGender.add("M");
		  coGender.add("M");
		  coGender.add("M");
		  
		  coPassword.add("12345");
		  coPassword.add("12345");
		  coPassword.add("12345");
		  coPassword.add("12345");
		  coPassword.add("12345");
		  
		  coAge.add(40);
		  coAge.add(40);
		  coAge.add(40);
		  coAge.add(40);
		  coAge.add(40);
	  }
	  
	  public static void client() throws Exception {
		  
		  Scanner sc = new Scanner(System.in);
		  boolean flag = true;
		  while(flag)
		  {
			  
	      new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			  
		  System.out.println("*****************************************");
		  System.out.println("\t\t | Welcome to Client Panel |");
		  System.out.println("*****************************************");
		  System.out.println(" ");
		  System.out.println("1.Login \t 2.Reqister\n");
		  int c = sc.nextInt();
		  
		  switch(c) {
		     
		  case 1:
			  if(clientName.isEmpty()) 
			  {
				  System.out.println("Not registered!");
				  flag = false;
				  Thread.sleep(500);
				  break;
			  }
			  else
			  {
				  clientLogin();
				  flag=false;
			  }
			  
			  break;
			  
		  case 2:
			  clientReg();
			  flag=false;
			  break;
			  
			  default:
				  System.out.println("\n Doesn't exists.");
				  flag = true;
				  Thread.sleep(1000);
				  break;
		  }
		}
	  }
	   
	  
    private static void clientReg() throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int i = 0;
    	String username;
    	new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    	System.out.println("*****************************************");
	    System.out.println("\t\t | Welcome to Client Reg |");
	    System.out.println("*****************************************");
		System.out.println(" ");
		System.out.println("Enter your name");
		clientName.add(sc.nextLine());
		username= sc.nextLine();
		System.out.println("Enter your age");
		clientAge.add(sc.nextInt());
		String cl;
		boolean flag = true, flag1=true;
		
		if(clientName.isEmpty()) {
			clientName.add(username);
			System.out.println("Enter Password");
			clientPassword.add(sc.next());
			System.out.println("Reg Successful!!");
			Thread.sleep(1000);
			flag1=false;
		}
		else {
			for(i=0;i<=clientName.size()-1;i++) {
				cl = clientName.get(i);
				if(cl == username) {
					flag1=false;
					break;
				}
			}
			if(flag1 == false) {
				System.out.println("Name already taken");
				flag1=true;
				Thread.sleep(3000);
			}
		}
	}

	private static void clientLogin() throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		String username;
		String password;
		byte c;
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		System.out.println("*****************************************");
	    System.out.println("\t\t | Welcome to Client Login |");
	    System.out.println("*****************************************");
		System.out.println(" ");
		
		System.out.println("Enter your username");
		username = sc.next();
		
		System.out.println("Enter your password");
		password = sc.next();
		
		boolean fag=false;
		int j;
		for(j=0;j<=clientName.size()-1;j++) {
			
			if((clientName.get(j)).equals(username) && (clientPassword.get(j)).equals(password))
			{
				fag=true;
				
				break;
			}
		}
		
		if(fag==true) {
			Thread.sleep(1000);
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			System.out.println("*****************************************");
		    System.out.println("\t\t | Appointment Booking |");
			System.out.println("*****************************************");
			System.out.println(" ");
			System.out.println("\n Welcome dear client "+clientName.get(j)+ "Start by selecting your preferred CO");
			
			for(int i=0; i<= coName.size()-1; i++) {
				System.out.println((i+1)+"."+coName.get(i));
			}
			c = sc.nextByte();
			coID.add(c);
			
			while(flag) {
				
				Thread.sleep(1000);
				
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
				System.out.println("*****************************************");
			    System.out.println("\t\t | Appointment Booking |");
				System.out.println("*****************************************");
				System.out.println(" ");
				
				if(c<=coName.size() && c>0) {
					
					System.out.println("\n\nName: \t "+coName.get(c+1));
					System.out.println("\n Enter name: \t");
					sc.nextLine();
					clientNameApp.add(sc.nextLine());
					System.out.println("\n Enter age: \t");
					clientAgeApp.add(sc.nextInt());
					System.out.println("\n Enter gender: \t");
					clientGenderApp.add(sc.next());
					System.out.println("\n Booking Successful...");
					Thread.sleep(1000);
					flag=false;
					break;
				}
				else {
					System.out.println("\n Wrong inputs entered!");
					flag=true;
					Thread.sleep(1000);
				}
			}
		}
		else {
			System.out.println("Login unsuccessful");
			Thread.sleep(900);
			flag=false;
		}
	}

	public static void co() throws Exception {
		   
		  Scanner sc = new Scanner(System.in);
		  boolean flag = true;
		  while(flag)
		  {
	     new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			  
		  System.out.println("*****************************************");
		  System.out.println("\t\t | Welcome to CO Panel |");
		  System.out.println("*****************************************");
		  System.out.println(" ");
		  System.out.println("1.Login \t 2.Reqister\n");
		  int c = sc.nextInt();
		  
		  switch(c) {
		     
		  case 1:
			  if(coName.isEmpty()) 
			  {
				  System.out.println("Not registered!");
				  flag=false;
				  Thread.sleep(500);
				  break;
			  }
			  else
			  {
				  coLogin();
				  flag=false;
			  }
			  
			  break;
			  
		  case 2:
			  coReg();
			  flag=false;
			  break;
			  
			  default:
				  System.out.println("\n Doesn't exists.");
				  flag = true;
				  Thread.sleep(1000);
				  break;
		  }
		}
	  }
	  
    private static void coReg() {
		
	}

	private static void coLogin() {
		
	}

	public static void main(String[] args) throws Exception{
		  
		  AppointmentBooking ap = new AppointmentBooking();
		  Scanner sc = new Scanner(System.in);
		  AppointmentBooking.dataAdd();
		  boolean flag = true;
		  
		  while(flag=true) 
		  {
			  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			  
			  System.out.println("*****************************************");
			  System.out.println("\t\t | Welcome to Client Appointment Booking |");
			  System.out.println("*****************************************");
			  
			  System.out.println("\n1.CO \t 2. Client  \t 3.Exit");
			  
			  int choice = sc.nextInt();
			  switch(choice) 
			  {
			  case 1:
				  ap.co();
				  flag=true;
				  break;
			  case 2:
				  ap.client();
				  flag=true;
				  break;
			  default: System.exit(0);
			  }
			  
		  }
	  }
}
