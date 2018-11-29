package classTest;

import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES�����࣬��Կ������16λ�ַ���
 */
public class AESUtils {

	/**ƫ����,������16λ�ַ���*/
    private static final String IV_STRING = "16-Bytes--String";

    /**
     * Ĭ�ϵ���Կ������ʹ��2.1���ɵ�secret
     */
    public static final String DEFAULT_KEY = "1bd83b249a414036";

    /**
     * ���������Կ(���������Կ������16λ)
     */
    public static String generateKey() {
        String key = UUID.randomUUID().toString();
        key = key.replace("-", "").substring(0, 16);// �滻��-��
        return key;
    }

    public static String encryptData(String key, String content) {
        byte[] encryptedBytes = new byte[0];
        try {
        	//content
            byte[] byteContent = content.getBytes("UTF-8");
            // ע�⣬Ϊ������ iOS ͳһ
            // ����� key ������ʹ�� KeyGenerator��SecureRandom��SecretKey ����
            //key
            byte[] enCodeFormat = key.getBytes();
            
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            
            byte[] initParam = IV_STRING.getBytes();
            
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // ָ�����ܵ��㷨������ģʽ����䷽ʽ
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            encryptedBytes = cipher.doFinal(byteContent);
            // ͬ���Լ��ܺ����ݽ��� base64 ����
            return Base64Utils.encode(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptData(String key, String content) {
        try {
            // base64 ����
            byte[] encryptedBytes = Base64Utils.decode(content);
            byte[] enCodeFormat = key.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);
            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
		String plainText = AESUtils.decryptData("F431E6FF9051DA07", "q8jHYk6LSbwC2K4zmr/wRZo8mlH0VdMzPEcAzQadTCpSrPQ/ZnTmuIvQxiLOnUXu");
		System.out.println("aes���ܺ�: " + plainText);
	}
    
}
