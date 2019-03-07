package bussinesService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validacija {
	
public String konvertujPasswordUSifru(String password) {
		
		try {
			//Kreiraj MessageDigest objekat koji implementira MD5 algoritam
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//Prosledi password kao niz bajtova u MessageDigest objekat
			md.update(password.getBytes());
			
			//Od passworda kreiramo sifrovani password, ali je vracen kao niz bajtova
			byte[] digest = md.digest();
			
			StringBuffer sb = new StringBuffer();
			//Prolazimo kroz niz bajtova i pretvaramo ga u heksadekadni zapis
			for(int i = 0; i<digest.length; i++) {
				sb.append(Integer.toHexString(digest[i] & 0xff));
			}
			return sb.toString();		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
