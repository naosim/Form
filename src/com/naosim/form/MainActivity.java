package com.naosim.form;

import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

import com.naosim.form.form.Form;
import com.naosim.form.form.FormBuilder;
import com.naosim.form.form.InputHidden;
import com.naosim.form.form.InputText;
import com.naosim.form.form.StatusOKSubmitter.Listener;

public class MainActivity extends Activity implements Listener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FormBuilder builder = new FormBuilder(new DefaultHttpClient());
		builder.setUrl("http://naosim.sakura.ne.jp/app/formtest/formtest.php");
		builder.addInput(new InputText("name", (EditText)findViewById(R.id.name)));
		builder.addInput(new InputText("message", (EditText)findViewById(R.id.message)));
		builder.addInput(new InputHidden("type", "android"));
		builder.setStatusOKListener(this);
		Form form = builder.create();
		
		findViewById(R.id.submit).setOnClickListener(form);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onResult(boolean isSuccess) {
		Toast.makeText(this, "result: " + (isSuccess ? "true" : "false"), Toast.LENGTH_SHORT).show();
		
	}

}
