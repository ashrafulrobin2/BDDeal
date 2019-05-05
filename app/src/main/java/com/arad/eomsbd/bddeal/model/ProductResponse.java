package com.arad.eomsbd.bddeal.model;

import android.graphics.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eomsbd on 7/17/2017.
 */
public class ProductResponse {
    @SerializedName("results")
    private List<Product> results;
    @SerializedName("total_results")
    private int totalResults;

    public List<Product> getResults() {
        return results;
    }
    public void setResults(List<Product> results) {
        this.results = results;
    }
    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
