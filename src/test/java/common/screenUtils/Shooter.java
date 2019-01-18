package common.screenUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Shooter {

    public static void takeScreenshot(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy_HHmmssSS");
        LocalDateTime now = LocalDateTime.now();
        takeScreenshot(dtf.format(now));
    }

    public static void takeScreenshot(String screenShotName){
        try {
            Robot r = new Robot();
            Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = r.createScreenCapture(capture);
            ImageIO.write(image, "jpg", new File("./screenshots/"+screenShotName+".png"));
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}
