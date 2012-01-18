package com.eleybourn.bookcatalogue;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Utilities related to building an AlertDialog that is just a list of clickable options.
 * 
 * @author Grunthos
 */
public class AlertDialogUtils {
	/**
	 * Class to make building a 'context menu' from an AlertDialog a little easier.
	 * Used in Event.buildDialogItems and related Activities.
	 * 
	 * @author Grunthos
	 *
	 */
	public static class AlertDialogItem implements CharSequence {
		public String name;
		public Runnable handler;
		public AlertDialogItem(String name, Runnable handler ) {
			this.name = name;
			this.handler = handler;
		}
		@Override
		public String toString() {
			return name;
		}
		@Override
		public char charAt(int index) {
			return name.charAt(index);
		}
		@Override
		public int length() {
			return name.length();
		}
		@Override
		public CharSequence subSequence(int start, int end) {
			return name.subSequence(start, end);
		}
	}

	/**
	 * Utility routine to display an array of ContextDialogItems in an alert.
	 * 
	 * @param title		Title of Alert
	 * @param items		Items to display
	 */
	public static void showContextDialogue(Context context, String title, ArrayList<AlertDialogItem> items) {
		if (items.size() > 0) {
			AlertDialog.Builder builder = new AlertDialog.Builder(context);
			builder.setTitle(title);

			final AlertDialogItem[] itemArray = new AlertDialogItem[items.size()];
			items.toArray(itemArray);
	
			builder.setItems(itemArray, new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int item) {
			    	itemArray[item].handler.run();
			    }
			});
			AlertDialog alert = builder.create();	
			alert.show();
		}		
	}

}
