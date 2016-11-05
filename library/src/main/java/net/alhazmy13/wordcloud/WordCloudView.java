package net.alhazmy13.wordcloud;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Word cloud view.
 */
public class WordCloudView extends WebView {
    private Context mContext;
    private List<WordCloud> dataSet;
    private int old_min;
    private int old_max;
    private int parentWidth;
    private int parentHeight;

    /**
     * Instantiates a new Word cloud view.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public WordCloudView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.dataSet = new ArrayList<>();
        this.parentHeight = 300;
        this.parentWidth = 450;
        //  init();
    }

    /**
     * Init.
     */
    @SuppressLint({"AddJavascriptInterface", "SetJavaScriptEnabled"})
    void init() {
        JavascriptInterface myJavascriptInterface = new JavascriptInterface(mContext);

        myJavascriptInterface
                .setCloudParams("", getData(), "FreeSans", parentWidth, parentHeight);
        addJavascriptInterface(myJavascriptInterface, "jsinterface");
        WebSettings webSettings = getSettings();
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);

        // Use HTML5 localstorage to maintain app state
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setAppCacheEnabled(false);
        webSettings.setAllowFileAccess(false);

        webSettings.setLoadWithOverviewMode(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setUserAgentString("Android");
        loadUrl("file:///android_asset/wordcloud.html");
    }

    /**
     * Sets data set.
     *
     * @param dataSet the data set
     */
    public void setDataSet(List<WordCloud> dataSet) {
        this.dataSet = dataSet;
    }


    /**
     * Notify data set changed.
     */
    public void notifyDataSetChanged() {
        updateMaxMinValues();
        init();
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public String getData() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < dataSet.size(); i++) {
            sb.append("{\"word\":\"").append(dataSet.get(i).getText()).append("\",\"size\":\"").append(scale(dataSet.get(i).getWeight())).append("\"}");
            if (i < dataSet.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.parentWidth = w;
        this.parentHeight = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private float scale(int inputY) {
        float x = inputY - old_min;
        float y = old_max - old_min;
        float percent = x / y;
        return percent * (30 - 3) + 3;
    }


    private void updateMaxMinValues() {
        old_min = Integer.MAX_VALUE;
        old_max = Integer.MIN_VALUE;
        for (WordCloud wordCloud : dataSet) {
            if (wordCloud.getWeight() < old_min) {
                old_min = wordCloud.getWeight();
            }
            if (wordCloud.getWeight() > old_max) {
                old_max = wordCloud.getWeight();
            }
        }
    }

}
