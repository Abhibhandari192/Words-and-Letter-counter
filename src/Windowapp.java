import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Windowapp extends JFrame implements ActionListener{
	
	JTextField tf;
	JButton bt_words,bt_letter,reset;
	JLabel lb;
	
	byte count=0;
	public Windowapp() {
		
		JFrame jf=new JFrame();
		
		tf=new JTextField();
		tf.setBounds(20,20,250,30);
		
		lb=new JLabel();
		lb.setBounds(20, 150, 250, 40);
		
		bt_words=new JButton("Count words");
		bt_words.setBounds(20, 60, 110, 40);
		bt_words.addActionListener(this);
		
		bt_letter=new JButton("Count letters");
		bt_letter.setBounds(160, 60, 110, 40);
		bt_letter.addActionListener(this);
		
		reset=new JButton("Reset");
		reset.setBounds(20, 110, 250, 40);
		reset.addActionListener(this);
		
		jf.add(tf);
		jf.add(bt_words);
		jf.add(bt_letter);
		jf.add(reset);
		jf.add(lb);
		jf.setSize(300,250);
		jf.setLayout(null);
		jf.setVisible(true);
		
			
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
			
		/* Calculate number of words */
		
		if(e.getSource()==bt_words)
		{
			count=0;
			
			/* Following 4 lines checks if text contains special or numerical character which is not considered as words*/
			Pattern p=Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
			String text=tf.getText().toString();
			Matcher m = p.matcher(text);
			boolean b=m.find();
			
			char first = text.charAt(0),ch,as;
			
			for(int i=0;i<(text.length()-1);i++)
			{
				/* Space followed by letter is considered as word */ 
				 ch=text.charAt(i);
				 as=text.charAt((i+1));
												 
	            if(ch==' ' && Character.isLetter(as))
	            count++;
	            	             	            
			}
			
			if(text.length()>0 && !b)
			{				
				lb.setText("No of words: "+(count));	
				
				/* This condition is used to tackle inputs like "_ball" where words=1 */
				
				if(Character.isLetter(first))
					lb.setText("No of words: "+(count+1));	
			}
			else if(b)
				lb.setText("Invalid text input.");
			else
				lb.setText("No of words: "+count); 
			
			
			
		}
		
		/* Calculate number of Letters */
		
		if(e.getSource()==bt_letter)
		{
			count=0;
			String text=tf.getText().toString();
			
			for(int i=0;i<text.length();i++)
			{
				char ch=text.charAt(i);
	            if(ch==' ')
	            count++;
			}
			
			lb.setText("No of Letters: "+(text.length()-count));
			
			
		}
		
		
		/* make text label blank */
		
		if(e.getSource()==reset)
		{
			
			tf.setText("");
			lb.setText("");
						
		}
		
		
	}
	
	public static void main(String a[])
	{
		Windowapp w=new Windowapp();
			
	}

	
}
