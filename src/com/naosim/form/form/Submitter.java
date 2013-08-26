package com.naosim.form.form;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

public interface Submitter {
	void submit(HttpClient client, HttpUriRequest request);
}