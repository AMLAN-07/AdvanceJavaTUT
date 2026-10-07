//
package com.college.erp;

import com.college.erp.util.PasswordUtil;

public class TestPassword {

    public static void main(String[] args) {

        String password = "admin123";

        String hash = "$2a$12$bVehPmWBpyLMKPGGxnv3guyZjI4svXDDTKwFfw4yn/q18LOBuT5Ja";

        boolean result =
                PasswordUtil.verifyPassword(password, hash);

        System.out.println("Password matches: " + result);
    }
}