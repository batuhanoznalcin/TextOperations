import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeUpExam {
	interface DataReader {
		String readData() throws Exception;
	}
	public static class FileDataReader implements DataReader{

		@Override
		public String readData() throws Exception {
			FileReader fr = new FileReader("operations.txt"); 
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) { 
				sb.append(line).append("\n"); 
				line = br.readLine();
			} 
			String fileAsString = sb.toString();
			System.out.println(fileAsString); 
			br.close();
			return fileAsString;
		}

		}
	public class NetworkDataReader implements DataReader{

		@Override
		public String readData() {
			return null;
		}
	}
	public static class StringContainer{
		String holding;
		List <String> set = new ArrayList();
		
		public StringContainer(){
			this.set=set;
		}
		
		boolean a(){
			Scanner input = new Scanner(System.in);
			System.out.println("Please write the operation name");
			String operation = input.next();
		 for (String str : set) {  
				 if (str.equals(operation)) {  
			      	System.out.println("true");
			           return true;
			     }  
			     else {
			       	System.out.println("false");
			    	return false;
			    }
			}
			 return true;	
}
		public String getHoldedString() {
		    return holding;
		  }
		
	}
	
	static abstract class Operation {
		
		String nextoperation;
	}
	public enum Operations{
		FRW,EWSR,DWR;
	}
	public static class ExtraWSReplacement extends Operation{
		Operations o1 = Operations.EWSR;
		
		void remove() throws Exception {
				FileReader fr = new FileReader("operations.txt"); 
				BufferedReader br = new BufferedReader(fr);
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while (line != null) { 
					sb.append(line).append("\n"); 
					line = br.readLine();
				} 
				String fileAsString = sb.toString();
				System.out.println("The original text is :\n"+fileAsString); 
				System.out.println("After deleting double double spaces :\n"+fileAsString.replaceAll("\\s+", " "));
				
				br.close();
		}
		
	}
	public static class DuplicateWordRemoval extends Operation{
		Operations o2 = Operations.DWR;
		void removing() throws Exception {
			FileReader fr = new FileReader("operations.txt"); 
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) { 
				sb.append(line).append("\n"); 
				line = br.readLine();
			} 
			String fileAsString = sb.toString();
			System.out.println("The original text is :\n"+fileAsString); 
			
			br.close();
		  for(int i=0; i<fileAsString.length();i++){  
              char c = fileAsString.charAt(i);  
            System.out.println("char at "+i+" index is: "+c);  
      }   
	}
	}
	public static class FindReplaceWord extends Operation{
		Operations o3 = Operations.FRW;
		void procces() throws Exception {
		FileReader fr = new FileReader("operations.txt"); 
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		while (line != null) { 
			sb.append(line).append("\n"); 
			line = br.readLine();
		} 
		String fileAsString = sb.toString();
		System.out.println("The original text is :\n"+fileAsString); 
		System.out.println("Please write a word or a letter which you want to change to");
		Scanner inp = new Scanner(System.in);
		String changeto = inp.next();
		System.out.println("Please write a word or a letter which you want to change");
		String change = inp.next();
		System.out.println("After changing words or letters :\n"+fileAsString.replaceAll(change, changeto));
		
		br.close();
		}
	}


	
	
	public static void main(String[] args) throws Exception {
	
		System.out.println("This is a string manipulator application. Please choose the method according to your purpose.\n"
				+ "Also do not forget that you will type their capital words as stand-in form when you got questioned the write the operation name.\n"
				+ "Please be sure that you will write them CAPITAL \n");
		System.out.println("-------------Menu-------------");
		System.out.println("Extra White Spaces Replacement");
		System.out.println("Duplicate Word Removal");
		System.out.println("Find Replace Word\n");	
		System.out.println("Please type your choose according to instructions which are above");

		StringContainer sc = new StringContainer();
            sc.set.add("EWSR");
    		sc.set.add("DWR");
    		sc.set.add("FRW");
    		sc.a();
                for (Operations operations: Operations.values())
                {
                	
                 switch(operations) {
                 case FRW:
                	 System.out.println("This is Find Replace Word class.\n");
                	 FindReplaceWord case2 = new FindReplaceWord();
                 case2.procces();
                	 break;
                 case EWSR:
                	 System.out.println("This is Extra White Spaces Replacement class.\n");
                	 ExtraWSReplacement case1 = new ExtraWSReplacement();
                 case1.remove();
                	 break;
                 case DWR:
                	 DuplicateWordRemoval case3 = new DuplicateWordRemoval();
                	System.out.println("This is Duplicate Word Removal class.\n"); 
                	
                	 break;
            
                 }
                }
              
	}

	}

