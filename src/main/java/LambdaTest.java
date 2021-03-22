
public class LambdaTest {

	public static void main(String[] args) {
		//new AnonymusFn().m1();
		FunctionalTest ft=	()->{
			System.out.print(" func interface m1 mthod ");
		};
		ft.m1();
		ft.m3();
		FunctionalTest.m4();
	}

}

@FunctionalInterface
interface FunctionalTest {
	void m1();
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