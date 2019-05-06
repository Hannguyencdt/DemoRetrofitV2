package net.ilightning.demoretrofitv2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*** Created by Admin on 27/5/2018.
 */

public class ListDataChapterModel {

    @SerializedName("data")
    @Expose
    private ArrayList<ChapterModel> chapterModels = new ArrayList<>();

    public ArrayList<ChapterModel> getChapterModels() {
        return chapterModels;
    }

    public void setChapterModels(ArrayList<ChapterModel> chapterModels) {
        this.chapterModels = chapterModels;
    }
}
