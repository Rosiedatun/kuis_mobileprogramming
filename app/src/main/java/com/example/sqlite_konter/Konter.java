package com.example.sqlite_konter;

public class Konter {
    private String _id, _nohp, _harga, _jenis;
    public Konter (String id, String nohp, String harga, String jenis) {
        this._id = id;
        this._nohp = nohp;
        this._harga = harga;
        this._jenis = jenis;
    }
    public Konter() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nohp() {
        return _nohp;
    }
    public void set_nohp(String _nohp) {
        this._nohp = _nohp;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis = _jenis;
    }

}