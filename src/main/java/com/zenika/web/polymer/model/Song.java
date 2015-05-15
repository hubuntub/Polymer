package com.zenika.web.polymer.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by houbeb on 15/05/15.
 */
@Entity
public class Song {

    @Id
    public Long id;
    @Index
    public String title;
    @Index
    public String singer;
    @Index
    public Integer avatarId;

    public Song() {
    }

    public Song(String title, String singer, Integer avatarId) {
        this.title = title;
        this.singer = singer;
        this.avatarId = avatarId;
    }
}
