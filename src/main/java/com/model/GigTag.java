package com.model;

import java.util.Objects;

public class GigTag {

    private int gigId;
    private int tagId;

    public GigTag() {
    }

    public GigTag(int gigId, int tagId) {
        this.gigId = gigId;
        this.tagId = tagId;
    }

    public int getGigId() {
        return gigId;
    }

    public void setGigId(int gigId) {
        this.gigId = gigId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "GigTag{" +
                "gigId=" + gigId +
                ", tagId=" + tagId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GigTag gigTag = (GigTag) o;
        return gigId == gigTag.gigId && tagId == gigTag.tagId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gigId, tagId);
    }
}
