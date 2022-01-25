package org.virtualkey.entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.virtualkey.operations.DirectoryService;
import org.virtualkey.operations.ScreenService;


public class WelcomeScreen implements Screen {
	    private String welcomeText = "Welcome to LockedMe:A Virtual Key";
	    private String developerText = "Developed By: BIBHU RANJAN MOHANTY";
	    private ArrayList<String> options = new ArrayList<>();

	    public WelcomeScreen() {
	        options.add("1. Display the current file names in ascending order.");
	        options.add("2. Manage Files/Folders");
	        options.add("3. Quit");

	    }
	    
	    public void welcomeScreen() {
	    	System.out.println(welcomeText);
	        System.out.println(developerText);
	        System.out.println("\n");
	        Show();
	    }
	    
	    public void Show() {
	    	System.out.println("Main Menu");
	        for (String s : options)  {
	            System.out.println(s);
	        }

	    }

	    public void GetUserInput() {
	        int selectedOption  = 0;
	    
	        while (true) {
	        	selectedOption = this.getOption();
	        	if(selectedOption == 3) {
		        	System.out.println("Program Terminated Successfully.");
	            	break;
	        	}
	        	this.NavigateOption(selectedOption);
	        }
	    }
	    public void NavigateOption(int option) {
	        switch(option) {
	            case 1: //Show Files in the current Directory
	                this.ShowFiles();
	                this.Show();
	                break;
	                
	            case 2: // Show File Options menu
	            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
	                ScreenService.getCurrentScreen().Show();
	                ScreenService.getCurrentScreen().GetUserInput();
	                this.Show();
	                break;
	            default:
	                System.out.println("Invalid Option");
	                break;
	        }
	        
	    }

	    public void ShowFiles() {

	        // Get the files from the Directory
	    	System.out.println("List of Files: ");
	    	DirectoryService.PrintFiles();

	    }
	    
	    private int getOption() {
	        Scanner in = new Scanner(System.in);

	        int returnOption = 0;
	        try {
	            returnOption = in.nextInt();
	        }
	        catch (InputMismatchException ex) {

	        }
	        return returnOption;

	    }
}
