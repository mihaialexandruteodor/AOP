import com.unibuc.model.Product;
import com.unibuc.service.ProductManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
       // AppConfig config = new AppConfig();

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        ProductManager manager = context.getBean(ProductManager.class);

        manager.createProduct(new Product());
    }
}
