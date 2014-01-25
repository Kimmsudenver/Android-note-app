package com.kimtbui.npad.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import android.content.Context;
import android.content.SharedPreferences;

public class notedatasrc {
	private static final String PREKEY="note";
	private SharedPreferences notepref;
	
	public notedatasrc(Context cont){
		notepref=cont.getSharedPreferences(PREKEY, Context.MODE_PRIVATE);
	}
	
	
	public List<noteitem> findall(){
		Map<String, ?> notemap = notepref.getAll();
		SortedSet<String> keys= new TreeSet<String>(notemap.keySet());
		List<noteitem> notelist= new ArrayList<noteitem>();
		for (String key: keys) {
			noteitem note= new noteitem();
			note.setKey(key);
			note.setText((String) notemap.get(key));
			notelist.add(note);
			
		}
		return notelist;
	}
	
	public boolean update(noteitem note){
		SharedPreferences.Editor editor =notepref.edit();
		editor.putString(note.getKey(), note.getText());
		editor.commit();
		return true;
	}
	
	public boolean remove(noteitem note){
		if(notepref.contains(note.getKey())){
		
			SharedPreferences.Editor editor =notepref.edit();
			editor.remove(note.getKey());
			editor.commit();
		}
		return true;
	}
}
