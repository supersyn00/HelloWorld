package com.example.itdev.helloworld._model;

import java.util.Date;

/**
 * Created by ITDEV on 8/16/2016.
 */
public class Login_model {
    private String _id, _UserName, _Password, _FullName, _CreatedDate, _CreatedBy;

    // constructor
    public Login_model(){

    }

    public Login_model(String id, String UserName, String Password, String FullName){
        this._id = id;
        this._UserName = UserName;
        this._Password = Password;
        this._FullName = FullName;


    }

    public void set_UserID(String id) {this._id = id;}
    public String get_UserID() {return this._id;}

    public void set_NamaUser(String NamaUser) {this._UserName = NamaUser;}
    public String get_NamaUser() {return this._UserName;}

    public void set_PassUser(String PassUser) {this._Password = PassUser;}
    public String get_PassUser() {return this._Password;}

    public void set_NamaLengkap(String NamaLengkap) {this._FullName = NamaLengkap;}
    public String get_NamaLengkap() {return this._FullName;}


}
