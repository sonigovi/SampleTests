package pkgTryCatchFinally;

public class TryCatchDemo01 {
	public static void main (String[] args){
		ArithmeticException();
		ArrayIndexOutOfBounds();
		NumberFormatException();
		NullPointerException();
	}
	
	public static void ArithmeticException() throws ArithmeticException{
		try{
			int data = 50/0;
			System.out.println(data);
		}
		catch (ArithmeticException e){
			System.out.println(e);
		}
		finally{
			int data = 0;
			System.out.println(data);
		}
	}

	public static void ArrayIndexOutOfBounds() throws ArrayIndexOutOfBoundsException{
		try{
			int a[] = new int[5];
			a[10] = 50;
			System.out.println(a);
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}
		finally{
			int a[] = {1,2,3,4,5}; //new int[5];
			System.out.println(a[0] + a[1]);
		}
	}

	public static void NumberFormatException() throws NumberFormatException{
		try{
			String s = "abc";
			int a = Integer.parseInt(s);
			System.out.println(a);
		}
		catch (NumberFormatException e){
			System.out.println(e);
		}
		finally{
			String s = "1234567890";
			int a = Integer.parseInt(s);
			System.out.println(a);
		}
	}

	public static void NullPointerException() throws NullPointerException{
		try{
			String s = null;
			System.out.println(s.length());
		}
		catch (NullPointerException e){
			System.out.println(e);
		}
		finally{
			String s = "abcdefghijklmnopqrstuvwxyz";
			System.out.println(s.length());
		}
	}
}
