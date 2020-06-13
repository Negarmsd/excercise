import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**this class is a very basic GUI exercise.we get the name of the Game player print the name and goes to a new window and say hi to player.
 */
class fullscreen{
	public static void main(String[] args) {
	 screen test = new screen();
	}
}
class screen implements ActionListener {
        private static JFrame fenster;
        private static JLabel label;
        private static JLabel user;
        private static JPanel panel;
        private static JTextField name;
        private static JButton b1 ;
	private JFrame game;
	private JPanel p;
        private JLabel message;
    
        public screen() {

                fenster = new JFrame();
                fenster.setTitle("Game");
                fenster.setSize(400,350);
                fenster.setLocation(100,100);
                fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                label = new JLabel("have fun playing");
                label.setBounds(10,10,100,20);
                label.setForeground(Color.PINK);

                panel = new JPanel();
                panel.setLayout(null);
                panel.setBackground(Color.BLACK);

                user = new JLabel("name");
                user.setBounds(10,50,80,25);
                user.setForeground(Color.PINK);

                name = new JTextField(10);
                name.setBounds(60,50,165,25);

                b1 = new JButton("start");
                b1.setBounds(100,100,200,50);
                b1.setBackground(Color.PINK);
                b1.addActionListener(this);

                panel.add(user);
                panel.add(name);
                panel.add(label);
                panel.add(b1);
                fenster.add(panel, BorderLayout.CENTER);
                fenster.setVisible(true);


                game = new JFrame();
		game.setTitle("2th");
                game.setSize(400,350);
                game.setLocation(100,100);
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                p = new JPanel();
                p.setLayout(null);
                p.setBackground(Color.BLACK);

		message =  new JLabel("hey");
		message.setBounds(10,10,100,20);
                message.setForeground(Color.PINK);
                p.add(message);
                game.add(p);
                //game.setVisible(true);

        }



        public void actionPerformed (ActionEvent e) {
                fenster.setVisible(false);
                String playerName = name.getText();
                game.setVisible(true);
                System.out.println(playerName);
        }
}



