package com.enetedu.hep.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.enetedu.hep.R;
import com.gyf.immersionbar.ImmersionBar;

import java.util.List;

public abstract class BaseActivityPro extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private static final String TAG = "BaseActivityPro";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImmersionBar.with(this)
                .keyboardEnable(true)
                .init();
    }

    protected MyBaseFragment addFragment(FragmentManager manager, Class<? extends MyBaseFragment> aClass, int containerId, Bundle args) {

        String tag = aClass.getName();

        Fragment fragment = manager.findFragmentByTag(tag);
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragment == null) {
            try {
                fragment = aClass.newInstance();

                transaction.add(containerId, fragment, tag);


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (fragment.isAdded()) {
                if (fragment.isHidden()) {
                    transaction.show(fragment);
                }
            } else {
                transaction.add(containerId, fragment, tag);
            }
        }

        if (fragment != null) {
            fragment.setArguments(args);
            hideBeforeFragment(manager, transaction, fragment);
            transaction.commit();
            return (MyBaseFragment) fragment;
        }
        return null;
    }

    /**
     * 除当前fragment，其它都隐藏
     *
     * @param manager
     * @param transaction
     * @param currentFragment
     */
    private void hideBeforeFragment(FragmentManager manager, FragmentTransaction transaction, Fragment currentFragment) {
        List<Fragment> fragments = manager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != currentFragment && !fragment.isHidden()) {
                transaction.hide(fragment);
            }
        }
    }

    public ProgressDialog showProgressDialog(String msg) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage(msg);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setIndeterminateDrawable(getResources().getDrawable(
                    R.drawable.loading_progressbar));
        }
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

}
