/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication14;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author chris
 */
public class FXMLDocumentController implements Initializable {
    private boolean[] taken;
    private int counter;
    private char victory;
    private boolean end;
    @FXML
    private Label lb;
      @FXML
    private Label lb1;
        @FXML
    private Label lb2;
    @FXML
    private Button b0;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;


    public FXMLDocumentController() {
        taken=new boolean[10];
        for(int i=0;i<=9;i++){this.taken[i]=false;}
        counter=0;
        victory='n';
        end=false;
       
      
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        int index=Integer.parseInt(event.getTarget().toString().substring(11,12));
        System.out.println(index);
        if(index==0){resetStuff();}else{
        if(end){return;}
        if(!taken[index])game(index);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void resetStuff(){
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        for(int i=1;i<=9;i++){this.taken[i]=false;}
        counter=0;
        end=false;
        lb.setText("VS");
        lb1.setText("Player");
        lb2.setText("PC");
        victory='n';
    }

    private void game(int index) {
        counter++;
       //οταν καλειται παιζει ο παιχτης αρα
         buttons(index,"x");
//        //check if it wins
            check();
       if(victory=='n'){endgame();}
         if(iaf())buttons(GetInput(),"o");
         check();
//        //check if it wins
//        //check if 5 turns h
        if(counter>4 || victory!='n'){endgame();}
 
    }
    private void  buttons(int index,String s){
        switch(index){
            case 1:b1.setText(s);taken[1]=true;break;
            case 2:b2.setText(s);taken[2]=true;break;
            case 3:b3.setText(s);taken[3]=true;break;
            case 4:b4.setText(s);taken[4]=true;break;
            case 5:b5.setText(s);taken[5]=true;break;
            case 6:b6.setText(s);taken[6]=true;break;
            case 7:b7.setText(s);taken[7]=true;break;
            case 8:b8.setText(s);taken[8]=true;break;
            case 9:b9.setText(s);taken[9]=true;break;
        
        }
    }
   
    private int GetInput() {
            int ci=0;
            boolean notValid=true;
            while(notValid){
            ci=(int)(Math.random()*9+1);
                //System.out.println("thesi kakoy "+ci+taken[ci]);
            if(taken[ci]==false){notValid=false;}//ελεγχος αν ειναι κενη η θεση
           }
            
            return ci;
       }
    private boolean iaf(){
        return !(taken[1]&&taken[2]&&taken[3]&&taken[4]&&taken[5]&&taken[6]&&taken[7]&&taken[8]&&taken[9]);
    }
    private void endgame() {
        end=true;
        switch(victory){
            case 'x':
                lb.setText("");
                lb2.setText("");
                break;
            case 'o':
                lb.setText("");
                lb1.setText("");
                break;
            default:
        }
    }
    private void check(){
        boolean c[] = new boolean[16];
        String s1 =b1.getText();String s2 =b2.getText();String s3 =b3.getText();
        String s4 =b4.getText();String s5 =b5.getText();String s6 =b6.getText();
        String s7 =b7.getText();String s8 =b8.getText();String s9 =b9.getText();
        c[0] = s1=="x"&& s2=="x" && s3=="x";
        c[1] = s4=="x"&& s5=="x" && s6=="x";
        c[2] = s7=="x"&& s8=="x" && s9=="x";
        
        c[3] = s1=="x"&& s4=="x" && s7=="x";
        c[4] = s2=="x"&& s5=="x" && s8=="x";
        c[5] = s3=="x"&& s6=="x" && s9=="x";
        
        c[6] = s1=="x"&& s5=="x" && s9=="x";
        c[7] = s3=="x"&& s5=="x" && s7=="x";
        
        c[8] = s1=="o"&& s2=="o" && s3=="o";
        c[9] = s4=="o"&& s5=="o" && s6=="o";
        c[10] = s7=="o"&& s8=="o" && s9=="o";
        
        c[11] = s1=="o"&& s4=="o" && s7=="o";
        c[12] = s2=="o"&& s5=="o" && s8=="o";
        c[13] = s3=="o"&& s6=="o" && s9=="o";
        
        c[14] = s1=="o"&& s5=="o" && s9=="o";
        c[15] = s3=="o"&& s5=="o" && s7=="o";
        for(int i=0;i<=7;i++){if(c[i]){victory='x';System.out.println(i+"thesi nikis");}}
        for(int i=8;i<=15;i++){if(c[i]){victory='o';System.out.println(i+"thesi nikis");}}
      
    
    }
    
}
