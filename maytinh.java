import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class maytinh extends Frame implements ActionListener
{ 
	private TextField display;
	private double arg =0;
	private String op = "=";
    private boolean start = true;
	public maytinh()
	{
		setTitle("Calculator");
		setSize(400,500);
		setLayout(new BorderLayout());
		display = new TextField("0");
		display.setEditable(false);
		add(display,"North");
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,4));
		String buttons[]= {"7","8","9","/",
				           "4","5","6","=*",
				           "1","2","3","-",
				           ".","0","=","+"};
		for(int i=0 ; i<buttons.length;i++) {
			Button button = new Button(buttons[i]);
			p.add(button);
			button.addActionListener(this);
		}
			add(p, "Center");
			addWindowListener(new WindowAdapter()
		     {
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
					
				}
		     }
			);
	} 
	public void actionPerformed(ActionEvent evt)
	{
		String s = evt.getActionCommand();
		if('0'<= s.charAt(0)&& s.charAt(0) <= '9'|| s.equals("."))
		{
			if(start)
			{
				display.setText(s);
			}
			else {
				display.setText(display.getText()+s);
			}
			start = false;
		}
		else
		{
			if(start)
			{
				if(s.equals("-"))
				{
					display.setText(s);
				    start = false;
			 }
			  else
		    	{
				op = s;
			}
		}
	    	else
		{
			double x = Double.parseDouble(display.getText());
			maytinh(x);
			op=s;
			start = true;
		}
	}
}
  public void maytinh(double n)
  {
	  if(op.equals("+"))
	  {
		  arg += n;
	  }
	  else if(op.equals("-"))
	  {
		 arg -=n; 
	  }
	  else if(op.equals("*"))
	  {
		  arg *=n;
	  }
	  else if(op.equals("/"))
	  {
		  arg /=n;
	  }
	  else if(op.equals("="))
	  {
		  arg = n;
	  }
	  display.setText("" + arg);
  }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     maytinh frame = new maytinh();
     frame.show();
	}

}
