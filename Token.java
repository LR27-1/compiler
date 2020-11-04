//Token.java
public class Token {

    //クラスのフィールド変数（意味:kind,文字列:value）
    public String kind;
    public String value;

    @Override
    public String toString() {
        return kind + " \"" + value + "\"";
    }

}
