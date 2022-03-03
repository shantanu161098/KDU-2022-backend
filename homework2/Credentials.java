class Credentials{
    static Credentials instance = null;

    private String str = "this is private string";
    
    private int p = 1;

    private Credentials(){ }

    public String getString(){
        return this.str;
    }

    public int getSecretInteger(){
        return this.p;
    }

    static public Credentials get_object(){
        if(instance == null){
            instance = new Credentials();
            
        }
        return instance;
    }
}

class Main{
    public static void main(String[] args){
        Credentials c = Credentials.get_object();
        System.out.println(c.getString());
        System.out.println(c.getSecretInteger());
    }
}