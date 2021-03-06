public class App
{
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		String str = "{[()]}";
		for (int i = 0; i <str.length();i++){
		    String s = Character.toString(str.charAt(i));
		    String rev = reverseBracket(s);
		    if( isLeftBracket(s))
		        stack.push(s);
		    else if(stack.isEmpty() || !stack.pop().equals(rev))
		    {
		        System.out.println("invalid");
		        return;
		    }
		    
		}
		System.out.println("valid");
	}
	public static boolean isLeftBracket(String str)
	{
	    if(str.equals("(") || str.equals("{") || str.equals("[")){
	        return true;
	    }
	    return false;
	}
	
	public static String reverseBracket (String str){
	    if(str.equals("("))
	        return ")";
	    if(str.equals(")"))
	        return "(";
	    if(str.equals("["))
	        return "]";
	    if(str.equals("]"))
	        return "[";
	    if(str.equals("}"))
	        return "{";
	    return "{";
	}
}
