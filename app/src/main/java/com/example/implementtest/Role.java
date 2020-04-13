package com.example.implementtest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Role {
    @Id
    private String Name;
    private int HP;
    private int MaxHP;
    private int MP;
    private int Max_MP;
    private int ATK;
    private int MATK;
    private int DEF;
    private int MDEF;
    private int AGI;
   // private String skil[];//技能表..还是应该用List?

    public Role(String Name, int HP, int MaxHP, int MP, int Max_MP, int ATK,
            int MATK, int DEF, int MDEF, int AGI, String skil) {
        this.Name = Name;
        this.HP = HP;
        this.MaxHP = MaxHP;
        this.MP = MP;
        this.Max_MP = Max_MP;
        this.ATK = ATK;
        this.MATK = MATK;
        this.DEF = DEF;
        this.MDEF = MDEF;
        this.AGI = AGI;
       // this.skil = skil;
    }

    @Generated(hash = 616509000)
    public Role(String Name, int HP, int MaxHP, int MP, int Max_MP, int ATK,
            int MATK, int DEF, int MDEF, int AGI) {
        this.Name = Name;
        this.HP = HP;
        this.MaxHP = MaxHP;
        this.MP = MP;
        this.Max_MP = Max_MP;
        this.ATK = ATK;
        this.MATK = MATK;
        this.DEF = DEF;
        this.MDEF = MDEF;
        this.AGI = AGI;
    }

    @Generated(hash = 844947497)
    public Role() {
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxHP() {
        return this.MaxHP;
    }

    public void setMaxHP(int MaxHP) {
        this.MaxHP = MaxHP;
    }

    public int getMP() {
        return this.MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getMax_MP() {
        return this.Max_MP;
    }

    public void setMax_MP(int Max_MP) {
        this.Max_MP = Max_MP;
    }

    public int getATK() {
        return this.ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getMATK() {
        return this.MATK;
    }

    public void setMATK(int MATK) {
        this.MATK = MATK;
    }

    public int getDEF() {
        return this.DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getMDEF() {
        return this.MDEF;
    }

    public void setMDEF(int MDEF) {
        this.MDEF = MDEF;
    }

    public int getAGI() {
        return this.AGI;
    }

    public void setAGI(int AGI) {
        this.AGI = AGI;
    }

}
