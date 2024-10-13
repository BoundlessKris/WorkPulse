package com.service.interfaces;

import com.model.Gig;
import com.model.Tag;
import java.util.List;

public interface GigTagService {
    void addTagToGig(int gigId, int tagId) throws Exception;
    void removeTagFromGig(int gigId, int tagId) throws Exception;
    List<Tag> getTagsByGigId(int gigId) throws Exception;
    List<Gig> getGigsByTagId(int tagId) throws Exception;
    boolean isGigAssociatedWithTag(int gigId, int tagId) throws Exception;
    int countTagsForGig(int gigId) throws Exception;
    List<Gig> findSimilarGigs(int gigId, int limit) throws Exception;
    void updateGigTags(int gigId, List<Integer> tagIds) throws Exception;
    List<Tag> getMostUsedTags(int limit) throws Exception;
    List<Gig> getGigsByMultipleTags(List<Integer> tagIds, int limit) throws Exception;
    List<Tag> getSuggestedTagsForGig(int gigId, int limit) throws Exception;
    double calculateTagRelevanceScore(int gigId, int tagId) throws Exception;
}
