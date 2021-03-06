package com.enetedu.hep.http;

import android.util.Log;

import com.enetedu.hep.http.req.ReqAddShoppingCart;
import com.enetedu.hep.http.req.ReqArchives;
import com.enetedu.hep.http.req.ReqCdnurl;
import com.enetedu.hep.http.req.ReqCourse2Detail;
import com.enetedu.hep.http.req.ReqCourseClassifyList;
import com.enetedu.hep.http.req.ReqCourseConfirm;
import com.enetedu.hep.http.req.ReqCourseJH;
import com.enetedu.hep.http.req.ReqCourseList;
import com.enetedu.hep.http.req.ReqCourseListjz1;
import com.enetedu.hep.http.req.ReqCourseListjz2;
import com.enetedu.hep.http.req.ReqCourseListjz3;
import com.enetedu.hep.http.req.ReqCourseSign;
import com.enetedu.hep.http.req.ReqCourseWhetherStudy;
import com.enetedu.hep.http.req.ReqCourseXueXi;
import com.enetedu.hep.http.req.ReqCouseDetailsPlayForCourse;
import com.enetedu.hep.http.req.ReqCouseDetailsPlayForCourseLive;
import com.enetedu.hep.http.req.ReqDeleteShoppingCartByCourseID;
import com.enetedu.hep.http.req.ReqFinishedList;
import com.enetedu.hep.http.req.ReqHomeWorkEdit3;
import com.enetedu.hep.http.req.ReqHomeWorkEdit4;
import com.enetedu.hep.http.req.ReqHomeWorkEditSave3;
import com.enetedu.hep.http.req.ReqHomeWorkEditSave4;
import com.enetedu.hep.http.req.ReqInfoClassifyList;
import com.enetedu.hep.http.req.ReqInfoList;
import com.enetedu.hep.http.req.ReqLogin;
import com.enetedu.hep.http.req.ReqMostPopularCourseList;
import com.enetedu.hep.http.req.ReqMyCertificate;
import com.enetedu.hep.http.req.ReqNation;
import com.enetedu.hep.http.req.ReqNewCourseDetails;
import com.enetedu.hep.http.req.ReqOrderConfirm;
import com.enetedu.hep.http.req.ReqPassWordEditSave;
import com.enetedu.hep.http.req.ReqPersonal;
import com.enetedu.hep.http.req.ReqPersonalSave;
import com.enetedu.hep.http.req.ReqPreparationList;
import com.enetedu.hep.http.req.ReqPrintZSByChoice;
import com.enetedu.hep.http.req.ReqPrintZSByNetpay;
import com.enetedu.hep.http.req.ReqPublicClass;
import com.enetedu.hep.http.req.ReqRotationChart;
import com.enetedu.hep.http.req.ReqRotationChartCommunity;
import com.enetedu.hep.http.req.ReqSMSUpdateLoginPwd;
import com.enetedu.hep.http.req.ReqShoppingCartList;
import com.enetedu.hep.http.req.ReqSignUp;
import com.enetedu.hep.http.req.ReqSignUpSaveEdit;
import com.enetedu.hep.http.req.ReqStudyLink;
import com.enetedu.hep.http.req.ReqStudyMyCourse;
import com.enetedu.hep.http.req.ReqStudyMyCourseForChoice;
import com.enetedu.hep.http.req.ReqStudyMyCourseForCourse2;
import com.enetedu.hep.http.req.ReqUnfinishedList;
import com.enetedu.hep.http.req.ReqUserRegister;
import com.enetedu.hep.http.req.ReqVideoPlayForMgc;
import com.enetedu.hep.http.req.RespPersonal;
import com.enetedu.hep.http.resp.RespArchives;
import com.enetedu.hep.http.resp.RespCourse22Detail;
import com.enetedu.hep.http.resp.RespCourse2Detail;
import com.enetedu.hep.http.resp.RespCourseClassifyList;
import com.enetedu.hep.http.resp.RespCourseList;
import com.enetedu.hep.http.resp.RespCourseListjz1;
import com.enetedu.hep.http.resp.RespFinishedList;
import com.enetedu.hep.http.resp.RespHomeWorkEdit3;
import com.enetedu.hep.http.resp.RespHomeWorkEdit4;
import com.enetedu.hep.http.resp.RespInfoClassifyList;
import com.enetedu.hep.http.resp.RespInfoList;
import com.enetedu.hep.http.resp.RespLogin;
import com.enetedu.hep.http.resp.RespMostPopularCourseList;
import com.enetedu.hep.http.resp.RespMyCertificate;
import com.enetedu.hep.http.resp.RespNation;
import com.enetedu.hep.http.resp.RespNewCourseDetails;
import com.enetedu.hep.http.resp.RespPreparationList;
import com.enetedu.hep.http.resp.RespPublicClass;
import com.enetedu.hep.http.resp.RespRotationChart;
import com.enetedu.hep.http.resp.RespShoppingCartList;
import com.enetedu.hep.http.resp.RespSignUp;
import com.enetedu.hep.http.resp.RespStudyLink;
import com.enetedu.hep.http.resp.RespStudyMyCourse;
import com.enetedu.hep.http.resp.RespUnfinishedList;
import com.enetedu.hep.http.resp.RespVideoPlayForMgc;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


