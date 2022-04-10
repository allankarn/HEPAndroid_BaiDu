package com.enetedu.hep.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ExpandTextView extends RelativeLayout {
    private TextView mText;
    private TextView mExpandText;
    private int mTextColor = 0xff828282;
    private int mTextLine = 1;
    private int mStart;
    private int mEnd;
    private boolean isFirst = true;
    private boolean isExpand = false;

    public ExpandTextView(Context context) {
        super(context);
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        mText = new TextView(context, attrs);
        mText.setTextColor(mTextColor);
        mText.setEllipsize(TextUtils.TruncateAt.END);
        mText.setMaxLines(mTextLine);
        addView(mText, params);
        mExpandText = new TextView(context);
        mExpandText.setTextColor(mTextColor);
        addView(mExpandText, params);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final ViewGroup.LayoutParams params = getLayoutParams();
        if (isFirst) {
            isFirst = false;
            mText.post(new Runnable() {
                @Override
                public void run() {
                    mStart = mText.getLineHeight() * mText.getLineCount();
                    params.height = mStart;
                    setLayoutParams(params);
                }
            });
            mExpandText.post(new Runnable() {
                @Override
                public void run() {
                    mEnd = mExpandText.getLineHeight() * (mExpandText.getLineCount() + 1);
                }
            });
        }
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
    }

    public void setText(String text) {
        isFirst = true;
        mText.setText(text);
        mExpandText.setText(text);
        requestLayout();
    }

    public void setTextColor(int color) {
        mText.setTextColor(color);
    }

    public void setTextSize(int size) {
        isFirst = true;
        mText.setTextSize(size);
        mExpandText.setTextSize(size);
        requestLayout();
    }

    public void setTextMaxLine(int num) {
        mTextLine = num;
        mText.setMaxLines(num);
    }

    public void setGravity(int gravity) {
        mText.setGravity(gravity);
        mExpandText.setGravity(gravity);
    }

    public void setEllipsize(TextUtils.TruncateAt ell) {
        mText.setEllipsize(ell);
    }

    public void setTextLineSpacingExtra(float spac) {
        mText.setLineSpacing(spac, 1.0f);
        mExpandText.setLineSpacing(spac, 1.0f);
    }

    public TextView text() {
        return mText;
    }

    public TextView expandText() {
        return mExpandText;
    }

    public int line() {
        return mTextLine;
    }

    public boolean isExpand() {
        return isExpand;
    }

    /*
     * 展开文本
     */
    public void expand() {
        if (!isExpand) {
            isExpand = true;
            mText.setEllipsize(null);
            mText.setTextColor(mTextColor);
            mExpandText.setTextColor(mTextColor);
            Animation animation = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    ViewGroup.LayoutParams params = ExpandTextView.this.getLayoutParams();
                    params.height = mStart + (int) ((mEnd - mStart) * interpolatedTime);
                    setLayoutParams(params);
                }
            };
            animation.setDuration(500);
            startAnimation(animation);
        }
    }

    /*
     * 收起文本
     */
    public void retract() {
        if (isExpand) {
            isExpand = false;
            mText.setEllipsize(TextUtils.TruncateAt.END);
            Animation animation = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime, Transformation t) {
                    ViewGroup.LayoutParams params = ExpandTextView.this.getLayoutParams();
                    params.height = mStart + (int) ((mEnd - mStart) * (1 - interpolatedTime));
                    setLayoutParams(params);
                }
            };
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mText.setTextColor(mTextColor);
                    mExpandText.setTextColor(mTextColor);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            animation.setDuration(500);
            startAnimation(animation);
        }
    }
}
