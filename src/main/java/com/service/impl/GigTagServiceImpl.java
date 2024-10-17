package com.service.impl;

import com.dao.interfaces.GigTagDao;
import com.model.Gig;
import com.model.Tag;
import com.service.interfaces.GigTagService;
import java.util.List;

public class GigTagServiceImpl implements GigTagService {
    private GigTagDao gigTagDao;

    public GigTagServiceImpl(GigTagDao gigTagDao) {
        this.gigTagDao = gigTagDao;
    }

    @Override
    public void addTagToGig(int gigId, int tagId) throws Exception {
        gigTagDao.addTagToGig(gigId, tagId);
    }

    @Override
    public void removeTagFromGig(int gigId, int tagId) throws Exception {
        gigTagDao.removeTagFromGig(gigId, tagId);
    }

    @Override
    public List<Tag> getTagsByGigId(int gigId) throws Exception {
        return gigTagDao.findTagsByGigId(gigId);
    }

    @Override
    public List<Gig> getGigsByTagId(int tagId) throws Exception {
        return gigTagDao.findGigsByTagId(tagId);
    }

    @Override
    public boolean isGigAssociatedWithTag(int gigId, int tagId) throws Exception {
        return gigTagDao.isGigAssociatedWithTag(gigId, tagId);
    }

    @Override
    public int countTagsForGig(int gigId) throws Exception {
        return gigTagDao.countTagsForGig(gigId);
    }

    @Override
    public List<Gig> findSimilarGigs(int gigId, int limit) throws Exception {
        return gigTagDao.findSimilarGigs(gigId, limit);
    }

    @Override
    public void updateGigTags(int gigId, List<Integer> tagIds) throws Exception {
        gigTagDao.updateGigTags(gigId, tagIds);
    }

    @Override
    public List<Tag> getMostUsedTags(int limit) throws Exception {
        return gigTagDao.findMostUsedTags(limit);
    }

    @Override
    public List<Gig> getGigsByMultipleTags(List<Integer> tagIds, int limit) throws Exception {
        // This might require a more complex query
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }

    @Override
    public List<Tag> getSuggestedTagsForGig(int gigId, int limit) throws Exception {
        // This might require a more complex algorithm, possibly involving NLP
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }

    @Override
    public double calculateTagRelevanceScore(int gigId, int tagId) throws Exception {
        // This might require a more complex algorithm
        throw new UnsupportedOperationException("This operation is not yet implemented");
    }
}
