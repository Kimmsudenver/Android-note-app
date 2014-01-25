package com.example.npad;

import com.kimtbui.npad.data.noteitem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

@SuppressLint("NewApi")
public class NoteEditActivity extends Activity {
	
	private noteitem note;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note_editor);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Intent intent=this.getIntent();
		note= new noteitem();
		note.setKey(intent.getStringExtra("key"));
		note.setText(intent.getStringExtra("Text"));
		EditText et= (EditText) findViewById(R.id.notetext);
		et.setText(note.getText());
		et.setSelection(note.getText().length());
		
	}
	
	private void saveAndFinish(){
		EditText et= (EditText) findViewById(R.id.notetext);
		String text= et.getText().toString();
		Intent intent=new Intent();
		intent.putExtra("key", note.getKey());
		intent.putExtra("Text",text);
		setResult(RESULT_OK, intent);
		finish();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			saveAndFinish();
		}
		return false;
		
	}
	@Override
	public void onBackPressed() {
		saveAndFinish();
	}

}
