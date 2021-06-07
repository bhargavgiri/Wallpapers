package com.example.wallpaper.Retrofit;

import java.util.List;

public class Rootmodel {
    public int total;
    public int totalHits;
    public List<Hit> hits;

    public int getTotal() {
        return total;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public List<Hit> getHits() {
        return hits;
    }
}
