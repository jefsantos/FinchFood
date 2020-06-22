package com.finchFood.utils;
//package com.finchFood.utils;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class SenhaUtils {
//	
//	/** gera um hash utilizando o BCrypt
//	 * @param senha 
//	 * @return String
//	 */
//	
//
//	
//	public static String gerarBCrypt (String senha ) {
//	if (senha == null) {
//		
//		return senha;
//	}
//		
//	BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder() ;
//	
//	return bCryptEncoder.encode(senha);
//	}
//	
///** Verifica se a senha é valida
// * @param senha 
// * @param senhaEncoded
// * return Boolean
// */
//	
//	public static boolean senhaValida (String senha, String senhaEncoded) {
//		 BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
//		 return bCryptEncoder.matches(senha, senhaEncoded);
//	}
//	
//	
//	
//	
//	
//}
