package neu.edu.csye6220.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {
        "neu.edu.csye6220.finalproject.config",
        "neu.edu.csye6220.finalproject.controller",
        "neu.edu.csye6220.finalproject.dao",
        "neu.edu.csye6220.finalproject.service"})
public class FinalProjectApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(FinalProjectApplication.class, args);
    }

}