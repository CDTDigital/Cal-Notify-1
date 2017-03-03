package com.informatixinc.calnotify.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Encryption utility
 * 
 * @author Sean Kammerich
 *
 */
public class SecurityUtils {

	private static SecureRandom random = new SecureRandom();

	/**
	 * Generate a session toke
	 * 
	 * @return - the token
	 */
	public static String genSessionToken() {
		return new BigInteger(130, random).toString(32);
	}

	/**
	 * Generate salt
	 * 
	 * @return - the salt
	 */
	public static byte[] getNewSalt() {
		Random r = new SecureRandom();
		byte[] salt = new byte[32];
		r.nextBytes(salt);
		return salt;
	}

	/**
	 * Hash a password
	 * 
	 * @param password
	 * @param salt
	 * @return - the password has
	 */
	public static byte[] hashPassword(byte[] password, byte[] salt) {
		byte[] concat = concat(password, salt);
		for (int i = 0; i < 1000; i++) {
			concat = DigestUtils.sha512(concat);
		}
		return concat;
	}

	private static byte[] concat(byte[] first, byte[] second) {
		byte[] result = new byte[first.length + second.length];
		System.arraycopy(first, 0, result, 0, first.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

}
