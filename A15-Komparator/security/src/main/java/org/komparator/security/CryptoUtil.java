package org.komparator.security;

import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.util.*;

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
    // TODO add security helper methods

}
