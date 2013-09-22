package com.example.checkers;

import java.util.ArrayList;

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

	// Generate squares on the board
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (gridView == null) {
			gridView = (GridView) parent;
		}
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setPadding(0, 0, 0, 0);
			if (brownSquareLocations.contains(position)) {
				imageView.setImageResource(checkersIds[0]);
				checkersBoard.add(SquareStatus.brownSquare);
			} else if (redSquareLocations.contains(position)) {
				imageView.setImageResource(checkersIds[1]);
				checkersBoard.add(SquareStatus.redSquare);
			} else if (blackPieceLocations.contains(position)) {
				imageView.setImageResource(checkersIds[2]);
				checkersBoard.add(SquareStatus.blackPiece);
			} else if (redPieceLocations.contains(position)) {
				imageView.setImageResource(checkersIds[3]);
				checkersBoard.add(SquareStatus.redPiece);
			}
		} else {
			imageView = (ImageView) convertView;
		}

		return imageView;
	}

	public SquareStatus getSquareStatus(int position) {
		return checkersBoard.get(position);
	}

	public void highlightSquare(View v, int position, SquareStatus curStatus) {
		ImageView imageView = (ImageView) v;
		if (curStatus == SquareStatus.blackPiece) {
			imageView.setImageResource(checkersIds[4]);
			checkersBoard.set(position, SquareStatus.blackPieceHighlight);
		} else if (curStatus == SquareStatus.redPiece) {
			imageView.setImageResource(checkersIds[5]);
			checkersBoard.set(position, SquareStatus.redPieceHighlight);
		}
	}

	// Private methods
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

	private void populateBlackSquareLocations() {
		for (int i = 24; i < 32; i += 2) {
			brownSquareLocations.add(i);
			brownSquareLocations.add(i + 9);
		}
	}

	public void unhighlightSquare() {
		for (int i = 0; i < boardSize; ++i) {
			if (getSquareStatus(i) == SquareStatus.blackPieceHighlight) {
				checkersBoard.set(i, SquareStatus.blackPiece);
				((ImageView) gridView.getChildAt(i)).setImageResource(checkersIds[2]);
				return;
			} else if (getSquareStatus(i) == SquareStatus.redPieceHighlight) {
				checkersBoard.set(i, SquareStatus.redPiece);
				((ImageView) gridView.getChildAt(i)).setImageResource(checkersIds[3]);
				return;
			}
		}
	}

	// Private members
	private int boardSize = 64;
	private ArrayList<Integer> blackPieceLocations = new ArrayList<Integer>();
	private ArrayList<Integer> redPieceLocations = new ArrayList<Integer>();
	private ArrayList<Integer> redSquareLocations = new ArrayList<Integer>();
	private ArrayList<Integer> brownSquareLocations = new ArrayList<Integer>();
	private Context mContext;
	private GridView gridView = null;

	// Checkers images
	private Integer[] checkersIds = { R.drawable.brownsquare,
			R.drawable.redsquare, R.drawable.brownsquareblackpiece,
			R.drawable.brownsquareredpiece,
			R.drawable.brownsquareblackpiecehighlight,
			R.drawable.brownsquareredpiecehighlight };

	private ArrayList<SquareStatus> checkersBoard = new ArrayList<SquareStatus>();

	enum SquareStatus {
		redPiece, blackPiece, redSquare, brownSquare, blackPieceHighlight, redPieceHighlight
	};
}