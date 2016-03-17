import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroDeBolas)
    {
        int ground = 400;   // position of the ground line
        Random random = new Random();
        ArrayList<BouncingBall> bolas = new ArrayList<>();
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        

        for (int index = 0; index<numeroDeBolas; index++) {
            // Se crean tres variables locales, una para cada color primario, 
            // eligiendo un número aleatorio desde el 0 al 254
            int rojo = random.nextInt(255);
            int verde = random.nextInt(255);
            int azul = random.nextInt(255);
            // Se crea un color nuevo con las variables de los colores e insrtarlo más tarde
            // ala hora de construir un objeto de la clase BouncingBall
            Color color = new Color(rojo,verde,azul);
            // crate and show the balls
            BouncingBall ball = new BouncingBall(random.nextInt(400), random.nextInt(400),random.nextInt(250), color, ground, myCanvas);
            ball.draw(); 
            bolas.add(ball);
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (BouncingBall bolaEnLista : bolas) {
                bolaEnLista.move();
            }
        }
    }
}
