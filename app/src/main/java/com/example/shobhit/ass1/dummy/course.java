package com.example.shobhit.ass1.dummy;

/**
 * Created by ANSHUL BASIA on 20/02/2016.
 */
public class course {
    String code;
    String name;
    String description;
    String credits;
    String id;
    String l_t_p;
    public course(String a,String b, String c, String d, String e, String f){
        code=a;
        name=b;
        description=c;
        credits=d;
        id=e;
        l_t_p=f;
    }
    public String get_code(){return code;}
    public String get_ltp(){return l_t_p;}
    public String get_name(){return name;}
    public String get_description(){return description;}
    public String get_credit(){return credits;}
    public String get_id(){return id;}
}
