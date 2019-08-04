package crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Sha256 {
    public static String encryptSha256(String input)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++)
            {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static String encryptSha256d(String input) {
        return Sha256.encryptSha256(Sha256.encryptSha256(input));
    }
}