public class HEPMSProxy implements Runnable, IHEPMSProxy {
    //https://app.enetedu.com/MobileAppWebService.asmx

    private static final String NAMESPACE = IS_RELEASE ? "http://app.enetedu.com/"//univs
            : "http://app.enetedu.com/";

    //????????????
    //http://10.1.140.64/MobileAppWebService.asmx
    //????????????
    //https://app.enetedu.com/MobileAppWebService.asmx
    private static final String SERVICE_URL = IS_RELEASE ? "https://app.enetedu.com/MobileAppWebService.asmx" : "https://app.enetedu.com/MobileAppWebService.asmx";
    private static final String TAG = "HEPMSProxy";

    private ReqBase mReq;
    private ISoapRes mResp;

    private static Element[] header = null;

    protected HEPMSProxy(ReqBase req, ISoapRes resp) {
        this.mReq = req;
        mResp = resp;
    }

    private boolean excute() {
        new Thread(this).start();
        return true;
    }

    private static Element[] getHeader() {
        if (null == header) {
            synchronized (HEPMSProxy.class) {
                if (header == null) {
                    header = new Element[1];
                    header[0] = new Element().createElement(NAMESPACE, "SoapHeaderVerification");
                    Element appId = new Element().createElement(NAMESPACE, "AppId");
                    appId.addChild(Node.TEXT, "1");
                    header[0].addChild(Node.ELEMENT, appId);
                    Element authorize = new Element().createElement(NAMESPACE, "Authorize");
                    authorize.addChild(Node.TEXT, "123456");
                    header[0].addChild(Node.ELEMENT, authorize);
                }
            }
        }
        return header;
    }

    /**
     * description: ????????????????????????????????????????????????
     *
     * @param req  ???????????????????????????
     * @param resp ksoap??????webService?????? ???????????????
     * @return boolean ????????????
     * @Title ???proxy
     * @author LKY
     */
    protected static boolean proxy(final ReqBase req, final ISoapRes resp) {
        if (req == null || resp == null) {
            return false;
        }
        return new HEPMSProxy(req, resp).excute();
    }

    protected interface ISoapRes {
        void onRes(String res);
    }

    public static boolean GetUserLogin(ReqLogin req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespLogin();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }

    public static boolean GetUserRegister(ReqUserRegister req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }

    public static boolean GetSMSUpdateLoginPwd(ReqSMSUpdateLoginPwd req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }

    //????????????
    public static boolean GetPassWordEditSave(ReqPassWordEditSave req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }

    //??????????????????
    public static boolean GetPersonal(ReqPersonal req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespPersonal();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }

    //????????????????????????
    public static boolean GetPersonalSave(ReqPersonalSave req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }

