package spring.jpa.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.jpa.example.model.generics.Tag;
import spring.jpa.example.repository.TagRepository;
import spring.jpa.example.service.TagService;

import java.util.List;
import java.util.Optional;

public class TagServiceImpl implements TagService {
    private TagRepository tagRepository;
    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag findOne(long id) {
        return null;
    }

    @Override
    public Tag find(Tag entity) {
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return null;
    }

    @Override
    public Optional<Tag> create(Tag entity) {
        return Optional.empty();
    }

    @Override
    public Tag update(Tag entity) {
        return null;
    }

    @Override
    public void delete(Tag entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }

    @Override
    public Tag getTagByNameAnd(String tagName) {
        return tagRepository.getTagByNameAnd(tagName);
    }
}
