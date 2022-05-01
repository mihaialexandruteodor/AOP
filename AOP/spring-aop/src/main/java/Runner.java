
import com.unibuc.controller.MainFXClass;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Runner {

   public static void main(String[] args) {
       Application.launch(MainFXClass.class, args);

    }
}
