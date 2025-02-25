package com.adinhpo;

import java.util.UUID;

public final class IDGenerator {
    public static String gerarProximoId(){
        return UUID.randomUUID().toString();
    }
}
