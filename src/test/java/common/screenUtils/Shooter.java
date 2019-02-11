package common.screenUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Shooter {

    private static String fileSeperator = System.getProperty("file.separator");
    private static String screenshotPath = System.getProperty("user.dir") +fileSeperator+ "screenshots";

    public static void takeScreenshot(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy_HHmmssSS");
        LocalDateTime now = LocalDateTime.now();
        takeScreenshot(dtf.format(now));
    }

    public static void takeScreenshot(String screenShotName){
        File screenshotDirectory = new File(screenshotPath);
        if(!screenshotDirectory.exists()){
            screenshotDirectory.mkdir();
        }

        try {
            Robot r = new Robot();
            Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = r.createScreenCapture(capture);
            File file = new File(screenshotPath, screenShotName+".jpg");
            ImageIO.write(image, "jpg", file);
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}
