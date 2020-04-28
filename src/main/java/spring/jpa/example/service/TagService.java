package spring.jpa.example.service;

import org.springframework.data.jpa.repository.Query;
import spring.jpa.example.model.generics.Tag;
import spring.jpa.example.service.generic.IOperations;

public interface TagService extends IOperations<Tag> {

    Tag getTagByNameAnd(String tagName);
}
