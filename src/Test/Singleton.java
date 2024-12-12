package Test;

class Singleton {
    private Singleton(){}
    private volatile static Singleton instance;
    /*  1、
        public  static Singleton getInstance(){
        if (instance==null)
            instance = new Singleton();
        return instance;
       }
       2、
        public static synchronized Singleton getInstance(){
            if (instance==null)
                instance = new Singleton();
            return instance;
        }
     */
     public static Singleton getInstance(){
         if (instance==null){
             synchronized (Singleton.class){
                 if (instance==null)
                     instance = new Singleton();
             }
         }
         return instance;
     }

    public static void main(String[] args) {
        for (int i=0,j=0;i+j<20;i++,j+=i--){
            System.out.println(i+j);
        }
    }
}
