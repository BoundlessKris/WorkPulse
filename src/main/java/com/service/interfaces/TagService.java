package com.service.interfaces;

import com.model.Tag;
import java.util.List;

public interface TagService {
    Tag createTag(Tag tag) throws Exception;
    Tag getTagById(int id) throws Exception;
    List<Tag> getAllTags() throws Exception;
    Tag updateTag(Tag tag) throws Exception;
    void deleteTag(int id) throws Exception;
    Tag getTagByName(String name) throws Exception;
    List<Tag> getTagsByGigId(int gigId) throws Exception;
    List<Tag> getMostPopularTags(int limit) throws Exception;
    List<Tag> searchTagsByPartialName(String partialName) throws Exception;
    int countGigsWithTag(int tagId) throws Exception;
    void addTagToGig(int gigId, int tagId) throws Exception;
    void removeTagFromGig(int gigId, int tagId) throws Exception;
    List<Tag> getRelatedTags(int tagId, int limit) throws Exception;
}
