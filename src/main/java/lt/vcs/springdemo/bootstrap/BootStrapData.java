package lt.vcs.springdemo.bootstrap;

import lt.vcs.springdemo.repository.CustomerRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        customerRepository.findAll().forEach(
                elementas -> {
                    // some code logic
                    System.out.println(elementas);
                }
        );
        System.out.println("\n======================\n");

        System.out.println(
                customerRepository.findById(141)
        );
    }
}
