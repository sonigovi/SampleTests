package pkgTryCatchFinally;

public class TryCatchFinallyNested {
	public static void main (String[] args){
		TryCatchNested();
	}
	
	public static void TryCatchNested(){
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

				try{
					String s = "abc";
					int a1 = Integer.parseInt(s);
					System.out.println(a1);
				}
				catch (NumberFormatException e){
					System.out.println(e);
				}
				finally{
					String s = "1234567890";
					int a1 = Integer.parseInt(s);
					System.out.println(a1);

					try{
						String s1 = null;
						System.out.println(s1.length());
					}
					catch (NullPointerException e){
						System.out.println(e);
					}
					finally{
						String s1 = "abcdefghijklmnopqrstuvwxyz";
						System.out.println(s1.length());
					}
				}
			}
		}
	}
}
