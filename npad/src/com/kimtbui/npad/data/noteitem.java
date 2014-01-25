package com.kimtbui.npad.data;


import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class noteitem {
	private String key;
	private String text;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	//get new to instantiate the class by method
	@SuppressLint("SimpleDateFormat") public static noteitem getnew(){
		Locale locale= new Locale("en_US");
		Locale.setDefault(locale);
		String pattern="yyyy-MM-dd HH:mm:ss Z";
		SimpleDateFormat formatter= new SimpleDateFormat(pattern);
		String key= formatter.format(new Date());
		noteitem note= new noteitem();
		note.setKey(key);
		note.setText("");
		return note;
	}
	
	@Override
	public String toString() {
		
		return this.getText();
	}
	
	
}
