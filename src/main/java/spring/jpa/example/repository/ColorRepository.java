package spring.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.jpa.example.model.generics.Color;
import spring.jpa.example.model.generics.Tag;

public interface ColorRepository extends JpaRepository<Color,Long> {
    @Query("SELECT u FROM Color u WHERE u.color = :color ")
    Color getColorByName(String color);
}
