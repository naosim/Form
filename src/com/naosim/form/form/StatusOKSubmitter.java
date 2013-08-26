package com.naosim.form.form;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

import android.os.AsyncTask;
import android.os.Handler;


public class StatusOKSubmitter implements Submitter {

	private StatusOKSubmitter.Listener mOnResult;
	private Handler mHandler = new Handler();
	HttpClient mclient;
	HttpUriRequest mrequest;
	private AsyncTask<Void, Void, Boolean> mTask = new AsyncTask<Void, Void, Boolean>(){

		@Override
		protected Boolean doInBackground(Void... params) {
			try {
				HttpResponse res = mclient.execute(mrequest);
				return res.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			
			mOnResult.onResult(result);
		}
	};

	@Override
	public void submit(HttpClient client, HttpUriRequest request) {
		mclient = client;
		mrequest = request;
		mTask.execute(null, null, null);		
	}
	
	public void setOnResult(StatusOKSubmitter.Listener onResult) {
		mOnResult = onResult;
	}
	
	public static interface Listener {
		void onResult(boolean isSuccess);
	}
	
	
	
}