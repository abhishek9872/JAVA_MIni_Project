import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.ColorUIResource;

class Tictactoe extends Frame implements ActionListener
{
    MyButton btn[]=new MyButton[9];
    int count=0;
    Label lb1,lb2,lb3;
    public Tictactoe()
    {
        int x,y,count;
        x=10;
        y=100;
        count=0;
        setLayout(null);
        lb1 = new Label("Player 1 Turn...");
        lb2 = new Label("Symbol : X");
        lb1.setBounds(20,30,100,25);
        lb2.setBounds(20,60,80,25);
        lb1.setFont(new Font("Arial",Font.PLAIN,16));
        lb2.setFont(new Font("Arial",Font.PLAIN,16));
        add(lb1);add(lb2);
        for(int i=0;i<=8;i++)
        {
            btn[i] = new MyButton("");
            btn[i].setLocation(x,y);
            add(btn[i]);
            count+=1;
            x=x+70;
            if(count==3 || count ==6)
            {
                x=10;
                y=y+70;
            }
        }
        btn[0].addActionListener(this);
        btn[1].addActionListener(this);
        btn[2].addActionListener(this);
        btn[3].addActionListener(this);
        btn[4].addActionListener(this);
        btn[5].addActionListener(this);
        btn[6].addActionListener(this);
        btn[7].addActionListener(this);
        btn[8].addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        int i;
        Object ob = ae.getSource();
        if(ob==btn[0])
        {
            i = 0;
        }
        else if(ob==btn[1])
        {
            i = 1;
        }
        else if(ob==btn[2])
        {
            i = 2;
        }
        else if(ob==btn[3])
        {
            i = 3;
        }
        else if(ob==btn[4])
        {
            i = 4;
        }
        else if(ob==btn[5])
        {
            i = 5;
        }
        else if(ob==btn[6])
        {
            i= 6;
        }
        else if(ob==btn[7])
        {
            i = 7;
        }
        else
        {
            i = 8;
        }
        if(btn[i].getLabel()=="")
        {
            count++;
            if(count%2==1)
            {
                btn[i].setLabel("X");
                lb1.setText("Player 2 Turn...");
                lb2.setText("Symbol : O");
            }
            else
            {
                btn[i].setLabel("O");
                lb1.setText("Player 1 Turn...");
                lb2.setText("Symbol : X");
            }
            btn[i].setBackground(new ColorUIResource(255, 204, 203));
            if(count>=5)
            {
                CheckWinner();
            }
        } 
    }
    int k = 0;
    public void makeGreen(int m,int n,int l)
    {
        btn[m].setBackground(new ColorUIResource(144, 238, 144));
        btn[n].setBackground(new ColorUIResource(144, 238, 144));
        btn[l].setBackground(new ColorUIResource(144, 238, 144));
    }
    public void CheckWinner()
    {
        if(btn[0].getLabel()==btn[1].getLabel() && btn[0].getLabel()==btn[2].getLabel() && btn[0].getLabel()!="")
        {
            k++;
            String s = btn[0].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(0, 1, 2) ;}
        }
        else if(btn[3].getLabel()==btn[4].getLabel() && btn[3].getLabel()==btn[5].getLabel() && btn[3].getLabel()!="")
        {
            k++;
            String s = btn[3].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(3, 4, 5) ;}
        }
        else if(btn[6].getLabel()==btn[7].getLabel() && btn[6].getLabel()==btn[8].getLabel() && btn[6].getLabel()!="")
        {
            k++;
            String s = btn[6].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(6, 7, 8) ;}
        }
        else if(btn[0].getLabel()==btn[3].getLabel() && btn[0].getLabel()==btn[6].getLabel() && btn[0].getLabel()!="")
        {
            k++;
            String s = btn[0].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(0, 3, 6) ;}
        }
        else if(btn[1].getLabel()==btn[4].getLabel() && btn[1].getLabel()==btn[7].getLabel() && btn[1].getLabel()!="")
        {
            k++;
            String s = btn[1].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(4, 1, 7) ;}
        }
        else if(btn[2].getLabel()==btn[5].getLabel() && btn[2].getLabel()==btn[8].getLabel() && btn[2].getLabel()!="")
        {
            k++;
            String s = btn[2].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(5, 8, 2) ;}
        }
        else if(btn[0].getLabel()==btn[4].getLabel() && btn[0].getLabel()==btn[8].getLabel() && btn[0].getLabel()!="")
        {
            k++;
            String s = btn[0].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(0, 4, 8) ;}
        }
        else if(btn[2].getLabel()==btn[4].getLabel() && btn[2].getLabel()==btn[6].getLabel() && btn[2].getLabel()!="")
        {
            k++;
            String s = btn[2].getLabel();
            setWinner(s);
            if(k == 1) { makeGreen(4, 6, 2) ;}
        }
        int i,count1 = 0;
        for(i = 0;i<=8;i++)
        {
            if(btn[i].getLabel()!="")
            {
                count1++;
            }
        }
        if(count1==9)
        {
            setDraw();
        }
    }
    public void setDraw()
    {
        lb3 = new Label("Match Drawn");
        lb3.setFont(new Font("Arial",Font.BOLD,20));
        lb3.setBounds(240,210,200,25);
        add(lb3);
    }
    public void setWinner(String s)
    {
        
        int numb;
        if(s=="X")
        {
            numb = 1;
        }
        else
        {
            numb = 2;
        }
        lb3 = new Label("Player "+numb+" Wins");
        lb3.setFont(new Font("Arial",Font.BOLD,20));
        lb3.setBounds(240,210,200,25);
        add(lb3);
    }
    class MyButton extends Button
    {
        public MyButton(String s)
        {
            super(s);
            setFont(new Font("Arial",Font.BOLD,28));
            setSize(70,70);
        }
    }
    public static void main(String args[])
    {
        Tictactoe g = new Tictactoe();
        g.setTitle("TicTacToe");
        g.setVisible(true);
        g.setSize(400,400);
    }
}
