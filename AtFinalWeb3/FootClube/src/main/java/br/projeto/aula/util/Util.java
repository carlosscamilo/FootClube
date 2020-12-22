package br.projeto.aula.util;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Util {

	public static String md5 (String senha){
		
	try {
		MessageDigest messagedig = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, messagedig.digest(senha.getBytes()));
		return hash.toString(16);
		
	}	catch (Exception e) {
		return "";
	}
	
}
}