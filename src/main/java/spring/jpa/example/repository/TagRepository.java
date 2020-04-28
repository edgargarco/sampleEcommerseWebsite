package spring.jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.jpa.example.model.generics.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
    @Query("SELECT u FROM Tag u WHERE u.tag = :tagName ")
    Tag getTagByNameAnd(String tagName);
}
