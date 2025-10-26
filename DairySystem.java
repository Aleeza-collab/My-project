package ProjectPhase1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class DiaryEntry{
    private final String title;
    private final String content;
    private String formattedDate; // store as formatted string

    public DiaryEntry(String title,String content,String dateInput){
        this.title=title;
        this.content=content;
        setFormattedDate(dateInput); // format date when entry is created
    }

    // Method to handle date formatting
    private void setFormattedDate(String dateInput){
        SimpleDateFormat inputFormat=new SimpleDateFormat("dd-MM-yyyy");
        inputFormat.setLenient(false); // makes sure invalid dates are caught

        try{
            Date date=inputFormat.parse(dateInput); // converts text to Date
            this.formattedDate=inputFormat.format(date); // reformat and store neatly
        } catch(Exception e){
            System.out.println("Invalid date! Using today's date instead.");
            Date today=new Date();
            SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
            this.formattedDate=formatter.format(today);
        }
    }

    public String displayEntry(){
        return "Date: "+formattedDate+"\nTitle: "+title+"\nContent: "+content;
    }
}

// Diary class manages all entries
class Diary{
    private DiaryEntry[] entries;
    private int count;

    // Constructor (fixed size=30)
    public Diary(int size) {
        entries=new DiaryEntry[size];
        count=0;
    }

    // Add new entry
    public void addEntry(DiaryEntry entry){
        if(count<entries.length){
            entries[count] =entry;
            count++;
            System.out.println("Entry added successfully!");
        } else {
            System.out.println("Diary is full. Cannot add more entries!");
        }
    }

    // View all diary entries
    public void viewEntries(){
        if(count==0){
            System.out.println("No entries yet!");
        } else {
            for(int i=0;i < count;i++) {
                System.out.println(entries[i].displayEntry());
            }
        }
    }

    // Return number of entries
    public int getCount(){
        return count;
    }
}

