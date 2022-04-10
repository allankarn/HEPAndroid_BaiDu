package com.enetedu.hep.utils;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HepStringUtil {

	public static final int MAX_LEN_PWD = 16;
	public static final int MAX_LEN_LOGINNAME = 100;
	public static final int MAX_LEN_CELLPHONE = 11;
	public static final int MAX_LEN_NICKNAME = 30;
	public static final int MAX_LEN_REALNAME = 20;
	public static final int MAX_LEN_SCHOOL = 120;
	
	public static final int MIN_LEN_LOGINNAME = 5;
	public static final int MIN_LEN_PWD = 6;
	public static final int MIN_LEN_NICKNAME = 2;
	public static final int MIN_LEN_CELLPHONE = 11;
	public static final int MIN_LEN_SCHOOL = 4;
	public static final int MIN_LEN_REALNAME = 2;
	
	
	public static boolean isEmpty(String string) {
		return null == string || "".equals(string);
	}

	/**
	 * 正则表达式判断IP正确性
	 * 
	 * @param ip
	 * @return true /false
	 */
	public static boolean isIPCorrect(String ip) {
		Pattern p = Pattern
				.compile("((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))");

		// ("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})" +
		// "\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})" +
		// "\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})" +
		// "\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");

		// ("""^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$");
		Matcher m = p.matcher(ip);
		return m.matches();
	}

	public static boolean isValidEmail(String email){
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean isValidCellphone(String phoneNum) {
		if (phoneNum == null || phoneNum.length() < 11) {
			return false;
		}
		Pattern pattern = Pattern.compile("1[3|5|7|8|][0-9]{9}");
		Matcher matcher = pattern.matcher(phoneNum);
		return matcher.matches();

	}
	
	


	public static InputFilter[] getPwdFilters() {
		return new InputFilter[] { new InputFilter() {

			@Override
			public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
				StringBuilder sb = new StringBuilder();
				if (source != null && source.length() > 0) {
					int size = source.length();
					for (int i = 0; i < size; i++) {
						char c = source.charAt(i);
						if (c > 32 && c < 126
								&& !"!%'`~&^".contains(String.valueOf(c))) {
							sb.append(c);
						}
					}
				}
				return sb.toString();
			}

		}, getLenthFilter(MAX_LEN_PWD) };
	}
	
	public static InputFilter[] getLoginNameFilters() {
		return new InputFilter[] { getLenthFilter(MAX_LEN_LOGINNAME) };
	}
	
	public static InputFilter[] getCellPhoneFilters() {
		return new InputFilter[] {
				getLenthFilter(MAX_LEN_CELLPHONE),
				new InputFilter() {

					@Override
					public CharSequence filter(CharSequence source, int start,
                                               int end, Spanned dest, int dstart, int dend) {
						StringBuilder sb = new StringBuilder();
						if (source != null && source.length() > 0) {
							int size = source.length();
							for (int i = 0; i < size; i++) {
								char ch = source.charAt(i);
								if (ch >= 48 && ch <= 57) {
									sb.append(ch);
								}
							}
						}
						return sb.toString();
					}

				} };
	}
	
	public static InputFilter[] getRealNameFilters() {
		return new InputFilter[] { getLenthFilter(MAX_LEN_REALNAME) };
	}
	
	public static InputFilter[] getNickNameFilters() {
		return new InputFilter[] { getLenthFilter(MAX_LEN_NICKNAME) };
	}
	
	public static InputFilter[] getSchoolFilters() {
		return new InputFilter[] { getLenthFilter(MAX_LEN_SCHOOL) };
	}
	
	public static InputFilter getLenthFilter(int lenth) {
		return new InputFilter.LengthFilter(lenth);
	}
	
	
    public static String toBinary(long n, int target) {
        String s = "";
        while (n != 0) {
            s = n % target + s;
            n = n / target;
        }
        return s;
    }
    
    /**
     * unicode 编码的字符串还原  若有\\uxxx的编码则还原为中文
     * @param unicodeStr 编码后的字符串
     * @return 解码后的字符串
     */
    
	public static String unicodeStrToString(String unicodeStr) {
		char aChar;
		int len = unicodeStr.length();
		StringBuilder outBuffer = new StringBuilder(len);

		for (int x = 0; x < len;) {
			aChar = unicodeStr.charAt(x++);
			if (aChar == '\\') {
				aChar = unicodeStr.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = unicodeStr.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed \\uxxxx encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}else if(aChar == '"'){
						aChar = '\"';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	
	
	/**
	 * 带中文的字符串编码格式化，中文将被\\uxx的编码代替
	 * @param theString  带中文的字符串
	 * @return 编码后的字符串
	 */
	public static String stringToUnicodeStr(String theString) {
		int len = theString.length();
		StringBuilder outBuffer = new StringBuilder(len * 2);

		for (int x = 0; x < len; x++) {
			char aChar = theString.charAt(x);
			switch (aChar) {
			case ' ':
				if (x == 0) {
					outBuffer.append('\\');
				}
				outBuffer.append(' ');
				break;
			case '\\':
				outBuffer.append('\\');
				outBuffer.append('\\');
				break;
			case '\t':
				outBuffer.append('\\');
				outBuffer.append('t');
				break;
			case '\n':
				outBuffer.append('\\');
				outBuffer.append('n');
				break;
			case '\r':
				outBuffer.append('\\');
				outBuffer.append('r');
				break;
			case '\f':
				outBuffer.append('\\');
				outBuffer.append('f');
				break;
			default:
				if ((aChar < 0x0020) || (aChar > 0x007e)) {
					outBuffer.append('\\');
					outBuffer.append('u');
					outBuffer.append(toHex((aChar >> 12) & 0xF));
					outBuffer.append(toHex((aChar >> 8) & 0xF));
					outBuffer.append(toHex((aChar >> 4) & 0xF));
					outBuffer.append(toHex(aChar & 0xF));
				} else {
					final String specialSaveChars = "=: \t\r\n\f#!";
					if (specialSaveChars.indexOf(aChar) != -1) {
						outBuffer.append('\\');
					}
					outBuffer.append(aChar);
				}
			}
		}
		return outBuffer.toString();
	}

	private static char toHex(int nibble) {
		final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		return hexDigit[(nibble & 0xF)];
	}

	
	public static String subString(String res, int start, int end) {
		if (isEmpty(res)) {
			return "";
		}
		int len = res.length();
		if (end <= len && start < end && start >= 0) {
			return res.substring(start, end);
		}
		return "";
	}

}
