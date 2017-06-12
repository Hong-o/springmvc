package com.hejie.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.hejie.entity.PhoneNumber;

public class StringToPhoneNumberConverter implements Converter<String, PhoneNumber>{
	// 029-88888888
	Pattern patter = Pattern.compile("^(0\\d{2,3})-(\\d{7,8})$");
	
	@Override
	public PhoneNumber convert(String source) {
		if(!StringUtils.hasLength(source)){
			return null;
		}
		Matcher matcher = patter.matcher(source);
		if(matcher.matches()){
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setAreaCode(matcher.group(1));
			phoneNumber.setPhone(matcher.group(2));
			return phoneNumber;
		}else{
			// 抛出异常
			throw new IllegalArgumentException(String.format("类型转换失败！期望的格式是[0731-76560000], 但是实际格式是[%s]", source));
		}
	}
	
	public static void main(String[] args) {
		StringToPhoneNumberConverter stpnc = new StringToPhoneNumberConverter ();
		
		System.out.println(stpnc.convert("018-88888888"));
	}

}
