package com.example.PTSGENAP10RPL111;

public class dataMahasiswa {
    private String nama, nim, nohp, email,ttl;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    public dataMahasiswa(String nama, String nim, String nohp, String email, String ttl) {
        this.nama = nama;
        this.nim = nim;
        this.nohp = nohp;
        this.email = email;
        this.ttl = ttl;
    }
    public String getTtl() { return ttl; }

    public void setTtl(String ttl) { this.ttl = ttl; }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}
