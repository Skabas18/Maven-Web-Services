package com.cmc.rest.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String convertir(Date date){
		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String formatoARG = formato.format(date);
		System.out.println(formatoARG);
		return formatoARG;
	}
}