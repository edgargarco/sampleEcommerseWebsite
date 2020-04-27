package spring.jpa.example.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import spring.jpa.example.model.Admin;
import spring.jpa.example.model.Customer;
import spring.jpa.example.repository.AdminRepository;
import spring.jpa.example.service.AdminService;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private static Log log = LogFactory.getLog(AdminServiceImpl.class);
    @Autowired
    public void setAdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin findByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Admin findOne(long id) {
        return adminRepository.getOne(id);
    }

    @Override
    public Admin find(Admin entity) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> create(Admin entity) {
        Admin admin =  adminRepository.findByEmail(entity.getEmail());

        if (admin == null){
            adminRepository.save(entity);
            return Optional.ofNullable(entity);
        }else {
            log.info("Entity with email "+entity.getEmail()+" already exist");
            return Optional.ofNullable(entity);
        }
    }

    @Override
    public Admin update(Admin entity) {
        return null;
    }

    @Override
    public void delete(Admin entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
