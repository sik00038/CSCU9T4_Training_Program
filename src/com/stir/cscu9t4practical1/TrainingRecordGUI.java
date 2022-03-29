// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find all by Date");
    
    //Activities
    String[] activityList = { "Run", "Sprint", "Cycle", "Swim"};
    private JComboBox activity = new JComboBox(activityList);
    private JLabel activityDropDownMenu = new JLabel(" Activity:");

    //Sprint Options
    private JLabel repLabel = new JLabel("Repetitions: ");
    private JLabel recLabel = new JLabel("Recovery: ");
    private JTextField rep = new JTextField(2);
    private JTextField res = new JTextField(5); 
    
    //Cycle Options
    private JLabel terrainLabel = new JLabel(" Terrain: ");
    private JLabel tempoLabel = new JLabel(" Tempo: ");
    String[] tempoArray = { "Slow", "Moderate", "Fast"};
    private JComboBox tempoDropDown = new JComboBox(tempoArray);
    String[] terrainArray = { "Asphalt", "Concrete", "Stones", "Mountain"};
    private JComboBox terrainDropDown = new JComboBox(terrainArray);
  
    //Swim Options
    private JLabel whereLabel = new JLabel("Location: ");
    private JTextField whereTextBox = new JTextField(30);
    
    //remove
    private JButton remove = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        //name
        add(labn);
        add(name);
        name.setEditable(true);
        
        //activity
        add(activityDropDownMenu);
        add(activity);
        activity.setEditable(false);
        
        //day
        add(labd);
        add(day);
        day.setEditable(true);
        
        //month
        add(labm);
        add(month);
        month.setEditable(true);
        
        //year
        add(laby);
        add(year);
        year.setEditable(true);
        
        //hours
        add(labh);
        add(hours);
        hours.setEditable(true);
        
        //minutes
        add(labmm);
        add(mins);
        mins.setEditable(true);
        
        //seconds
        add(labs);
        add(secs);
        secs.setEditable(true);
        
        //dist
        add(labdist);
        add(dist);
        dist.setEditable(true);
        
        //rep and rec
        add(repLabel);
        add(rep);
        rep.setEditable(true);
        add(recLabel);
        add(res);
        res.setEditable(true);
        
        //terr and tempo
        add(terrainLabel);
        add(terrainDropDown);
        terrainDropDown.setEditable(true);
        add(tempoLabel);
        add(tempoDropDown);
        tempoDropDown.setEditable(true);
        
        //where
        add(whereLabel);
        add(whereTextBox);
        whereTextBox.setEditable(true);
        
        //add
        add(addR);
        addR.addActionListener(this);

        //ByDate
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        
        //FindByDate
        add(findAllByDate);
        findAllByDate.addActionListener(this);
 
        
        //remove
        add(remove);
        remove.addActionListener(this);

        //output
        add(outputArea);
        outputArea.setEditable(false);
        setSize(1020, 200);
        setVisible(true);
        blankDisplay();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Better closing!!!

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
        	message = lookupAllEntries();
        }
        if (event.getSource() == remove) {
        	message = removeEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String actType = String.valueOf(activity.getSelectedItem());
        String message = "Record added\n";
        System.out.println("Adding "+actType+" entry to the records");
        String n = name.getText();
        
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        
        switch(actType) {
        	case "Run": addRunEntry(n,d,m,y,h,mm,s,km); break;
        	case "Cycle": addCycleEntry(n,d,m,y,h,mm,s,km,String.valueOf(terrainDropDown.getSelectedItem()),String.valueOf(tempoDropDown.getSelectedItem())); break;
        	case "Sprint": addSprintEntry(n,d,m,y,h,mm,s,km,Integer.parseInt(rep.getText()),Integer.parseInt(res.getText())); break;
        	case "Swim": addSwimEntry(n,d,m,y,h,mm,s,km,whereTextBox.getText()); break; 
        }
        
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
 
 
    public String lookupAllEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("Searching...");
        String message = myAthletes.lookupAllByDate(d, m, y);
        return message;
    } //lookupAllEntries on a given date

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        rep.setText("");
        res.setText("");
        whereTextBox.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }
    private void addRunEntry(String n, int d, int m, int y, int h, int mm, int s, float km){
        //add entry
        Entry e = new Entry(n,d,m,y,h,mm,s,km);
        myAthletes.addEntry(e);
    }

    private void addCycleEntry(String n, int d, int m, int y, int h, int mm, int s, float km, String terr, String tempo){
        //add entry
        Entry e = new CycleEntry(n,d,m,y,h,mm,s,km,terr,tempo);
        myAthletes.addEntry(e);
    }

    private void addSprintEntry(String n, int d, int m, int y, int h, int mm, int s, float km, int rep, int res){
        //add entry
        Entry e = new SprintEntry(n,d,m,y,h,mm,s,km,rep,res);
        myAthletes.addEntry(e);
    }

    private void addSwimEntry(String n, int d, int m, int y, int h, int mm, int s, float km, String w){
        //add entry
        Entry e = new SwimEntry(n,d,m,y,h,mm,s,km,w);
        myAthletes.addEntry(e);
    }
    public String removeEntry(){
    	String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("Removing record...");
        String message = myAthletes.removeEntry(n, m, d, y);
        return message;
    }
} // TrainingRecordGUI

