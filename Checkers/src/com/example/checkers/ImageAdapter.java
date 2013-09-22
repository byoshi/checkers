package com.example.checkers;

import java.util.ArrayList;
import java.lang.Integer;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	public ImageAdapter(Context c) {
		populatePieceLocations(1, 8, 7, blackPieceLocations);
		populatePieceLocations(40, 48, 9, redPieceLocations);
		populateRedSquareLocations();
		populateBlackSquareLocations();
		mContext = c;
	}

	public int getCount() {
		return boardSize;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	//Generate squares on the board
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null)
		{
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setPadding(0, 0, 0, 0);
		} else {
			imageView = (ImageView) convertView;
		}
		if (blackPieceLocations.contains(position)) {
			imageView.setImageResource(checkersIds[2]);
		} else if (redPieceLocations.contains(position)) {
			imageView.setImageResource(checkersIds[3]);
		} else if (brownSquareLocations.contains(position)) {
			imageView.setImageResource(checkersIds[0]);
		} else if (redSquareLocations.contains(position)) {
			imageView.setImageResource(checkersIds[1]);
		}

		return imageView;
	}
	
	//Private members
	private int boardSize = 64;
	private ArrayList<Integer> blackPieceLocations = new ArrayList<Integer>();
	private ArrayList<Integer> redPieceLocations = new ArrayList<Integer>();
	private ArrayList<Integer> redSquareLocations = new ArrayList<Integer>();
	private ArrayList<Integer> brownSquareLocations = new ArrayList<Integer>();
	private Context mContext;
	
	//Checkers images
	private Integer[] checkersIds = { R.drawable.brownsquare,
			R.drawable.redsquare, R.drawable.brownsquareblackpiece,
			R.drawable.brownsquareredpiece };

	private void populatePieceLocations(int startingSquare, int endSquare,
			int middleRowAdd, ArrayList<Integer> pieceArray) {
		for (int i = startingSquare; i < endSquare; i += 2) {
			pieceArray.add(i);
			pieceArray.add(i + middleRowAdd);
			pieceArray.add(i + 16);
		}
	}

	private void populateRedSquareLocations() {
		for (int i = 0; i < 8; i += 2) {
			redSquareLocations.add(i);
			redSquareLocations.add(i + 9);
			redSquareLocations.add(i + 16);
			redSquareLocations.add(i + 25);
			redSquareLocations.add(i + 32);
			redSquareLocations.add(i + 41);
			redSquareLocations.add(i + 48);
			redSquareLocations.add(i + 57);
		}
	}
	
	private void populateBlackSquareLocations()
	{
		for (int i = 24; i < 32; i += 2)
		{
			brownSquareLocations.add(i);
			brownSquareLocations.add(i+9);
		}
	}
}