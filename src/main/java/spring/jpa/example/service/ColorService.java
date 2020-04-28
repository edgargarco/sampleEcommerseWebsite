package spring.jpa.example.service;

import spring.jpa.example.model.generics.Color;
import spring.jpa.example.model.generics.Tag;
import spring.jpa.example.service.generic.IOperations;

public interface ColorService extends IOperations<Color> {
    Tag getColorByName(String color);
}
