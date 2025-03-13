package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Ejercicio03 {
    public static void main(String[] args) {
        List<String> uids = Arrays.asList(
            "B1CD102354",
            "B1CDEF2354",
            "A123456789",
            "AAB1234567",
            "ABCDEF1234"
        );

        List<String> validos = validarUID(uids);
        System.out.println("UIDs válidos: " + validos);
    }

    public static List<String> validarUID(List<String> uids) {
        return uids.stream()
                .filter(uid -> uid.length() == 10) 
                .filter(uid -> uid.chars().allMatch(Character::isLetterOrDigit)) 
                .filter(uid -> uid.chars().filter(Character::isUpperCase).count() >= 2) 
                .filter(uid -> uid.chars().filter(Character::isDigit).count() >= 3) 
                .filter(uid -> uid.chars().distinct().count() == 10) 
                .collect(Collectors.toList());
    }
}
