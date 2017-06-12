package com.hejie.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * 类型转换器 String->Date
 * @author Administrator
 *
 */
public class StringToDateConverter implements Converter<String, Date>{
	
	private final SimpleDateFormat DATA_FORMAT_PARTTEN = new SimpleDateFormat("yyyy-MM-dd");
	
	private final SimpleDateFormat 	DATA_TIME_FORMAT_PARTTEN = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date convert(String source) {
		Date date = null;
		
		if(!StringUtils.hasLength(source)){
			return date;
		}
		
		if(source.contains("-")&&source.length() == 10){
			try {
				date = DATA_FORMAT_PARTTEN.parse(source);
			} catch (ParseException e) {
				throw new IllegalArgumentException(String.format("类型转换失败！期望的格式是[yyyy-MM-dd], 但是实际格式是[%s]", source), e);
			}
		}
		else if(source.contains("-")&&source.contains(":")&&source.length() == 19){
			try {
				date = DATA_TIME_FORMAT_PARTTEN.parse(source);
			} catch (ParseException e) {
				throw new IllegalArgumentException(String.format("类型转换失败！期望的格式是[yyyy-MM-dd HH:mm:ss], 但是实际格式是[%s]", source), e);
			}
		}
		return date;
	}
	
	public static void main(String[] args) {
		StringToDateConverter stdc = new StringToDateConverter();
		System.out.println(stdc.convert("2015-02-02 12:12:12"));
		
	}

}
