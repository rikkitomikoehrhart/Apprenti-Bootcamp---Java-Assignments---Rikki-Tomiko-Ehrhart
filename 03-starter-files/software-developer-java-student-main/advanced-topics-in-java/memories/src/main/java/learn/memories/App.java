package learn.memories;

import learn.memories.data.MemoryFileRepository;
import learn.memories.domain.MemoryService;
import learn.memories.ui.ConsoleIO;
import learn.memories.ui.Controller;
import learn.memories.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@ComponentScan // 2. Tells Spring to scan all classes in this package or its children.
@PropertySource("classpath:data.properties")
public class App {

    public static void main(String[] args) {

        // 1. We pass the App.class, this class, as a constructor argument
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        // 3. The context works the same as the XML context.
        Controller controller = context.getBean(Controller.class);

        // Run the app!
        controller.run();









        //        ApplicationContext context = new ClassPathXmlApplicationContext("dependency-configuration.xml");
//
//        Controller controller = context.getBean(Controller.class);
//
//        // Run the app!
//        controller.run();





        //        // "./data/memories.txt" is the path to our "production" data file.
//        MemoryFileRepository repository = new MemoryFileRepository("./data/memories.txt");
//        // repository satisfies the MemoryRepository dependency.
//        MemoryService service = new MemoryService(repository);
//
//        ConsoleIO io = new ConsoleIO();
//        // io satisfies the TextIO dependency.
//        View view = new View(io);
//
//        // view satisfies the View dependency
//        // service satisfies the MemoryService dependency
//        Controller controller = new Controller(view, service);
//
//        // Run the app!
//        controller.run();
    }

}
