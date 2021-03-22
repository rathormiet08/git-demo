package com.lambda;

public class LambdaTest// implements FunctionalTest 
{
	/*@Override
	public void m1() {
		System.out.println(" approach beforte java 8 ");

	}*/

	public static void main(String[] args) {
		// new AnonymusFn().m1();
		//new LambdaTest().m1();
		/*FunctionalTest ft = () -> {
			System.out.print(" func interface m1 mthod ");
			
		};
		
		FunctionalTest ft = () -> {
			System.out.print(" func interface m1 mthod ");
			return 0;
		};*/
		FunctionalTest ft = (n1,n2) -> {
			System.out.print(" func interface m1 mthod ");
			return n1+n2;
		};
		int m1 = ft.sum(2,3);
		System.out.println("return type functional method value:: "+m1);
		//ft.m3();
		//FunctionalTest.m4();
	}

}

@FunctionalInterface
interface FunctionalTest {
	//void m1();
	//int m1();
	int sum(int n1,int n2);
	// void m2(); can't be add second method as it's functional interface

	default void m2() {
		System.out.println("default m2 ");
	}

	default void m3() {
		System.out.println("default m3 ");
	}

	static void m4() {
		System.out.println("staticn  m4 ");
	}
}

class AnonymusFn {
	void m1() {
		System.out.println("normal method");
	}

}