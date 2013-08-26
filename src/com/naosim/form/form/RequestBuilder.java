package com.naosim.form.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class RequestBuilder {
	private List<Input> mInputList = new ArrayList<Input>();
	private String mUrl;
	public void addInput(Input input) {
		mInputList.add(input);
	}
	
	public void setUrl(String url) {
		mUrl = url;
	}
	
	public HttpUriRequest create() {
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		for(Input input : mInputList) {
			params.add(new BasicNameValuePair(input.getKeyValue().getKey(), input.getKeyValue().getValue()));
		}
		// パラメータをクエリに変換
		String query = URLEncodedUtils.format(params, "UTF-8");
		Log.e("create", "url : " + mUrl + "?" + query);
		return new HttpGet(mUrl + "?" + query);
	}
	
	
}