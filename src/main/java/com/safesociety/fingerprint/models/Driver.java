/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safesociety.fingerprint.models;

/**
 *
 * @author Aaron
 */
public class Driver extends Response {

    private String identification;
    private String fingerprint;

    public Driver() {

    }

    /**
     * @return the id
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification the id to set
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return the validationCode
     */
    public String getFingerprint() {
        return fingerprint;
    }

    /**
     * @param fingerprint the validationCode to set
     */
    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
