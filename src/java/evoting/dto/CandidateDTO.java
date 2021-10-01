/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dto;

import java.io.InputStream;

/**
 *
 * @author HP
 */
public class CandidateDTO 
{

    public CandidateDTO(String candidateId, String party, String city, InputStream symbol) {
        this.candidateId = candidateId;
        this.party = party;
        this.city = city;
        this.symbol = symbol;
    }
    private String candidateId;
    private String party;
    private String city;
    private String userid;
    private InputStream symbol;
    
    public CandidateDTO()
    {
        
    }

    @Override
    public String toString() {
        return "CandidateDTO{" + "candidateId=" + candidateId + ", party=" + party + ", city=" + city + ", userid=" + userid + ", symbol=" + symbol + '}';
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public InputStream getSymbol() {
        return symbol;
    }

    public void setSymbol(InputStream symbol) {
        this.symbol = symbol;
    }

    public CandidateDTO(String candidateId, String party, String city, String userid, InputStream symbol) {
        this.candidateId = candidateId;
        this.party = party;
        this.city = city;
        this.userid = userid;
        this.symbol = symbol;
    }
   
}

