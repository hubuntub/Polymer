package com.zenika.web.polymer;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.googlecode.objectify.Key;
import com.zenika.web.polymer.model.Song;

import java.util.Random;

import static com.zenika.web.polymer.ObjectifyDAO.ofy;
/**
 * Created by houbeb on 15/05/15.
 */
@Api(
name = "songs", /* mandatory, otherwise replaced with "myapi"*/
        version = "v1",
        description = "A simple and polite API"
        )
public class SongAPI {

    @ApiMethod(name = "hello")
    public Song hello(@Nullable @Named("what") String what, @Nullable @Named("who") String who) {
        String title = new String("Song: ").concat(what == null ? "" : who);
        String singer = new String("Singer: ").concat(who == null ? "" : who);
        Song g = ofy().load().type(Song.class).filter("title", title).first().now();
        System.out.println(g + "title =" + title + "singer= " +  singer);
        if (g == null) {
            g = new Song(title, singer, new Random().nextInt(16));
            Key<Song> gkey = ofy().save().entity(g).now();
            g.id = gkey.getId();
        }
        return g;
    }
}
