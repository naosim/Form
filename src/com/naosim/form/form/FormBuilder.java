package com.naosim.form.form;

import org.apache.http.client.HttpClient;


public class FormBuilder {
	private Form mForm;
	private RequestBuilder mRequestBuilder;
	public FormBuilder(HttpClient httpClinet) {
		mRequestBuilder = new RequestBuilder();
		mForm = new Form(httpClinet, mRequestBuilder);
	}
	
	public void setUrl(String url) {
		mRequestBuilder.setUrl(url);
	}
	
	public void addInput(Input input) {
		mRequestBuilder.addInput(input);
	}
	
	public void setSubmitter(Submitter submitter) {
		mForm.setSubmitter(submitter);
	}
	
	public void setStatusOKListener(StatusOKSubmitter.Listener l) {
		StatusOKSubmitter s = new StatusOKSubmitter();
		s.setOnResult(l);
		mForm.setSubmitter(s);
	}
	
	public Form create() {
		return mForm;
	}
	
}