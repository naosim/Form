package com.naosim.form.form;

public class KeyValue {
	private final String mKey;
	private final String mValue;

	public KeyValue(String key, String value) {
		mKey = key;
		mValue = value;
	}

	public String getKey() {
		return mKey;
	}

	public String getValue() {
		return mValue;
	}
}