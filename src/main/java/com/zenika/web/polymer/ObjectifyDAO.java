package com.zenika.web.polymer;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.zenika.web.polymer.model.Song;

/**
 * Created by houbeb on 15/05/15.
 */
public class ObjectifyDAO {

        // register all @Entity classes

        static {
            ObjectifyService.register(Song.class);
        }

        // proxy for Objectify

        static Objectify ofy() {
            return ObjectifyService.ofy();
        }

}
