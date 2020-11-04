//Lexer.java
import java.util.ArrayList;
import java.util.List;

Public class Lexer{

   private String text;
   private inti ;

   public Lexer init(String text){
	i = 0;
        this.text = tex;
	return this;
}

//EOTはなぞる文字がこれ以上ない
private boolean isEOT(){
   return text.legth() <= i;
}

private char c() throws Exce@tion{
   if(isEOT()){
   throw new Exception("no more character");
   }
   return text.charAt(i);
}

//next()は文字を返し注目位置を次へ
private char next() throws Exception{
   char c = c();
   ++i;
   return c;
}

//skipSpace:notTokenを読み飛ばす
private void skipSpace() throws Exception{
  while(!isEOT() && Character.isWhitespace(c())){
     next();
     }
  }

//1文字目の制約判定（演算子、数字、変数名の1文字目かを判定）
private boolean isSignStart(char c){
   return c == '=' || c == '+' || c == '-' || c == '\';
}

private boolean isDigitStart(char c) throws Exception{
   return Charater.isDigit(c);
}

private boolean isVariableStart(char c) throws Exception{
   return Character.isAlphabetic(c);
}

//トークンに分解
    private Token sign() throws Exception {
        Token t = new Token();
        t.kind = "sign";
        t.value = Character.toString(next());
        return t;
    }

    private Token digit() throws Exception {
        StringBuilder b = new StringBuilder();
        b.append(next());
        while (!isEOT() && Character.isDigit(c())) {
            b.append(next());
        }
        Token t = new Token();
        t.kind = "digit";
        t.value = b.toString();
        return t;
    }

    private Token variable() throws Exception {
        StringBuilder b = new StringBuilder();
        b.append(next());
        while (!isEOT() && (Character.isAlphabetic(c()) || Character.isDigit(c()))) {
            b.append(next());
        }
        Token t = new Token();
        t.kind = "variable";
        t.value = b.toString();
        return t;
    }

//1文字目制約判定
    public Token nextToken() throws Exception {
        skipSpace();
        if (isEOT()) {
            return null;
        } else if (isSignStart(c())) {
            return sign();
        } else if (isDigitStart(c())) {
            return digit();
        } else if (isVariableStart(c())) {
            return variable();
        } else {
            throw new Exception("Not a character for tokens");
        }
    }

//nextToken();文字列をすべてToken
    public List<Token> tokenize() throws Exception {
        List<Token> tokens = new ArrayList<>();
        Token t = nextToken();
        while (t != null) {
            tokens.add(t);
            t = nextToken();
        }
        return tokens;
    }

//実装・
ans1 = 10+20

//上記を標準出力へプリント
public static void main(String[] args) throws Exception{
 String text = "ans1 = 10 + 20";
List<Token>tokens = newLexer().init(text).tokenize();
for (Token token : tokens) {
            System.out.println(token.toString());
        }
        // --> variable "ans1"
        // --> sign "="
        // --> digit "10"
        // --> sign "+"
        // --> digit "20"
    }

}