    //???????????????????????????
    public static boolean GetSignUpSaveEdit(ReqSignUpSaveEdit req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetOrderConfirm(ReqOrderConfirm req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }


    public static boolean GetCourseClassifyList(ReqCourseClassifyList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespCourseClassifyList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });

    }

    public static boolean GetCourseList(ReqCourseList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespCourseList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetCourse2Detail(ReqCourse2Detail req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespCourse2Detail();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    public static boolean GetCourse22Detail(ReqCourse2Detail req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespCourse22Detail();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????? ???????????????
    public static boolean GetAddShoppingCart(ReqAddShoppingCart req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //???????????????
    public static boolean GetCourseConfirm(ReqCourseConfirm req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetCourseXueXi(ReqCourseXueXi req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetVideoPlayForMgc(ReqVideoPlayForMgc req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespVideoPlayForMgc();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //??????????????????
    public static boolean GetCdnurl(ReqCdnurl req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetNewCourseDetails(ReqNewCourseDetails req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespNewCourseDetails();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????????????????
    public static boolean GetCouseDetailsPlayForCourse(ReqCouseDetailsPlayForCourse req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????????????????
    public static boolean GetCouseDetailsPlayForCourseLive(ReqCouseDetailsPlayForCourseLive req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //??????????????????????????????????????????
    public static boolean GetCourseWhetherStudy(ReqCourseWhetherStudy req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    public static boolean GetCourseSign(ReqCourseSign req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //???????????????
    public static boolean GetSignUp(ReqSignUp req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespSignUp();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }


    public static boolean GetShoppingCartList(ReqShoppingCartList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespShoppingCartList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    public static boolean GetDeleteShoppingCartByCourseID(ReqDeleteShoppingCartByCourseID req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetCourseListjz1(ReqCourseListjz1 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespCourseListjz1();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //???????????????2??????
    public static boolean GetCourseListjz2(ReqCourseListjz2 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespCourseListjz1();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //???????????????0.5??????
    public static boolean GetCourseListjz3(ReqCourseListjz3 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespCourseListjz1();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetMostPopularCourseList(ReqMostPopularCourseList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespMostPopularCourseList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????????
    public static boolean GetRotationChart(ReqRotationChart req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespRotationChart();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    public static boolean GetRotationChartCommunity(ReqRotationChartCommunity req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespRotationChart();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //??????Tab???
    public static boolean GetInfoClassifyList(ReqInfoClassifyList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespInfoClassifyList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetInfoList(ReqInfoList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespInfoList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //???????????????
    public static boolean GetPublicClass(ReqPublicClass req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespPublicClass();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????????
    public static boolean GetPreparationList(ReqPreparationList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespPreparationList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????????
    public static boolean GetUnfinishedList(ReqUnfinishedList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespUnfinishedList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????????
    public static boolean GetFinishedList(ReqFinishedList req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespFinishedList();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetStudyLink(ReqStudyLink req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespStudyLink();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????4
    public static boolean GetHomeWorkEdit4(ReqHomeWorkEdit4 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespHomeWorkEdit4();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????4
    public static boolean GetHomeWorkEditSave4(ReqHomeWorkEditSave4 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????3
    public static boolean GetHomeWorkEdit3(ReqHomeWorkEdit3 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespHomeWorkEdit3();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????4
    public static boolean GetHomeWorkEditSave3(ReqHomeWorkEditSave3 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????????????????
    public static boolean GetPrintZSByChoice(ReqPrintZSByChoice req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????????????????
    public static boolean GetPrintZSByNetpay(ReqPrintZSByNetpay req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????????????????? ????????????
    public static boolean GetCourseJH(ReqCourseJH req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespBase();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetStudyMyCourse(ReqStudyMyCourse req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespStudyMyCourse();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????? ????????????
    public static boolean GetStudyMyCourseForCourse2(ReqStudyMyCourseForCourse2 req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespStudyMyCourse();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //?????? ????????????
    public static boolean GetStudyMyCourseForChoice(ReqStudyMyCourseForChoice req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespStudyMyCourse();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //????????????
    public static boolean GetMyCertificate(ReqMyCertificate req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespMyCertificate();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    //??????????????????
    public static boolean GetArchives(ReqArchives req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespArchives();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }

    public static boolean GetNation(ReqNation req, final OnResp resp) {
        if (req == null || resp == null) {
            return false;
        }
        return proxy(req, new ISoapRes() {
            @Override
            public void onRes(String res) {
                RespBase respBase = new RespNation();
                respBase.onResp(res);
                resp.onResp(respBase);
            }
        });
    }


    @Override
    public void run() {
        String methodName = mReq.getMethodName();
        SoapObject soapObject = new SoapObject(NAMESPACE, methodName);
        mReq.addProperty(soapObject);

        Log.e(TAG, methodName + ":" + mReq);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.headerOut = getHeader();
        envelope.bodyOut = soapObject;
        envelope.dotNet = true;
        envelope.setOutputSoapObject(soapObject);
        HttpTransportSE transportSE = new HttpTransportSE(SERVICE_URL, mReq.getTimeOut());
        String result = null;
        try {
            if (!NAMESPACE.contains("//")) {
                transportSE.call(NAMESPACE + "/" + methodName, envelope);
            } else {
                transportSE.call(NAMESPACE + methodName, envelope);
            }
            Object in = envelope.bodyIn;

            if (in instanceof SoapObject) {
                SoapObject object = (SoapObject) in;
                result = object.getProperty(0).toString();

                result = result.replaceAll("new ", "")//??????????????????????????????json???
                        .replaceAll("Date", "").replaceAll("\\(", "")
                        .replaceAll("\\)", "");
            } else {
                result = in.toString();
            }

        } catch (UnknownHostException e) {
            result = "{\"Code\":" + RespBase.RES_CODE_ERR_NET
                    + ",\"Desc\":\"\"}";
        } catch (ConnectException e) {
            result = "{\"Code\":" + RespBase.RES_CODE_ERR_CONNECTION
                    + ",\"Desc\":\"\"}";
        } catch (SocketTimeoutException e) {
            result = "{\"Code\":" + RespBase.RES_CODE_ERR_CONNECT_TIMEOUT
                    + ",\"Desc\":\"\"}";
        } catch (IOException e) {
            result = "{\"Code\":" + RespBase.RES_CODE_ERR_DATA_RESP
                    + ",\"Desc\":\"\"}";
        } catch (XmlPullParserException e) {
            result = "{\"Code\":" + RespBase.RES_CODE_ERR_DATA_RESP
                    + ",\"Desc\":\"\"}";
        } catch (Exception e) {
            Log.e(TAG, "err:" + mReq.getMethodName() + "run: " + result);
            result = "{\"Code\":" + RespBase.RES_CODE_UNKNOWN
                    + ",\"Desc\":\"\"}";
        } finally {
            if (!result.contains("Code")) {
                Log.e(TAG, "err:" + mReq.getMethodName() + "run: " + result);
                result = "{\"Code\":" + RespBase.RES_CODE_UNKNOWN
                        + ",\"Desc\":\"\"}";
            }
            Log.e(TAG, "name:" + mReq.getMethodName() + "run: " + result);
            mResp.onRes(result);
        }
    }
}