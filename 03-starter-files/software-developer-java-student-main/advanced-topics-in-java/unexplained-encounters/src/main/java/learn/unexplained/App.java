package learn.unexplained;

import learn.unexplained.data.EncounterFileRepository;
import learn.unexplained.domain.EncounterService;
import learn.unexplained.ui.Controller;
import learn.unexplained.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
@PropertySource("classpath:data.properties")
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        Controller controller = context.getBean(Controller.class);

        controller.run();


//        ApplicationContext context = new ClassPathXmlApplicationContext("dependency-configuration.xml");
//
//        Controller controller = context.getBean(Controller.class);
//
//        controller.run();



//        EncounterFileRepository repository = new EncounterFileRepository("./data/encounters.csv");
//
//        EncounterService service = new EncounterService(repository);
//
//        View view = new View();
//        Controller controller = new Controller(service, view);
//
//        controller.run();

    }
}
