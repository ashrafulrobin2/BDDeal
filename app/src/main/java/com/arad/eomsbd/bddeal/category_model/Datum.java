
package com.arad.eomsbd.bddeal.category_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("mc_id")
    @Expose
    private String mcId;
    @SerializedName("mc_name")
    @Expose
    private String mcName;
    @SerializedName("en_mc_name")
    @Expose
    private String enMcName;
    @SerializedName("mc_active")
    @Expose
    private String mcActive;
    @SerializedName("mc_possition")
    @Expose
    private String mcPossition;

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId;
    }

    public String getMcName() {
        return mcName;
    }

    public void setMcName(String mcName) {
        this.mcName = mcName;
    }

    public String getEnMcName() {
        return enMcName;
    }

    public void setEnMcName(String enMcName) {
        this.enMcName = enMcName;
    }

    public String getMcActive() {
        return mcActive;
    }

    public void setMcActive(String mcActive) {
        this.mcActive = mcActive;
    }

    public String getMcPossition() {
        return mcPossition;
    }

    public void setMcPossition(String mcPossition) {
        this.mcPossition = mcPossition;
    }

}
