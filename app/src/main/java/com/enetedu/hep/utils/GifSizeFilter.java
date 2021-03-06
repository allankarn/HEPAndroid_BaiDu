package com.enetedu.hep.utils;

import android.content.Context;
import android.graphics.Point;

import com.enetedu.hep.R;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.IncapableCause;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.utils.PhotoMetadataUtils;

import java.util.HashSet;
import java.util.Set;

public class GifSizeFilter extends Filter {
    private int mMinWidth;
    private int mMinHeight;
    private int mMaxSize;

    public GifSizeFilter(int mMinWidth, int mMinHeight, int mMaxSize) {
        this.mMinWidth = mMinWidth;
        this.mMinHeight = mMinHeight;
        this.mMaxSize = mMaxSize;
    }

    @Override
    public Set<MimeType> constraintTypes() {
        return new HashSet<MimeType>() {{
            add(MimeType.GIF);
            add(MimeType.MP4);
        }};
    }

    @Override
    public IncapableCause filter(Context context, Item item) {
        if (!needFiltering(context, item))
            return null;

        Point size = PhotoMetadataUtils.getBitmapBound(context.getContentResolver(), item.getContentUri());
        /*if (size.x < mMinWidth || size.y < mMinHeight || item.size > mMaxSize) {
            return new IncapableCause(IncapableCause.DIALOG, context.getString(R.string.error_gif, mMinWidth,
                    String.valueOf(PhotoMetadataUtils.getSizeInMB(mMaxSize))));
        }*/
        return null;
    }
}
