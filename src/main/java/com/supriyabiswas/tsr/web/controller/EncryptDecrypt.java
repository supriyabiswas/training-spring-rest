package com.supriyabiswas.tsr.web.controller;

import java.security.GeneralSecurityException;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Config;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.hybrid.HybridDecryptFactory;
import com.google.crypto.tink.hybrid.HybridEncryptFactory;
import com.google.crypto.tink.hybrid.HybridKeyTemplates;

public class EncryptDecrypt {
	Aead aead = null;
	static{
			try {
				Config.register(TinkConfig.TINK_1_0_0);
			//	Config.register(AeadConfig.TINK_1_0_0);
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}
		}
	public static void main(String[] args) {
	//	AeadProcess();
		HybridProcess();
	}
	private static void AeadProcess() {
		KeysetHandle keysetHandle = null;
		Aead aead = null;
		String plaintext = "I am Supriya Biswas";
		String contextInfo = "Residing at G-18, Sreenagar Main Road";
		try {
			Config.register(AeadConfig.TINK_1_0_0);
			// 1. Generate the private key material.
			keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES128_GCM);
			// 2. Get the primitive.
			aead = AeadFactory.getPrimitive(keysetHandle);
			
			// 3. Use the primitive to encrypt a plaintext,
			byte[] ciphertext = null;
			ciphertext = aead.encrypt(plaintext.getBytes(), contextInfo.getBytes());
			System.out.println("after encryption="+ciphertext);
			byte[] decrypted = aead.decrypt(ciphertext, contextInfo.getBytes());
			System.out.println("after decryption="+decrypted);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
	}
	public static void HybridProcess(){
		String plaintext = "I am Supriya Biswas";
		String contextInfo = "Residing at G-18, Sreenagar Main Road";
		
		try {
			KeysetHandle privateKeysetHandle = KeysetHandle.generateNew(HybridKeyTemplates.ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM);

			    // Obtain the public key material.
			    KeysetHandle publicKeysetHandle =  privateKeysetHandle.getPublicKeysetHandle();

			    // ENCRYPTING

			    // 2. Get the primitive.
			    HybridEncrypt hybridEncrypt = HybridEncryptFactory.getPrimitive(
			        publicKeysetHandle);

			    // 3. Use the primitive.
			    byte[] ciphertext = hybridEncrypt.encrypt(plaintext.getBytes(), contextInfo.getBytes());
			    String encYTxt=new String(ciphertext);
			    System.out.println("AAAAAAAAAA "+encYTxt+"================");
			    // DECRYPTING
			    System.out.println("***********"+ciphertext);
			    // 2. Get the primitive.
			    HybridDecrypt hybridDecrypt = HybridDecryptFactory.getPrimitive(privateKeysetHandle);

			    // 3. Use the primitive.
			    byte[] decryptText = hybridDecrypt.decrypt(ciphertext, contextInfo.getBytes());
			    String decyTxt=new String(decryptText);
			    System.out.println("***********++++++"+decyTxt);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}
}