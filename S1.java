/**
  * "xyz" versus new String("xyz")`
  */

class S1 {

  public static void method(String id, String literal, String aNewString)
  {
	System.out.println(id + " in method");
	System.out.println("\tliteral= aNewString\n	" + ( literal == aNewString ));
  }
  
  public static void main( String args[] )
  {
	String aString = "xyz";
	System.out.println("1.	xyz == aString:	" +     "xyz" == aString   );
	System.out.println("2.	xyz == aString:	" +   ( "xyz" == aString ) );

	String newString = new String("xyz");
	System.out.println("xyz == new String(xyz)\n	" + ("xyz" == newString) );

	method("1", "xyz", "xyz");
	method("2", "xyz", new String("xyz") );
	method("3", "xyz", "xy" + "z");
	method("4", "x" + "y" + "z", "xyz");
	method("5", "x" + "y" + new String("z"), "xyz");
	method("6", "x" + ( "y" + "z"), "xyz");
	method("7", 'x' + ( "y" + "z"), "xyz");
  }
  
}
