package com.andridlearning.amit_gupta.rssfeedlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Amit_Gupta on 8/24/15.
 */
public class RssFeedProvider {
    // helper to get a list of RssItems

    public static List<RssItem> parse(String rssFeed) {

        List<RssItem> list = new ArrayList<RssItem>();
        Random r = new Random();
        Integer number = r.nextInt(10);
        for (int i = 0; i <number; i++) {
            // create sample data
            RssItem item = new RssItem("Summary "+i, "Description " +1);
            list.add(item);
        }
        return list;
    }
}
