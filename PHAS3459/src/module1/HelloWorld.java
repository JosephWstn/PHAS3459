package module1;

public class HelloWorld {


		private int nonStaticVar = 0;
		private static int staticVar = 2;
		public static void main(String[] args) {
			HelloWorld a = new HelloWorld();
			HelloWorld b = new HelloWorld();
			a.nonStaticVar = 6;
			b.staticVar = 3;
			System.out.println(a.nonStaticVar + a.staticVar);
		}


	}
