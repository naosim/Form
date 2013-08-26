package com.naosim.form.form;

import android.widget.EditText;

public class InputText implements Input {
	
	private String mKey;
	private EditText mEditText;

	public InputText(String key, EditText editText) {
		mKey = key;
		mEditText = editText;
	}

	@Override
	public KeyValue getKeyValue() {
		return new KeyValue(mKey, mEditText.getText().toString());
	}

}
