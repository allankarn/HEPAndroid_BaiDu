package com.enetedu.hep.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.enetedu.hep.R;

public class BaseDialog extends Dialog {
    private final View contentView;
    private final int gravity;

    public BaseDialog(@NonNull Context context, View contentView, int gravity) {
        //构造传入自定义视图和位置，style样式
        super(context, R.style.MyDialog);
        this.contentView = contentView;
        this.gravity = gravity;
        initView();
    }

    protected void initView() {
        super.setContentView(contentView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setGravity(gravity);
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = display.getWidth();
        getWindow().setAttributes(layoutParams);
    }
}
