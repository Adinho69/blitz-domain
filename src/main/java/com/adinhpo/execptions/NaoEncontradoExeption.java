package com.adinhpo.execptions;

import java.util.function.Supplier;

public class NaoEncontradoExeption extends RuntimeException implements Supplier<NaoEncontradoExeption> {
    private String message;

    public NaoEncontradoExeption(String message) {
        super(message);
        this.message = message;
    }
    @Override
    public NaoEncontradoExeption get() {
        return null;
    }
}
