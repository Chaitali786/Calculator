package com.example.chaitali.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import static com.example.chaitali.calculator.R.id.textAnswer;

public class MainActivity extends AppCompatActivity {

     //Declare Variables
    Button button_clear,button_dot,button_equal;
    Button button_zero,button_one,button_two,button_three,button_four,button_five,button_six,button_seven,button_eight,button_nine;
    Button button_plus_minus,button_modulo,button_division,button_minus,button_plus,button_multiplication;
    TextView textAnswer;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind variables with UI components
        bindUIcomponent();

        //OnClick of Clear Button
        button_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textAnswer.setText("");
                }
        });

        //OnClick of plus/minus button
        button_plus_minus .setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        //OnClick of modulo button
        button_modulo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("%"); }
                else
                { textAnswer.setText("%");}
            }
        });

        //OnClick of division button
        button_division.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("÷"); }
                else
                { textAnswer.setText("÷"); }
            }
        });

        //OnClick of multiplication button
        button_multiplication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("*"); }
                else
                { textAnswer.setText("*"); }
            }
        });

        //OnClick of minus button
        button_minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("-"); }
                else
                { textAnswer.setText("-"); }
            }
        });

        //OnClick of plus button
        button_plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("+");  }
                else
                { textAnswer.setText("+"); }
            }
        });
        //OnClick of seven button
        button_seven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("7"); }
                else
                { textAnswer.setText("7"); }
            }
        });

        //OnClick of eight button
        button_eight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("8"); }
                else
                { textAnswer.setText("8"); }
            }
        });

        //Onclick of nine button
        button_nine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("9"); }
                else
                { textAnswer.setText("9");}
            }
        });
        //OnClick of four button
        button_four.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("4"); }
                else
                { textAnswer.setText("4"); }
            }
        });

        //Onclick of five button
        button_five.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("5"); }
                else
                { textAnswer.setText("5"); }
            }
        });

        //OnClick of six button
        button_six.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                { textAnswer.append("6"); }
                else
                { textAnswer.setText("6"); }
            }
        });

        //Onclick of one button
        button_one.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                {textAnswer.append("1");}
                else
                {textAnswer.setText("1");}
            }
        });

        //OnClick of two button
        button_two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                {textAnswer.append("2");}
                else
                {textAnswer.setText("2");}
            }
        });

        //OnClick of three button
        button_three.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                {textAnswer.append("3");}
                else
                {textAnswer.setText("3");}
            }
        });
        //OnClick of zero button
        button_zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                {textAnswer.append("0");}
                else
                {textAnswer.setText("0");}
            }
        });

        //OnClick of dot button
        button_dot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(textAnswer != null)
                {textAnswer.append(".");}
                else
                {textAnswer.setText(".");}
            }
        });

        //OnClick of equal button
        button_equal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Boolean isExpressionValid;
                button_equal.setBackgroundColor(Color.parseColor("#d63f3b"));
                String expression =  textAnswer.getText().toString();
                /*-------------------------------------------------------------------------------------*/
                /* Implemented Using Rhino Android Library */
                /*-------------------------------------------------------------------------------------*/
               /* Context rhino = Context.enter();
                  rhino.setOptimizationLevel(-1);// turn off optimization to work with android
                  try {
                    expression = expression.replace("÷","/");
                    Scriptable scope = rhino.initStandardObjects();
                    String result = rhino.evaluateString(scope, expression, "JavaScript", 1, null).toString();
                    textAnswer.setText(result);
                  } finally {
                    Context.exit();
                }*/
                /*-------------------------------------------------------------------------------------*/

                char[] expressionTokens = expression.toCharArray();
                int exp_length = expressionTokens.length;
                isExpressionValid = checkValidExpression(expressionTokens,exp_length);

                if(isExpressionValid == true)
                {
                    expression = evaluateExpression(expression, "÷");//D
                    expression = evaluateExpression(expression, "*");//M
                    expression = evaluateExpression(expression, "%");//M
                    expression = evaluateExpression(expression, "+");//A
                    expression = evaluateExpression(expression, "-");//S
                    textAnswer.setText(expression);
                }
            }
        });

    }

    /**
     * Method To Evaluate Expression
     * @param expression string expression
     * @param operator   arithmatic operators
     * @return expression
     */
    public String  evaluateExpression(String expression, String operator){

        if(expression.contains(operator)){

            int opIndex = expression.indexOf(operator);

            if(opIndex == 0){//negative number comes at first position in the expression

                opIndex = expression.substring(1).indexOf(operator);
            }

            else {
                String lhsExp = expression.substring(0, opIndex);
                String operand1 = findOperand(lhsExp, "lhs");


                String rhsExp = expression.substring(opIndex + 1, expression.length());
                String operand2 = findOperand(rhsExp, "rhs");

                double result = calculate(Double.parseDouble(operand1), Double.parseDouble(operand2), operator);
                System.out.println("Result  " + result);

                expression = lhsExp.substring(0, lhsExp.length() - operand1.length()) + result + "" + rhsExp.substring(operand2.length(), rhsExp.length());
                expression = evaluateExpression(expression, operator);
            }
        }
        return expression;
    }

    /**
     * Method to calculate result of arithmetic expression
     *@param operand1 double
     * @param operand2 double
     * @param operator single operator
     * @return result
     */
    static double calculate(double operand1, double operand2, String operator){
        double result = 0;

        switch(operator){
            case "+": result=operand1 + operand2; break;
            case "-": result=operand1 - operand2; break;
            case "*": result=operand1 * operand2; break;
            case "÷": result=operand1 / operand2; break;
            case "%": result=operand1 % operand2; break;
        }
        return result;
    }

    /**
     * Method to find Operand
     * @param expression string
     * @param direction string
     * @return number
     */
    static String findOperand(String expression, String direction ){
        String operand = expression;
        if(direction.equals("lhs")){
            for(int i=expression.length()-1; i>0; i--){
                if(expression.charAt(i) == '+'
                        || expression.charAt(i) == '-' || expression.charAt(i) == '÷' || expression.charAt(i) == '*' || expression.charAt(i) == '%' ){
                    operand = expression.substring(i+1, expression.length());
                    break;
                }
            }
        }else if(direction.equals("rhs")){
            for(int i=0; i<expression.length()-1; i++){
                if(expression.charAt(i) == '+'
                        || expression.charAt(i) == '-' || expression.charAt(i) == '÷' || expression.charAt(i) == '*' || expression.charAt(i) == '%' ){
                    operand = expression.substring(0, i);
                    break;
                }
            }
        }
        return operand;
    }

    /**
     * Method to check validation of expression
     * @param charExpression charArray
     * @param length  int
     * @return  boolean True: Valid ,False:Invalis
     */
    public boolean checkValidExpression(char[] charExpression,int length ){

        int exp_length = length;
        if( charExpression[exp_length-1] == '+' || charExpression[exp_length-1] == '-' || charExpression[exp_length-1] == '*' || charExpression[exp_length-1] == '÷' || charExpression[exp_length-1] == '%')
        {  Toast.makeText(getApplicationContext(), "Invalid Expression !! ", Toast.LENGTH_LONG).show(); }
        else
            { return true; }
        return false;
    }

    /**
     * Method to bind variables with UI Component
     */
    public void bindUIcomponent()
    {

        textAnswer    = (TextView) findViewById(R.id.textAnswer);
        button_clear  = (Button) findViewById(R.id.btn_clear);
        button_plus_minus = (Button) findViewById(R.id.btn_plusMinus);
        button_modulo = (Button) findViewById(R.id.btn_modulo);
        button_division = (Button) findViewById(R.id.btn_division);
        button_multiplication = (Button) findViewById(R.id.btn_multiplication);
        button_plus = (Button) findViewById(R.id.btn_plus);
        button_minus = (Button) findViewById(R.id.btn_minus);
        button_dot = (Button) findViewById(R.id.btn_dot);
        button_equal = (Button) findViewById(R.id.btn_equal);

        button_zero = (Button) findViewById(R.id.btn_zero);
        button_one = (Button) findViewById(R.id.btn_one);
        button_two = (Button) findViewById(R.id.btn_two);
        button_three = (Button) findViewById(R.id.btn_three);
        button_four = (Button) findViewById(R.id.btn_four);
        button_five = (Button) findViewById(R.id.btn_five);
        button_six = (Button) findViewById(R.id.btn_six);
        button_seven = (Button) findViewById(R.id.btn_seven);
        button_eight = (Button) findViewById(R.id.btn_eight);
        button_nine = (Button) findViewById(R.id.btn_nine);
        }

}
