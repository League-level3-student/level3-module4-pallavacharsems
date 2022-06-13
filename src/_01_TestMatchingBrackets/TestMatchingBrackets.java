package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
Stack <Character> bracks = new Stack <>();
    	for (int i = 0; i < b.length(); i++) {
	if(b.charAt(i) == '{') {
		bracks.push(b.charAt(i));
	
	}
else if(b.charAt(i) == '}') {
		
		if(bracks.isEmpty()) {
			return false;
		}
		bracks.pop();
	}
		

    	if(bracks.isEmpty()) {
    		return true;
    	} 
        
    }
    	return false;
}
}
    
