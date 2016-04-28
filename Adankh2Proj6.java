import java.io.*;
import java.util.*;

public class Adankh2Proj6
{
  
 private static Airport[] arrayList = new Airport[10];
 private static int maxVal = 10;
 private static FileList fileList = new FileList();
 private static Adankh2Proj6 airportData = new Adankh2Proj6();
 
 public static void main (String[] args)
 {
                       
   System.out.println("\nWelcome to the Dankha Airlines. Please buckle your seatbelts and get ready for take off :)"); 
   System.out.println("           .@.         "); 
   System.out.println("            @@         "); 
   System.out.println("             @@        "); 
   System.out.println("             #@;       "); 
   System.out.println("      +;      @@`       ");
   System.out.println("  ~~~~,@######@@@####`  ");
   System.out.println("  ~~~~ @@@@@@@@@@@@@@@` ");
   System.out.println("  ~~~~:@......@@+....`  ");
   System.out.println("      `      .@@      ");  
   System.out.println("             @@`      ");  
   System.out.println("            ,@;       ");  
   System.out.println("            @@        ");  
   System.out.println("          ;@          "); 

   int i;

   for(i = 0; i < maxVal; i++)
     arrayList[i] = new Airport();
  
   // set up an instance of the BufferedReader class to read from standard input
   BufferedReader br = new BufferedReader (new InputStreamReader (
        System.in));
   

   
   // set up the data needed for the airport adjacency list
   
   // call the method that reads and parses the input
   airportData.processCommandLoop (br);
   
   System.out.println ("Goodbye");
 }
 
  public void depthFirstSearchHelper(int x, int y)
  {
    int i = 0;
  
    for(i = 0 ; i < maxVal; i++)
    {
      arrayList[i].notVisited(); 
    }
    if(dfs(x,y) == true)
      System.out.println("You can get from airport " + x + " to airport " + y + " in one or more flights.");
    else
      System.out.println("You can NOT get from airport " + x + " to airport " + y + " in one or more flights.");
  }
  public boolean dfs(int a, int b)
  {
    int i = 0;
    int c = 0;
       
    for(i = 0; i < arrayList[a-1].size(); i++)  //Loop that will loop the size of each linked list
    {
      c = arrayList[a-1].getNthElem(i);  // c is equal to each each element stored in airport a.
       
       if (c == b)  // If c equals to the destination b, then airport a can fly to airport b
         return true;
       
       if (arrayList[c-1].isVisited() == false) // If the visited mark is false, mark as true
       {
         arrayList[c-1].nowVisited();      
         if(dfs(c, b) == true) // This is our recursive call.
           return true;
       }     
    }
    
    return false;       
  }
   
   
  public void processCommandLoop (BufferedReader br)
  {
    try {  //try-catch clauses are needed since BufferedReader and Scanner classes
           //  throw exceptions on errors
    String inline = br.readLine();   // get a line of input
    Scanner sc;
    
   // loop until all lines are read from the input
   while (inline != null)
   {
     sc = new Scanner (inline);   // process each line of input using the Scanner iterators
     String command;

     if(sc.hasNext()){
       command  = sc.next();
       System.out.println ("*" + command + "*");
     }
     else
       command = " ";

     if (command.equals("q") == true){
      
       System.out.println("\nThank you for riding the Dankha Airlines. We hope you choose us again! :)"); 
       System.out.println("        .@.         "); 
       System.out.println("         @@         "); 
       System.out.println("          @@        "); 
       System.out.println("___ _______#@; _______|__________|__________|__________|_________"); 
       System.out.println("   +;      @@`                  DANKHA AIRLINES");
       System.out.println("   ,@######@@@####`             NETID: Adankh2");
       System.out.println("- - @@@@DANKHA@@@@@` - - - - - - - - - - - - - - - - - - - - - - ");;
       System.out.println("   :@.|....@@+.|..`   We hope you enjoyed your flight!");
       System.out.println("___`__O___ .@@_O______|__________|__________|__________|__________");  
       System.out.println("          @@` ");  
       System.out.println("         ,@;  ");  
       System.out.println("         @@");  
       System.out.println("       ;@  "); 
       System.exit(1);
     }
     else if (command.equals("?") == true)
       showCommands();
     
     else if (command.equals("t") == true)
       doTravel(sc);
     
     else if (command.equals("r") == true)
       doResize(sc);

     else if (command.equals("i") == true)
       doInsert(sc);

     else if (command.equals("d") == true)
       doDelete(sc);

     else if (command.equals("l") == true)
       doList(sc);

     else if (command.equals("f") == true)
       doFile(sc);

     else if (command.equals("#") == true)
       ;
     else if (command.equals(" ") == true)
       ;

     else
       System.out.println ("Command is not known: " + command);
     
     inline = br.readLine();   // get the next line of input

   }

  }
  catch (IOException ioe)
  {
    System.out.println ("Error in Reading - Assuming End of File");
  }
 }
 
