public class Airport {
  
  private MyNode head;
  private boolean listVisit;
  
  public Airport()
  {
    head = null;
    listVisit = false;
  }
  
  public void show()
  {
   MyNode tmp = head;
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
   
  public void insert (int v1)
  {
    MyNode tmp = new MyNode (v1);
    
    MyNode curr = head;
    MyNode prev = null;
    
    while ((curr != null) && (curr.elem <= v1))
    {
      if (curr.elem == v1)
      {
        System.out.println("Airport already exists in list.");
        return;
      }
      prev = curr;
      curr = curr.next;
    }
      
    if ( prev == null )
    {
      head = tmp;
      tmp.next = curr;
    }
    else
    {
      prev.next = tmp;
      tmp.next = curr;
    }
  } // End of insert(int v1)
  
  public void remove (int v1)
  {
    MyNode curr = head;
    MyNode prev = null;
    
    while ((curr != null) && (curr.elem != v1))
    {
      prev = curr;
      curr = curr.next;
    }
    
    if ( curr == null )
    {
      // v1 does not occur in the list
      System.out.println("Value: " + v1 + " is not a path from the current airport.");
      return;
    }
    
    if ( prev == null )
    {
      head = curr.next;
    }
    else
    {
      prev.next = curr.next;
    }
  } // End of remove(int v1)
  
  public int size()
  {
    MyNode tmp = head;
    int i = 0;
    while(tmp != null)
    {
      i++;
      tmp = tmp.next;
    }
    
    return i;
  }
  
  public int getNthElem( int n)
  {
    MyNode tmp = head;
    int i = 0;
    
    while (tmp != null)
    {
      if (i == n)
         return tmp.elem;
      i++;  
      tmp = tmp.next;
    }
    return -999;
  }
  
  public boolean isVisited()
  {
    return listVisit;
  }
  
  public void notVisited()
  {
   listVisit = false; 
  }
  
  public void nowVisited()
  {
   listVisit = true;
  }
  
} //End of class MyList

class MyNode
{
 int elem;
 MyNode next;
 
 MyNode(int v1)
 {
   elem = v1;
   next = null;
 }

} // End of MyNode



