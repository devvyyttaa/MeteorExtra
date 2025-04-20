/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.utils;

public class ColorRemover {
	public static String GetVerbatim(String text)
	{
		int idx = 0;
		var data = new char[text.length()];

		for ( int i = 0; i < text.length(); i++ )
			if ( text.charAt(i) != '§' &&  text.charAt(i) != '&')
				data[idx++] = text.charAt(i);
			else
				i++;

		return new String(data, 0, idx);
	}
	public static String GetVerbatimAll(String text)
	{
		int idx = 0;
		var data = new char[text.length()];

		for ( int i = 0; i < text.length(); i++ )
			if ( text.charAt(i) != '§' && text.charAt(i) != '&' )
				data[idx++] = text.charAt(i);
			else
				i++;

		return new String(data, 0, idx);
	}
}
