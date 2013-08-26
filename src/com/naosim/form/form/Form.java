package com.naosim.form.form;

import org.apache.http.client.HttpClient;

import android.view.View;

public class Form implements View.OnClickListener{
	private HttpClient mClient;
	private RequestBuilder mRequestBuilder;
	private Submitter mSubmitter;

	public Form(HttpClient client, RequestBuilder requestBulder) {
		mClient = client;
		mRequestBuilder = requestBulder;
	}
	
	public void setSubmitter(Submitter submitter) {
		mSubmitter = submitter;
	}
	
	public void submit() {
		mSubmitter.submit(mClient, mRequestBuilder.create());
	}
	
	@Override
	public void onClick(View v) {
		submit();
	}
}
