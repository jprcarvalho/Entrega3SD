package org.komparator.security;

import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.util.*;
import static javax.xml.bind.DatatypeConverter.parseBase64Binary;
import static javax.xml.bind.DatatypeConverter.printBase64Binary;
public class CryptoUtil {
	public byte[] asymCipher(byte[] data, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE,key);
		byte[] cipherBytes = cipher.doFinal(data);
		return cipherBytes;
	}
	public byte[] asymDecipher(byte[] cipheredData, Key privateKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] plainData = cipher.doFinal(cipheredData);

		return plainData;
	}
	//RETURNS BASE64 REPRESENTATION OF A BYTE ARRAY, USE PARSEBASE64BINARY IF DECRYPTING SOMETHING CIPHERED WITH THIS
	public String asymCipherString(byte[] data, Key key) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException{
		return printBase64Binary(asymCipher(data,key));
	}
	public String asymDecipherString(byte[] cipheredData, Key privateKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		return new String(asymDecipher(cipheredData,privateKey));
	}
	public String asymDecipherString(String cipheredData, Key privateKey,boolean base64) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		if(base64){
			return new String(asymDecipher(parseBase64Binary(cipheredData),privateKey));
		}
		else{
			return new String(asymDecipher(cipheredData.getBytes(),privateKey));
		}
	}
    // TODO add security helper methods

}
