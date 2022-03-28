package uz.pdp.utils;

import java.util.UUID;

public class BaseUtils {
    public static  String generateUniqueID() {
        return String.valueOf(UUID.randomUUID()).replace("-", "");
    }
}
