package personalfinance;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import personafinance.settings.Text;
public class PersonalFinance {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        init();
    }
    private static void init() {
        Text.init();
        try {
            GraphicsEnvironment ge = GraphichsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Light.ttf")));
        }
        catch(FontFormatException | IOException ex) {
            Logger.getLogger(PersonalFinance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}