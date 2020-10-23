package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.MenuItem;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.MenuItemRepository;

@SpringBootApplication
public class SpringMenuApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringMenuApplication.class, args);
	}
	
	@Autowired
	MenuItemRepository repo;

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		
		MenuItem b = appContext.getBean("menuItem",MenuItem.class);
		b.setDescription("A standard American Classic");
		repo.save(b);
		
		MenuItem p = new MenuItem("12\" Pizza","Thin crust favorite!","Cheese, Sasauge, Peperoni", 10.99);
		repo.save(p);
		
		List<MenuItem> fullMenu	= repo.findAll();
		
		for(MenuItem item: fullMenu) {
			System.out.println(item.toString());
		}
		
		((AbstractApplicationContext) appContext).close();
	}

}
