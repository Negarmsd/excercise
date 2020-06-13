import java.awt.Canvas;
import java.util.Random;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Game extends Canvas implements Runnable {
        public static final int WIDTH = 600,HEIGHT = 363;
        private Thread  thread;
        private boolean running = false;
	public Window window;
	private Keyboard key;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	int x =0, y = 0;
        public Game(){
		window = new Window(WIDTH,HEIGHT, "5th wins", this);
        	key = new Keyboard();
		addKeyListener(key);
	}

        public synchronized void start(){
                thread = new Thread(this);
		running = true;
                thread.start();


        }
        public synchronized void stop(){
                try{
                        thread.join();
                        running = false;
                }catch(Exception e){
                        e.printStackTrace();
                }

        }


        public void run(){
                long lastTime = System.nanoTime();
                double amountOfTicks = 60.0;
                double ns = 1000000000 / amountOfTicks;
                double delta = 0;
                long timer = System.currentTimeMillis();
                int frames = 0;
		requestFocus();
                while(running){
                        long now = System.nanoTime();
                        delta += (now - lastTime) / ns;
                        lastTime = now;
                        while(delta >=1){

                                tick();
                                delta--;
                        }
                        if(running)
                                render();
                        frames++;
                        if(System.currentTimeMillis() - timer > 1000) {
                                timer += 1000;
                                System.out.println("FPS: " +frames);
                                frames = 0;
                        }
                }
                stop();


        }
        private void tick(){
		key.update();
		if(key.up) y++;
		if(key.down) y--;
		if(key.left) x++;
		if(key.right)x--;

        }

        private void render(){
                BufferStrategy bs = this.getBufferStrategy();
                if(bs == null){
			
                        this.createBufferStrategy(3);
                        return;
                }
		window.clear();
		window.render(x,y);
		for(int i = 0; i< pixels.length; i++){
			pixels[i] = window.pixels[i];
		}

                Graphics g = bs.getDrawGraphics();
               	g.drawImage(image,0,0,WIDTH,HEIGHT, null);
		g.dispose();
                bs.show();

        }


        public static void main(String[] args){
		Game game = new Game();
        }
}

class Window extends Canvas{
        private JFrame frame;
	public static int width;
	public static int height;
        public int[] pixels;
	private final int MAP_SIZE = 16;
	private final int MAP_SIZE_MASK = MAP_SIZE -1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private Random random = new Random();

	public Window(int width, int height, String title, Game game){
		this.width = width;
		this.height =height;
		pixels = new int[width * height];


		for (int i = 0; i < tiles.length; i++) {
                tiles[i] =  random.nextInt(0xffffff);
		}

                frame = new JFrame(title);
                frame.setPreferredSize(new Dimension(width,height));
                frame.setMaximumSize(new Dimension(width, height));
                frame.setMinimumSize(new Dimension(width, height));

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.add(game);
                frame.setVisible(true);
                game.start();
		
	}
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	public void render(int xOffset, int yOffset) {
		for (int y = 0; y< height; y++) {
			int yy = y + yOffset;
		//	if(y < 0 || y >= height) break;
			for(int x = 0; x < width; x++) {
				int xx =x + xOffset;
		//		if(x < 0 || x >= width) break;
				int index = ((xx >>4) & MAP_SIZE_MASK) + ((yy >>4) & MAP_SIZE_MASK)* MAP_SIZE;
				pixels[ x + y * width] = tiles[index];			}
		}
	}

}
class Keyboard implements KeyListener {
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right;

	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		/*for (int i = 0; i< keys.length; i++) {
			if( keys[i] == true) 
				System.out.print("  " +i);
		}*/
	
	}
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}


	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}
	public void keyTyped(KeyEvent e) {

	}

}

