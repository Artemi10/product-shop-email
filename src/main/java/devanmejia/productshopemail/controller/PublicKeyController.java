package devanmejia.productshopemail.controller;

import devanmejia.productshopemail.service.crypto.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;

@RestController
@RequestMapping("/email/crypto")
public class PublicKeyController {
    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/key")
    public String getPublicKey(){
        byte[] encodedKey = cryptoService.getPublicKey().getEncoded();
        return DatatypeConverter.printHexBinary(encodedKey);
    }
}
