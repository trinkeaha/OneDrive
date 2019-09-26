package com.trinke.onedrive;


import com.trinke.onedrive.admin.core.config.SystemConfig;
import com.trinke.onedrive.admin.core.util.EncryptionUtil;

public class test1 {
    public static void main(String[] args) {
        String s = EncryptionUtil.AESEnc(SystemConfig.PASSKEY, "123");
        System.out.println(s);
        System.out.println("明文："+EncryptionUtil.AESDec(SystemConfig.PASSKEY,"yESthjhIlljQMFkhrrkaHQ=="));
    }

}
