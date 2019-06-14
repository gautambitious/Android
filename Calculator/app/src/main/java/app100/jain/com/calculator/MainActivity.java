package app100.jain.com.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,divide,multiply,decimal,calc,c1,c2;
TextView t;
TextView e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        decimal=findViewById(R.id.decimal);
        zero=findViewById(R.id.zero);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multiply=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        calc=findViewById(R.id.calc);
        t=findViewById(R.id.textView);
        e=findViewById(R.id.editText);
        c1=findViewById(R.id.clear);
        c2=findViewById(R.id.back);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        decimal.setOnClickListener(this);
        calc.setOnClickListener(this);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.plus)
            e.setText(e.getText().toString().concat("+"));
        if (v.getId()==R.id.minus)
            e.setText(e.getText().toString().concat("-"));
        if (v.getId()==R.id.divide)
            e.setText(e.getText().toString().concat("/"));
        if (v.getId()==R.id.multiply)
            e.setText(e.getText().toString().concat("*"));
        if (v.getId()==R.id.zero)
            e.setText(e.getText().toString().concat("0"));
        if (v.getId()==R.id.one)
            e.setText(e.getText().toString().concat("1"));
        if (v.getId()==R.id.two)
            e.setText(e.getText().toString().concat("2"));
        if (v.getId()==R.id.three)
            e.setText(e.getText().toString().concat("3"));
        if (v.getId()==R.id.four)
            e.setText(e.getText().toString().concat("4"));
        if (v.getId()==R.id.five)
            e.setText(e.getText().toString().concat("5"));
        if (v.getId()==R.id.six)
            e.setText(e.getText().toString().concat("6"));
        if (v.getId()==R.id.seven)
            e.setText(e.getText().toString().concat("7"));
        if (v.getId()==R.id.eight)
            e.setText(e.getText().toString().concat("8"));
        if (v.getId()==R.id.nine)
            e.setText(e.getText().toString().concat("9"));
        if (v.getId()==R.id.decimal)
            e.setText(e.getText().toString().concat("."));
        if (v.getId()==R.id.calc)
            t.setText(""+calculate(e.getText().toString()));
        String str;
        if (v.getId()==R.id.clear){
            e.setText("");
            t.setText("");
        }
        if (v.getId()==R.id.back){
            if(!e.getText().toString().equals("")){
            str=e.getText().toString();
            str = str.replace(str.substring(str.length()-1), "");
            e.setText(str);}
        }

    }
    public static double calculate(final String str){
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
