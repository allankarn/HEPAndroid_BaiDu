package com.enetedu.hep.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImgUtils {
    public static void loadImgToUrl(Context context, Object url, int errDw, ImageView imageView){
        if(errDw==0){
            Glide.with(context).load(url).into(imageView);
        }else{
         //   Glide.with(context).load(url).error(errDw).into(imageView);
        }
    }
}
