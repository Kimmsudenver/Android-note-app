package com.example.npad;

import java.util.HashMap;
import java.util.List;

import com.kimtbui.npad.data.notedatasrc;
import com.kimtbui.npad.data.noteitem;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity{

	private static final int ACTIVITY_REQUEST = 1001;
	private static final int  DELETE_ID=1002;
	private  int currentNoteid;
	private notedatasrc datasrc;
	public StableArrayAdapter adapter;
	  List<noteitem> notelist;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerForContextMenu(getListView());
        datasrc=new notedatasrc(this);
        refreshdisplay();
      
    }


    private void refreshdisplay() {
         ListView listview = getListView();		
		notelist = datasrc.findall();
		 adapter = new StableArrayAdapter(this,R.layout.list_item_layout, notelist);
		listview.setAdapter(adapter);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if (item.getItemId() == R.id.action_create) {
    		createnote();
    	}
    	
    	return super.onOptionsItemSelected(item);
    }
    
  


	private void createnote() {
		noteitem note = noteitem.getnew();
		Intent intent =new Intent(this, NoteEditActivity.class);
		intent.putExtra("key", note.getKey());
		intent.putExtra("Text", note.getText());
		startActivityForResult(intent,ACTIVITY_REQUEST);
		
	}
////	@Override
	public void textedit(View view) {	
		noteitem note= (noteitem) view.getTag();
		Intent intent =new Intent(this, NoteEditActivity.class);
		intent.putExtra("key", note.getKey());
		intent.putExtra("Text", note.getText());
		startActivityForResult(intent, ACTIVITY_REQUEST);
	}


	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode==ACTIVITY_REQUEST&&resultCode==RESULT_OK){
			noteitem note=new noteitem();
			note.setKey(data.getStringExtra("key"));
			note.setText(data.getStringExtra("Text"));
			datasrc.update(note);
			refreshdisplay();
		}
	}
	
	
//	@Override
//	public boolean onContextItemSelected(MenuItem item) {
//		if (item.getItemId()==DELETE_ID) {
//			noteitem note= notelist.get(currentNoteid);
//			datasrc.remove(note);
//			refreshdisplay();
//		}
//		return super.onContextItemSelected(item);
//	}
	
	
	public void removenote(View view){
		  noteitem note= (noteitem) view.getTag();
		    datasrc.remove(note);	
		    refreshdisplay();
	}
	
	} 

