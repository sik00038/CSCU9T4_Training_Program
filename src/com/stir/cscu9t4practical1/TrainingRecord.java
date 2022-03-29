// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) 
             result = current.getEntry();
          }
       return result;
   } // lookupEntry returns the last entry with the given date

    // look up all the entries of a given day and month
    public String lookupAllByDate (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        
        String result = "";
        
        while (iter.hasNext()) {
            Entry current = iter.next();
            //need to make sure they all have the same date!
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
            	result += current.getEntry() + "\n";
        }
        //no results?
        if(result.equals("")){
        	result = "Search failed";
        }
        //return the string back to the message String in the gui
        return result.toString();
    }//loopupAllByDate 
    public String removeEntry (String n, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result=""; //create a StringBuilder to concatenate a string with entries on that date
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
                iter.remove();
                result = "Removing successfully";
            }
        }
        //2
        if(result.equals("")){
            result = "Error: No Entries found!";
        }
        return result;
    } 
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord