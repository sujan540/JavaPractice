package practise;

public class CopyConstructor {

    int x;
    CopyConstructor(int x){
        this.x = x;
    }

    CopyConstructor(CopyConstructor copyConstructor){
        this.x = copyConstructor.x;
    }

    public static void main(String[] args) {
//        String test = new String(byte[] arr);
    }


}
