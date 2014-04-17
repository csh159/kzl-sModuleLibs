package com.kzl.lib.http.sample.http.base.async;

import com.kzl.lib.http.client.interfaces.callback.IAsyncHttpResponseHandler;
import com.kzl.lib.http.sample.R;
import com.kzl.lib.http.sample.http.GpConstantsActionCode;
import com.kzl.lib.http.sample.http.base.IAsyncHttpResponseSuccessHandler;
import com.kzl.lib.http.task.interfaces.BaseHttpResponse;
import com.kzl.lib.utils.LogUtil;
import com.kzl.lib.utils.ToastUtil;

/**
 * Project:LuLuModuleLibs
 * Email: <A href="kezhenlu@qq.com">kezhenlu@qq.com</A><br/>
 * User: kenny.ke
 * Date: 2014/4/17<br/>
 * Time: 21:25<br/>
 * To change this template use File | Settings | File Templates.
 */
public class ImplAsyncHttpResponseHandler<T extends BaseHttpResponse> implements IAsyncHttpResponseHandler<T>, IAsyncHttpResponseSuccessHandler<T> {

    @Override
    public void onSuccess(T response) {
        LogUtil.trace("onSuccess");
        if (GpConstantsActionCode.RES_OK.equals(response.getResultCode())) {
            onNormal(response);
        } else {
            onError(response.getResultCode(), response.getErrorInfo());
        }
    }


    @Override
    public void onStart() {
        LogUtil.trace("onStart");
    }

    @Override
    public void onFinish() {
        LogUtil.trace("onFinish");
    }


    @Override
    public void onNoNet() {
        LogUtil.trace("onNoNet");
        ToastUtil.showMessage(R.string.no_net);
    }

    @Override
    public void onNoData() {
        LogUtil.trace("onNoData");
        ToastUtil.showMessage(R.string.no_data);
    }

    @Override
    public void onNormal(T response) {
        LogUtil.trace("onNormal");
    }

    @Override
    public void onError(String retCode, String errorInfo) {
        LogUtil.trace("onError");
        ToastUtil.showMessage(errorInfo);
    }
}