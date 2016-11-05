package net.alhazmy13.wordcloud;

import android.content.Context;
import android.util.Log;

/**
 * The type Javascript interface.
 */
class JavascriptInterface {
    private static final String TAG = "JavascriptInterface";
    private Context mContext;
    private String mCloudTitle;
    private String mCloudString;
    private String mCloudFont;
    private int parentWidth;
    private int parentHeight;

    /**
     * Instantiate the interface and set the context
     *
     * @param c the c
     */
    JavascriptInterface(Context c) {
        mContext = c;
    }


    /**
     * Sets cloud params.
     *
     * @param mCloudTitle  the m cloud title
     * @param mCloudString the m cloud string
     * @param mCloudFont   the m cloud font
     * @param parentWidth  the parent width
     * @param parentHeight the parent height
     */
    public void setCloudParams(String mCloudTitle, String mCloudString,
                               String mCloudFont, int parentWidth, int parentHeight) {
//        Log.d(TAG, "setCloudParams() called with: mCloudTitle = [" + mCloudTitle + "], mCloudString = [" + mCloudString + "], mCloudFont = [" + mCloudFont + "], parentWidth = [" + parentWidth + "], parentHeight = [" + parentHeight + "]");
        this.mCloudTitle = mCloudTitle;
        this.mCloudString = mCloudString;
        this.mCloudFont = mCloudFont;
        this.parentHeight = parentHeight;
        this.parentWidth = parentWidth;
    }

    /**
     * Gets parent width.
     *
     * @return the parent width
     */
    @android.webkit.JavascriptInterface
    public int getParentWidth() {
        return parentWidth;
    }

    /**
     * Gets parent height.
     *
     * @return the parent height
     */
    @android.webkit.JavascriptInterface
    public int getParentHeight() {
        return parentHeight;
    }

    /**
     * Gets cloud string.
     *
     * @return the cloud string
     */
    @android.webkit.JavascriptInterface
    public String getCloudString() {
        return mCloudString;
    }

    /**
     * Gets cloud font.
     *
     * @return the cloud font
     */
    @android.webkit.JavascriptInterface
    public String getCloudFont() {
        return mCloudFont;
    }
}
