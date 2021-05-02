package JavaBasics;

public class ReverseString {

	public static void main(String[] args) {
		String S="Harika";
		String reverse = "";
		for(int i=S.length()-1;i>=0;i--) {
			reverse=reverse+S.charAt(i);
			}
		System.out.print("Actual String:"+S );
		System.out.print("Reverse of String:"+reverse);

	}

}