 public void showCommands()
 {
   System.out.println ("The commands for this project are:");
   System.out.println ("  q ");
   System.out.println ("  ? ");
   System.out.println ("  # ");
   System.out.println ("  t <int1> <int2> ");
   System.out.println ("  r <int> ");
   System.out.println ("  i <int1> <int2> ");
   System.out.println ("  d <int1> <int2> ");
   System.out.println ("  l ");
   System.out.println ("  f <filename> ");
 }
 
 public void doTravel(Scanner sc)
 {
   int val1 = 0;
   int val2 = 0;
   
   if ( sc.hasNextInt() == true )
     val1 = sc.nextInt();
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   if ( sc.hasNextInt() == true )
     val2 = sc.nextInt();
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   
   if (val1  > Adankh2Proj6.maxVal || val1 <= 0 || val2 > Adankh2Proj6.maxVal || val2 <= 0)
   {
   System.out.println("Values do not meet the range of the airport numbers.");
   return;
   }  
   
   System.out.println ("Performing the Travel Command from " + val1 +
                       " to " + val2);
   
   depthFirstSearchHelper(val1, val2);
   
 } 
 public void doResize(Scanner sc)
 {
   int val1 = 0;
   int i = 0;
   
   if ( sc.hasNextInt() == true )
     val1 = sc.nextInt();
   else
   {
     System.out.println ("Integer value expected");
     return;
   }
   if (val1 <= 0)
   {
     System.out.println("Integer must be greater than 0.");
     return;
   }
   
   
    arrayList = null;
    System.out.println ("Performing the Resize Command with " + val1 );
    arrayList = new Airport[val1]; //Array of linked list allocating val1 list
    
    for(i = 0; i < val1; i++)
    {
     arrayList[i] = new Airport(); 
    }
    
    Adankh2Proj6.maxVal = val1;    
 }
 
 public void doInsert(Scanner sc)
 {
   int val1 = 0;
   int val2 = 0;

   if(sc.hasNextInt() == true)
     val1 = sc.nextInt();
   else
   {
     System.out.println("Intger value expected.");
     return;
   }
   if(sc.hasNextInt() == true)
     val2 = sc.nextInt();
   else
   {
     System.out.println("Intger value expected.");
     return;
   }
   if (val1  > Adankh2Proj6.maxVal || val1 <= 0 || val2 > Adankh2Proj6.maxVal || val2 <= 0)
   {
   System.out.println("Values do not meet the range of the airport numbers.");
   return;
   }   
     
   System.out.println("Inserting edge so that a plane can fly from airport " + val1 + " to airport " + val2 );
   arrayList[val1-1].insert(val2);  
 }
 
 public void doDelete(Scanner sc)
 {
   
   int val1 = 0;
   int val2 = 0;
   
   if(sc.hasNextInt() == true)
     val1 = sc.nextInt();
   else
   {
     System.out.println("Intger value expected.");
     return;
   }
   if(sc.hasNextInt() == true)
     val2 = sc.nextInt();
   else
   {
     System.out.println("Intger value expected.");
     return;
   }
   if (val1  > Adankh2Proj6.maxVal || val1 <= 0 || val2 > Adankh2Proj6.maxVal || val2 <= 0)
   {
   System.out.println("Values do not meet the range of the airport numbers.");
   return;
   }
   
   System.out.println("Deleting edge so that a plane can fly from airport " + val1 + " to airport " + val2 );
   arrayList[val1-1].remove(val2);
   
 }
 
 public void doList(Scanner sc)
 {
   int i = 0;
   
   for(i = 0; i < Adankh2Proj6.maxVal; i++)
   {
     System.out.print("Airport " + (i+1) + ": ");  
     arrayList[i].show(); 
   }
   
 }
 
 public void doFile(Scanner sc)
 {
   String fname = null;
   
   if ( sc.hasNext() == true )
     fname = sc.next();
   else
   {
     System.out.println ("Filename expected");
     return;
   }
   
   
   System.out.println ("Performing the File command with file: " + fname);
   
   
   // next steps:  (print an error message and return if any step fails) 
   //  1. verify the file name is not currently in use
   if(fileList.doesExist(fname) == true)
   {
     System.out.println("Filename already in use.");
     return;
   }
   fileList.push(fname);
   
   try 
   {
   //  2. open the file
   FileReader file = new FileReader(fname);
   //  3. create a new instance of BufferedReader
   //        BufferedReader br = new BufferedReader (new FileReader ("MyFileReader.txt"));
   BufferedReader br = new BufferedReader (file);
   //  4. recursively call processCommandLoop() with this new instance of BufferedReader as the parameter
   airportData.processCommandLoop(br);
   //  5. close the file when processCommandLoop() returns
   br.close();
   }
   catch(FileNotFoundException exception)
   {
     System.out.println("Cannot open file: " + fname);
   }
   catch(IOException exception)
   {
     System.out.println("Error reading file: " + fname);
   }
   fileList.pop();   
 }
 
}
