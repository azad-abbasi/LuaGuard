
public class Stack {
	static int top = -1;
	static String[] stack = new String[100];
	
	public static void push(String str){
		if (top < 100){
			stack[++top] = str;
		}
		else 
			System.out.println("Stack full");
	}
	public static String pop(){
		if (top >= 0){
			return stack[top--];
		}
		else
			return "Stack empty";
	}
	public static String parent(){
		//System.out.print("top:"+top);
		if (top > 0 && top < 100){
			return stack[top - 1];
		}
		else
			return "Element out of range";
	}
	public static String child(){
		if (top > 0 && top < 100){
			return stack[top + 1];
		}
		else
			return "Element out of range";
	}
	public static void printStack(){
		for (int i = 0; i <= top; i++){
			System.out.println(stack[i]);
		}
	}
	public static boolean isEmpty(){
		if (top > 0){
			return false;
		}
		else{
			return true;
		}
	}
}
