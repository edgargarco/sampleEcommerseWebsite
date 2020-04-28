package spring.jpa.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import spring.jpa.example.model.generics.Color;
import spring.jpa.example.model.generics.Tag;
import spring.jpa.example.repository.ColorRepository;
import spring.jpa.example.service.ColorService;

import java.util.List;
import java.util.Optional;

public class ColorServiceImpl implements ColorService {
    private ColorRepository colorRepository;
    @Autowired
    public void setColorRepository(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public Tag getColorByName(String color) {
        return null;
    }


    @Override
    public Color findOne(long id) {
        return null;
    }

    @Override
    public Color find(Color entity) {
        return null;
    }

    @Override
    public List<Color> findAll() {
        return null;
    }

    @Override
    public Optional<Color> create(Color entity) {
        return Optional.ofNullable(colorRepository.save(entity));
    }

    @Override
    public Color update(Color entity) {
        return null;
    }

    @Override
    public void delete(Color entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
