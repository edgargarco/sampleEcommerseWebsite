package spring.jpa.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring.jpa.example.model.Admin;
import spring.jpa.example.model.generics.Color;
import spring.jpa.example.repository.AdminRepository;
import spring.jpa.example.repository.ColorRepository;

@Component
public class SpringJpaBootStrapConfig implements ApplicationListener<ContextRefreshedEvent> {
    private AdminRepository adminRepository;
    private ColorRepository colorRepository;
    @Autowired
    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Autowired
    public void setColorRepository(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadColors();
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
    public void loadColors(){
        Color color = new Color();
        color.setId((long)1);
        color.setColor("dark");
        colorRepository.save(color);
        Color color2 = new Color();
        color2.setId((long)2);
        color2.setColor("ligth");
        colorRepository.save(color2);
        Color color3 = new Color();
        color3.setId((long)3);
        color3.setColor("pink");
        colorRepository.save(color3);
        Color color4 = new Color();
        color4.setId((long)4);
        color4.setColor("gray");
        colorRepository.save(color4);

        Color color5 = new Color();
        color5.setId((long)4);
        color5.setColor("red");
        colorRepository.save(color5);
    }

}
