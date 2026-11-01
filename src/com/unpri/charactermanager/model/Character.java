package com.unpri.charactermanager.model;

public class Character {
    
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana; // Atribut private baru 

    // Constructor 1
    public Character(String name, CharacterType type, int level)  {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 50; // Nilai default mana awal 
    }

    // Constructor 2
    public Character(int id, String name, CharacterType type, int level, int hitPoints, int attackPower, int mana)  {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = mana;
    }

    private int calculateBaseHP()  {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack()  {
        return 10 + (level * 5);
    }

    // Getter dan Setter
    public int getId()  { return id; }
    public String getName()  { return name; }
    public CharacterType getType()  { return type; }
    public int getLevel()  { return level; }
    public int getHitPoints()  { return hitPoints; }
    public int getAttackPower()  { return attackPower; }
    public int getMana() { return mana; } // Getter mana baru

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal adalah 1");
        }
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    // Setter mana dengan validasi IllegalArgumentException jika negatif
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana;
    }

    // Method baru isAlive()
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    @Override 
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana + '}'; // Ditambahkan informasi mana
    }

    // ===== equals(): membandingkan ISI DATA, bukan alamat memori =====
    // Dua Character dianggap "sama" jika NAMA-nya identik (case-sensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                    // optimasi: jika memang object yang sama persis
        if (!(obj instanceof Character)) return false;    // jika bukan Character, pasti tidak sama
        Character other = (Character) obj;                // casting aman karena sudah dicek instanceof
        return this.name.equals(other.name);               // bandingkan isi atribut name (String punya equals sendiri)
    }
}

   