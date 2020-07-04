public class LeapYear{
	public static boolean isLeapYear(int year){
		if((year%400==0)||(year%4==0&&year%100!=0))
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		if(isLeapYear(Integer.parseInt(args[0])))
			System.out.println(args[0]+"is leap year");
		else
			System.out.println(args[0]+"is not leap year");
	}
}