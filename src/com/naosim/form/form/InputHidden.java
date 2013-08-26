package com.naosim.form.form;

public class InputHidden implements Input {
	private String mKey;
	private String mValue;


	public InputHidden(String key, String value) {
		mKey = key;
		mValue = value;
	}
	

	@Override
	public KeyValue getKeyValue() {
		return new KeyValue(mKey, mValue);
	}

}
