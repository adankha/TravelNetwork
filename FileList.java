/**
 * Auto Generated Java Class.
 */
public class FileList {
  
  private MyFNode head;
  
    
  public FileList()
  {
    head = null;
  }  
  
  public void show()
  {
   MyFNode tmp = head;
   if (head == null){
     System.out.println("None.");
     return;
   }
   while(tmp != null)
   {
     if (tmp.next != null)
       System.out.print(tmp.elem + ", ");
     else
       System.out.print(tmp.elem + " ");
     
     tmp = tmp.next;
   }
   System.out.println();
  } // End of show()
  
  public void push (String name)
  {
    
    MyFNode tmp = new MyFNode (name);
    
    tmp.next = head;
    head = tmp;
  } // End of insert(int v1)

  public void pop(){
    if(head != null)
    head = head.next;
  }
  
  public boolean doesExist(String name)
  {
    MyFNode tmp = head;
    while(tmp != null)
    {
      if( tmp.elem.equals(name))
        return true;
      tmp = tmp.next;
    }
    return false;
  }
  
  public void free()
  {
    while(head != null)
      head = head.next;
  }

  
}

class MyFNode
{
 String elem;
 MyFNode next;
 
 MyFNode(String v1)
 {
   elem = v1;
   next = null;
 }
 
 

}
