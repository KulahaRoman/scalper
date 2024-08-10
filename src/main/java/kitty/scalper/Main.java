package kitty.scalper;

import kitty.scalper.config.GreatestConfigEver;
import kitty.scalper.core.Scalper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GreatestConfigEver.class);
        var scalper = context.getBean(Scalper.class);
        try {
            scalper.run();
        } catch (Exception e) {
            System.out.println("Critical error occurred: " + e.toString());
        }
    }
}