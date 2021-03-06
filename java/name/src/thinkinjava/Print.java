package thinkinjava;

import java.io.PrintStream;

public class Print {
	public static void print(Object obj){
		System.out.println(obj);
	}
	//print a new line itself
	public static void print(){
		System.out.println();
	}
	//print with no line break
	public static void printnb(Object obj){
		System.out.print(obj);
	}
	//The new Java SE5 printf() (from c)
	public static PrintStream printf(String format,Object ... args){
		return System.out.printf(format,args);
	}

}
