package org.virtualkey.operations;

import org.virtualkey.entities.Screen;
import org.virtualkey.entities.WelcomeScreen;

public class ScreenService {
	
	    public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
	    public static FileOptions FileOptionsScreen = new FileOptions();
	    
	    public static Screen CurrentScreen = WelcomeScreen;

	    
	    public static Screen getCurrentScreen() {
	        return CurrentScreen;
	    }

	    
	    public static void setCurrentScreen(Screen currentScreen) {
	        CurrentScreen = currentScreen;
	    }
	    
}
