package spring.jpa.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.jpa.example.model.Admin;
import spring.jpa.example.repository.AdminRepository;

@Component
public class SpringJpaBootStrapConfig implements ApplicationListener<ContextRefreshedEvent> {
    private AdminRepository adminRepository;
    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadAdmin();
    }
    public void loadAdmin(){
        Admin admin = new Admin();
        admin.setFirstName("Edgar");
        admin.setLastName("Garcia");
        admin.setEmail("example@spring.com");
        admin.setPassword("admin123");
        admin.setPhone("12345678");
        admin.setId((long) 1);
        adminRepository.save(admin);

        Admin admin2 = new Admin();
        admin2.setFirstName("Pepe");
        admin2.setLastName("Garcia");
        admin2.setEmail("example@spring2.com");
        admin2.setPassword("admin123");
        admin2.setPhone("12345678");
        admin2.setId((long) 2);
        adminRepository.save(admin2);
    }

}
