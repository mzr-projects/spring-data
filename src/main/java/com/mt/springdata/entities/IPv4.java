package com.mt.springdata.entities;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

public record IPv4(String address) implements Serializable {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPv4 iPv4 = (IPv4) o;
        return Objects.equals(address, iPv4.address);
    }

    public InetAddress toInetAddress() {
        try {
            String host = address.replaceAll("\\/.*$", "");
            return InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
