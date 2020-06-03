
package consumo.api.rickandmorty.model;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("next")
    private String mNext;
    @SerializedName("pages")
    private Long mPages;
    @SerializedName("prev")
    private Object mPrev;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public String getNext() {
        return mNext;
    }

    public void setNext(String next) {
        mNext = next;
    }

    public Long getPages() {
        return mPages;
    }

    public void setPages(Long pages) {
        mPages = pages;
    }

    public Object getPrev() {
        return mPrev;
    }

    public void setPrev(Object prev) {
        mPrev = prev;
    }

}
