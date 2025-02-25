package com.adinhpo.execptions;

import java.util.function.Supplier;

public class NegocioExeption extends RuntimeException implements Supplier<NegocioExeption> {
    private String message;

    public NegocioExeption(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public NegocioExeption get() {
        return null;
    }
}
