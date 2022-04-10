package com.enetedu.hep.my;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.enetedu.hep.R;
import com.enetedu.hep.config.UserInfoSharePreference;
import com.enetedu.hep.http.RespBase;
import com.enetedu.hep.http.entity.BaseEntity;
import com.enetedu.hep.http.entity.UserInfo;
import com.enetedu.hep.utils.BaseDialog;
import com.enetedu.hep.utils.GifSizeFilter;
import com.enetedu.hep.utils.PermissionUtils;
import com.enetedu.hep.utils.SimpleToolbar;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.PicassoEngine;
import com.zhihu.matisse.filter.Filter;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import java.io.File;
import java.util.List;


public class UserEditActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "UserEditActivity";
    /**
     * 返回
     */
    private TextView mTxtLeftTitle;
    /**
     * 个人资料
     */
    private TextView mTxtMainTitle;
    private SimpleToolbar mSimpleToolbar;
    private ImageView mIvTu;
    private TextView mTvArrow;
    private RelativeLayout mRllTouxiang;
    /**
     * 丁帅行
     */
    private TextView mTvName;
    private RelativeLayout mRllName;
    /**
     * 丁帅行
     */
    private TextView mTvName2;
    private RelativeLayout mRllName2;
    /**
     * 男
     */
    private TextView mTvSex;
    private RelativeLayout mRllSex;
    /**
     * 丁帅行
     */
    private TextView mTvMinzu;
    private RelativeLayout mRllMinzu;
    /**
     * 网培中心
     */
    private TextView mTvSchool;
    private RelativeLayout mRllSchool;
    /**
     * 法学系
     */
    private TextView mTvYuanxi;
    private RelativeLayout mRllYuanxi;
    private UserInfo userInfo;
    private BaseDialog baseDialog;
    private BaseDialog baseDialog2;
    private BaseDialog baseDialog3;
    private BaseDialog baseDialog4;
    private BaseDialog baseDialog5;
    private BaseDialog baseDialog6;
    private UserInfo userInfo1;
    private int REQUEST_CODE_CHOOSE = 23;
    private String uploadBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);

        List<String> list = PermissionUtils.checkPermission(this, perms);
        if (list.size() > 0) {
            PermissionUtils.requestPer(this, list, 100);
        }
        initView();
        loadPersonal();
    }

    public static String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};

    private void initView() {
        mTxtLeftTitle = (TextView) findViewById(R.id.txt_left_title);
        mTxtMainTitle = (TextView) findViewById(R.id.txt_main_title);
        mSimpleToolbar = (SimpleToolbar) findViewById(R.id.simple_toolbar);
        mIvTu = (ImageView) findViewById(R.id.iv_tu);
        mTvArrow = (TextView) findViewById(R.id.tv_arrow);
        mRllTouxiang = (RelativeLayout) findViewById(R.id.rll_touxiang);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mRllName = (RelativeLayout) findViewById(R.id.rll_name);
        mTvName2 = (TextView) findViewById(R.id.tv_name2);
        mRllName2 = (RelativeLayout) findViewById(R.id.rll_name2);
        mTvSex = (TextView) findViewById(R.id.tv_sex);
        mRllSex = (RelativeLayout) findViewById(R.id.rll_sex);
        mTvMinzu = (TextView) findViewById(R.id.tv_minzu);
        mRllMinzu = (RelativeLayout) findViewById(R.id.rll_minzu);
        mTvSchool = (TextView) findViewById(R.id.tv_school);
        mRllSchool = (RelativeLayout) findViewById(R.id.rll_school);
        mTvYuanxi = (TextView) findViewById(R.id.tv_yuanxi);
        mRllYuanxi = (RelativeLayout) findViewById(R.id.rll_yuanxi);
        mRllTouxiang.setOnClickListener(this);
        mRllName.setOnClickListener(this);
        mRllName2.setOnClickListener(this);
        mRllSex.setOnClickListener(this);
        mRllMinzu.setOnClickListener(this);
        mRllSchool.setOnClickListener(this);
        mRllYuanxi.setOnClickListener(this);

        mTxtLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserEditActivity.this.finish();
            }
        });
        userInfo = UserInfoSharePreference.getIns().get(this);

    }

    private void loadPersonal() {
        userInfo.getPersonal(userInfo.getUserToken(), userInfo.getUserId(), new BaseEntity.OnBaseResp() {
            @Override
            public void onResp(RespBase resp) {
                if (resp.getResCode() == 0) {
                    userInfo1 = (UserInfo) resp.getData();
                    RequestOptions requestOptions = new RequestOptions().circleCrop();
                    Glide.with(UserEditActivity.this).load(userInfo1.getHeadImg()).apply(requestOptions).into(mIvTu);
                    mTvName.setText(userInfo1.getUserName());
                    mTvName2.setText(userInfo1.getNickName());
                    mTvSex.setText(userInfo1.getUserSex());
                    mTvMinzu.setText(userInfo1.getNation());
                    mTvSchool.setText(userInfo1.getSchool());
                    mTvYuanxi.setText(userInfo1.getUserschooldepartment());
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rll_touxiang:
                initCountDialogPhoto();
                break;
            case R.id.rll_name:
                initCountDialogName();

                break;
            case R.id.rll_name2:
                initCountDialogNikeName();
                break;
            case R.id.rll_sex:
                initCountDialogSex();
                break;
            case R.id.rll_minzu:
                Intent intent = new Intent(UserEditActivity.this, NationActivity.class);
                startActivityForResult(intent, 1001);

                break;
            case R.id.rll_school:
                initCountDialogSchool();
                break;
            case R.id.rll_yuanxi:
                initCountDialogDanWei();
                break;
        }
    }


    private void initCountDialogName() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog2, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_title = inflate.findViewById(R.id.tv_title);
        final EditText ed_xiugai = inflate.findViewById(R.id.ed_xiugai);
        tv_title.setText("修改姓名");
        ed_xiugai.setHint("修改姓名");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), userInfo1.getHeadImg(), ed_xiugai.getText().toString(), userInfo1.getUserSex(),
                        userInfo1.getNation(), userInfo1.getSchool(), userInfo1.getUserschooldepartment(), userInfo1.getNickName(), new BaseEntity.OnBaseResp() {
                            @Override
                            public void onResp(RespBase resp) {
                                if (resp.getResCode() == 0) {
                                    Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    loadPersonal();
                                }
                            }
                        });
                baseDialog.dismiss();
            }
        });

        if (baseDialog == null) {
            baseDialog = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog.show();
    }

    private void initCountDialogNikeName() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog2, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_title = inflate.findViewById(R.id.tv_title);
        final EditText ed_xiugai = inflate.findViewById(R.id.ed_xiugai);
        tv_title.setText("修改昵称");
        ed_xiugai.setHint("修改昵称");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog2.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), userInfo1.getHeadImg(), userInfo1.getUserName(), userInfo1.getUserSex(),
                        userInfo1.getNation(), userInfo1.getSchool(), userInfo1.getUserschooldepartment(), ed_xiugai.getText().toString(), new BaseEntity.OnBaseResp() {
                            @Override
                            public void onResp(RespBase resp) {
                                if (resp.getResCode() == 0) {
                                    Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    loadPersonal();
                                }
                            }
                        });
                baseDialog2.dismiss();
            }
        });

        if (baseDialog2 == null) {
            baseDialog2 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog2.show();
    }

    private void initCountDialogSchool() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog2, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_title = inflate.findViewById(R.id.tv_title);
        final EditText ed_xiugai = inflate.findViewById(R.id.ed_xiugai);
        tv_title.setText("修改学校");
        ed_xiugai.setHint("修改学校");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog3.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), userInfo1.getHeadImg(), userInfo1.getUserName(), userInfo1.getUserSex(),
                        userInfo1.getNation(), ed_xiugai.getText().toString(), userInfo1.getUserschooldepartment(), userInfo1.getNickName(), new BaseEntity.OnBaseResp() {
                            @Override
                            public void onResp(RespBase resp) {
                                if (resp.getResCode() == 0) {
                                    Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    loadPersonal();
                                }
                            }
                        });
                baseDialog3.dismiss();
            }
        });

        if (baseDialog3 == null) {
            baseDialog3 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog3.show();
    }

    private void initCountDialogDanWei() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog2, null);
        Button btn_no = inflate.findViewById(R.id.btn_no);
        Button btn_yes = inflate.findViewById(R.id.btn_yes);
        TextView tv_title = inflate.findViewById(R.id.tv_title);
        final EditText ed_xiugai = inflate.findViewById(R.id.ed_xiugai);
        tv_title.setText("修改院系");
        ed_xiugai.setHint("修改院系");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog4.dismiss();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), userInfo1.getHeadImg(), userInfo1.getUserName(), userInfo1.getUserSex(),
                        userInfo1.getNation(), userInfo1.getSchool(), ed_xiugai.getText().toString(), userInfo1.getNickName(), new BaseEntity.OnBaseResp() {
                            @Override
                            public void onResp(RespBase resp) {
                                if (resp.getResCode() == 0) {
                                    Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    loadPersonal();
                                }
                            }
                        });
                baseDialog4.dismiss();
            }
        });

        if (baseDialog4 == null) {
            baseDialog4 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog4.show();
    }

    private void initCountDialogSex() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog3, null);
        TextView tv_nan = inflate.findViewById(R.id.tv_nan);
        TextView tv_nv = inflate.findViewById(R.id.tv_nv);
        TextView tv_no = inflate.findViewById(R.id.tv_no);

        tv_nan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), userInfo1.getHeadImg(), userInfo1.getUserName(), "男",
                        userInfo1.getNation(), userInfo1.getSchool(), userInfo1.getUserschooldepartment(), userInfo1.getNickName(), new BaseEntity.OnBaseResp() {
                            @Override
                            public void onResp(RespBase resp) {
                                if (resp.getResCode() == 0) {
                                    Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    loadPersonal();
                                }
                            }
                        });
                baseDialog5.dismiss();
            }
        });

        tv_nv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), userInfo1.getHeadImg(), userInfo1.getUserName(), "女",
                        userInfo1.getNation(), userInfo1.getSchool(), userInfo1.getUserschooldepartment(), userInfo1.getNickName(), new BaseEntity.OnBaseResp() {
                            @Override
                            public void onResp(RespBase resp) {
                                if (resp.getResCode() == 0) {
                                    Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                    loadPersonal();
                                }
                            }
                        });
                baseDialog5.dismiss();
            }
        });

        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog5.dismiss();
            }
        });

        if (baseDialog5 == null) {
            baseDialog5 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog5.show();
    }

    private void initCountDialogPhoto() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog4, null);

        TextView tv_xiangce = inflate.findViewById(R.id.tv_xiangce);
        TextView tv_no = inflate.findViewById(R.id.tv_no);


        tv_xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Matisse
                        .from(UserEditActivity.this)
                        //选择图片
                        .choose(MimeType.ofImage())
                        //是否只显示选择的类型的缩略图，就不会把所有图片视频都放在一起，而是需要什么展示什么
                        .showSingleMediaType(true)
                        //这两行要连用 是否在选择图片中展示照相 和适配安卓7.0 FileProvider
                        .capture(true)
                        .captureStrategy(new CaptureStrategy(true, "PhotoPicker"))
                        //有序选择图片 123456...
                        .countable(true)
                        //最大选择数量为9
                        .maxSelectable(1)
                        //选择方向
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                        //界面中缩略图的质量
                        .thumbnailScale(0.8f)
                        //蓝色主题
                        .theme(R.style.Matisse_Zhihu)

                        .imageEngine(new PicassoEngine())
                        .capture(true) //是否提供拍照功能
                        .captureStrategy(new CaptureStrategy(true, "com.enetedu.hep.fileprovider"))//存储到哪里
                        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                        //请求码
                        .forResult(REQUEST_CODE_CHOOSE);


                baseDialog6.dismiss();
            }
        });

        tv_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseDialog6.dismiss();
            }
        });

        if (baseDialog6 == null) {
            baseDialog6 = new BaseDialog(this, inflate, Gravity.CENTER);
        }
        baseDialog6.show();
    }

    List<Uri> mSelected;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == RESULT_OK) {
            String nation = data.getStringExtra("nation");
            mTvMinzu.setText(nation);
            userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), userInfo1.getHeadImg(), userInfo1.getUserName(), userInfo1.getUserSex(),
                    nation, userInfo1.getSchool(), userInfo1.getUserschooldepartment(), userInfo1.getNickName(), new BaseEntity.OnBaseResp() {
                        @Override
                        public void onResp(RespBase resp) {
                            if (resp.getResCode() == 0) {
                                Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                loadPersonal();
                            }
                        }
                    });
        }

        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            Log.d(TAG, "onActivityResult: " + mSelected.get(0));
            String realFilePath = getRealFilePath(UserEditActivity.this, mSelected.get(0));
            Log.d(TAG, "realFilePath: " + realFilePath);
           /* try {
                FileInputStream fis = new FileInputStream(realFilePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = fis.read(buffer)) >= 0) {
                    baos.write(buffer, 0, count);
                }
                //进行Base64编码
                uploadBuffer = new String(Base64.encode(baos.toByteArray()));
                Log.d(TAG, "onActivityResult: " + uploadBuffer);
                fis.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
            userInfo.getPersonalSave(userInfo.getUserToken(), userInfo.getUserId(), realFilePath, userInfo1.getUserName(), userInfo1.getUserSex(),
                    userInfo1.getNation(), userInfo1.getSchool(), userInfo1.getUserschooldepartment(), userInfo1.getNickName(), new BaseEntity.OnBaseResp() {
                        @Override
                        public void onResp(RespBase resp) {
                            if (resp.getResCode() == 0) {
                                Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                                loadPersonal();
                            } else {
                                Toast.makeText(UserEditActivity.this, resp.getDesc(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    /**
     * 根据Uri获取文件真实地址
     */
    public static String getRealFilePath(Context context, Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String realPath = null;
        if (scheme == null)
            realPath = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            realPath = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri,
                    new String[]{MediaStore.Images.ImageColumns.DATA},
                    null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        realPath = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        if (TextUtils.isEmpty(realPath)) {
            if (uri != null) {
                String uriString = uri.toString();
                int index = uriString.lastIndexOf("/");
                String imageName = uriString.substring(index);
                File storageDir;

                storageDir = Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES);
                File file = new File(storageDir, imageName);
                if (file.exists()) {
                    realPath = file.getAbsolutePath();
                } else {
                    storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                    File file1 = new File(storageDir, imageName);
                    realPath = file1.getAbsolutePath();
                }
            }
        }
        return realPath;
    }

}
