package com.service.impl;

import com.dao.interfaces.TagDao;
import com.model.Tag;
import com.service.interfaces.TagService;
import java.util.List;

public class TagServiceImpl implements TagService {
    private TagDao tagDao;

    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public Tag createTag(Tag tag) throws Exception {
        validateTag(tag);
        return tagDao.create(tag);
    }

    @Override
    public Tag getTagById(int id) throws Exception {
        Tag tag = tagDao.findById(id);
        if (tag == null) {
            throw new Exception("Tag not found with id: " + id);
        }
        return tag;
    }

    @Override
    public List<Tag> getAllTags() throws Exception {
        return tagDao.findAll();
    }

    @Override
    public Tag updateTag(Tag tag) throws Exception {
        validateTag(tag);
        Tag existingTag = getTagById(tag.getTagId());
        if (existingTag == null) {
            throw new Exception("Tag not found for update with id: " + tag.getTagId());
        }
        return tagDao.update(tag);
    }

    @Override
    public void deleteTag(int id) throws Exception {
        Tag tag = getTagById(id);
        if (tag == null) {
            throw new Exception("Tag not found for deletion with id: " + id);
        }
        tagDao.delete(id);
    }

    @Override
    public Tag getTagByName(String name) throws Exception {
        return tagDao.findByName(name);
    }

    @Override
    public List<Tag> getTagsByGigId(int gigId) throws Exception {
        return tagDao.findByGigId(gigId);
    }

    @Override
    public List<Tag> getMostPopularTags(int limit) throws Exception {
        return tagDao.findMostPopular(limit);
    }

    @Override
    public List<Tag> searchTagsByPartialName(String partialName) throws Exception {
        return tagDao.searchByPartialName(partialName);
    }

    @Override
    public int countGigsWithTag(int tagId) throws Exception {
        return tagDao.countGigsWithTag(tagId);
    }

    @Override
    public void addTagToGig(int gigId, int tagId) throws Exception {
        // This method might be better placed in a GigTagService
        throw new UnsupportedOperationException("This operation is not supported in TagService");
    }

    @Override
    public void removeTagFromGig(int gigId, int tagId) throws Exception {
        // This method might be better placed in a GigTagService
        throw new UnsupportedOperationException("This operation is not supported in TagService");
    }

    @Override
    public List<Tag> getRelatedTags(int tagId, int limit) throws Exception {
        // This would require a more complex query, possibly involving gig-tag associations
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }

    private void validateTag(Tag tag) throws IllegalArgumentException {
        if (tag == null) {
            throw new IllegalArgumentException("Tag cannot be null");
        }
        if (tag.getName() == null || tag.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Tag name cannot be empty");
        }
    }
}
