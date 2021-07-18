package devanmejia.productshopemail.service.crypto;

import devanmejia.productshopemail.exception.DecodeException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import java.security.*;

@Service
public class CryptoService {
    private static final String ALGORITHM = "RSA";
    private PrivateKey privateKey;
    private PublicKey publicKey;

    @PostConstruct
    public void init() throws Exception {
        KeyPair keyPair = generateRSAKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
    }

    private KeyPair generateRSAKeyPair() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(2048, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }

    public String decrypt(byte[] cipherText) throws DecodeException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] result = cipher.doFinal(cipherText);
            return new String(result);
        } catch (Exception e){
            throw new DecodeException("Can not decode message.", e);
        }
    }


    public PublicKey getPublicKey() {
        return publicKey;
    }
}
