package com.example.checkers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.checkers.ImageAdapter.SquareStatus;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position,
					long id) {
				ImageAdapter imageAdapter = (ImageAdapter) gridview
						.getAdapter();
				if (imageAdapter.Move(position))
				{
					return;
				}
				
				if (imageAdapter.getSquareStatus(position) == SquareStatus.blackPiece) {
					imageAdapter.highlightSquare(v, position,
							SquareStatus.blackPiece);
				} else if (imageAdapter.getSquareStatus(position) == SquareStatus.redPiece) {
					imageAdapter.highlightSquare(v, position,
							SquareStatus.redPiece);
				}
				/*Toast.makeText(MainActivity.this, "" + position,
						Toast.LENGTH_SHORT).show();*/
			}
		});
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

}
