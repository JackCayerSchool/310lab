
//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class gui implements ActionListener {
    
    // CHATBOT VARS
    static boolean askedHowAreYou = false;
    static boolean askedHowAreYouFeeling = false;
    static boolean askedDoctor = false;
    static boolean askedName = false;
    static int responsesTillDoctor = 0;
    public static void main(String args[]) {

        
        // Rand num gen
        Random rand = new Random();

        //Creating the Frame
        JFrame frame = new JFrame("Unlonley");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m2 = new JMenu("Help");
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Report a bug");
        JMenuItem m22 = new JMenuItem("Contact Authorities");
        m2.add(m11);
        m2.add(m22);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(20); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        

        // Text Area at the Center
        JTextArea ta = new JTextArea();
        ta.setEditable(false);

        //Adding Components to the frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        tf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){  
               String a = tf.getText();
               ta.append("You: " + a + "\n\n");
               String b = response(a.toLowerCase(), rand);
            ta. append("Mr.Lonely: "+ b + "\n\n");
               tf.setText("");
            }

   
    });}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    public static String response(String a, Random rand){
        responsesTillDoctor++;
        // Hello check || Make sure not asking how they are
        if((a.contains("hello") || a.contains("hi") || a.contains("hey")) && !a.contains("how")){
            askedHowAreYou = true;
            return "Hello! How are you?";
        }

        // how are you check
        // askedHowAreYou is a boolean that is true if you askedHowAreYou
        // askedHowAreYouFeeling is a boolean that is true if you askedHowAreYouFeeling
        if(a.contains("how are you")){
            if(askedHowAreYou == true){
                askedHowAreYouFeeling = true;
                return "I am good! How have you been feeling lately?";
            } else {
                askedHowAreYou = true;
                return "I am good, how are you?";
            }
        }

        if(a.contains("lonely") || a.contains("depressed") || a.contains("sad") || a.contains("not") && (a.contains("good") || a.contains("happy"))){
            
            int amtResponse = 3;
            int randNum = rand.nextInt(amtResponse);
            switch (randNum) {
                case 0:
                    return "Oh and what has been making you feel this way?";
                case 1:
                    return "I'm sorry to hear that do you want to talk about it?";
                case 2:
                    return "I understand how you are feeling, let's talk about it.";
                default:
                    return "OUT OF BOUNDS?!";
            }
        }

        if(a.contains("good")){
            int amtResponse = 2;
            int randNum = rand.nextInt(amtResponse);
            switch (randNum) {
                case 0:
                    return "I'm glad to hear that.";
                case 1:
                    return "Oh thats good!";
                default:
                    return "OUT OF BOUNDS?!";
            }
        }

        if (a.contains("thank")){
            int amtResponse = 2;
            int randNum = rand.nextInt(amtResponse);
            switch (randNum) {
                case 0:
                    return "You're welcome.";
                case 1:
                    return "No Worries.";
                default:
                    return "OUT OF BOUNDS?!";
            }
        }

        if (a.contains("death") || a.contains("suicide") || a.contains("kill")){
            responsesTillDoctor = 0;
            askedDoctor = true;
            return "I think we should talk about this in person do you want me to recommend you to a doctor?";
        }

        if (a.contains("yes") && responsesTillDoctor == 1 && askedDoctor == true){
            return "Ok here is the details xxxx.xxxx at xxxx on xxx at xxx";
        }

        if (a.contains("name") && !a.contains("my")){
            askedName = true;
            return "My name is Unlonely what's yours?";
        }

        if (askedName == true || (a.contains("my") && a.contains("name"))){
            askedName = false;
            return "Thats an amazing name!";
        }

        if (a.contains("bye") || a.contains("go") || a.contains("leave")){
            return "Bye! Talk again soon?";
        }

        return "Sorry I did not understand. Can you say it in a different way?";
    }
}

