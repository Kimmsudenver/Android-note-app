package com.example.npad;

import java.util.HashMap;
import java.util.List;

import com.kimtbui.npad.data.noteitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class StableArrayAdapter extends ArrayAdapter<noteitem> {

	    private List<noteitem> noteitems ;
	    private Context context;
	    private int layoutresource;
	    

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<noteitem> objects) {
	      super(context, textViewResourceId, objects);
	      this.layoutresource= textViewResourceId;
	      this.context=context;
	      this.noteitems= objects;
	    		  
	      }
	    

	   

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	    	View row= convertView;
	    	noteitemview notev=null;
	    	LayoutInflater inflater = (LayoutInflater)context.getSystemService
	    		      (Context.LAYOUT_INFLATER_SERVICE);	
	    	row= inflater.inflate(layoutresource, parent,false);
	    	notev= new noteitemview();
	    	notev.note=noteitems.get(position);
	    	notev.deletebutton = (Button)row.findViewById(R.id.button1);
	    	notev.deletebutton.setTag(notev.note);
	    	notev.tview=(TextView) row.findViewById(R.id.text1);
	    	notev.tview.setText(notev.note.getText());
	    	notev.tview.setTag(notev.note);
	    	row.setTag(notev);
	    	return row;	    			
	    }
	    
	    
	  }

