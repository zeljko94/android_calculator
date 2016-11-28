package ba.sve_mo.fpmoz.zeljko.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class GlavnaAktivnost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavna_aktivnost);


        Button btn_0 = (Button) findViewById(R.id.btn_0);
        btn_0.setOnClickListener(btnListener);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(btnListener);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(btnListener);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(btnListener);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setOnClickListener(btnListener);
        Button btn_5 = (Button) findViewById(R.id.btn_5);
        btn_5.setOnClickListener(btnListener);
        Button btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setOnClickListener(btnListener);
        Button btn_7 = (Button) findViewById(R.id.btn_7);
        btn_7.setOnClickListener(btnListener);
        Button btn_8 = (Button) findViewById(R.id.btn_8);
        btn_8.setOnClickListener(btnListener);
        Button btn_9 = (Button) findViewById(R.id.btn_9);
        btn_9.setOnClickListener(btnListener);
        Button btn_eq = (Button) findViewById(R.id.btn_eq);
        btn_eq.setOnClickListener(btnListener);
        Button btn_ce = (Button) findViewById(R.id.btn_ce);
        btn_ce.setOnClickListener(btnListener);
        Button btn_add = (Button) findViewById(R.id.btn_pl);
        btn_add.setOnClickListener(btnListener);
        Button btn_sub = (Button) findViewById(R.id.btn_mi);
        btn_sub.setOnClickListener(btnListener);
        Button btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(btnListener);
        Button btn_div = (Button) findViewById(R.id.btn_div);
        btn_div.setOnClickListener(btnListener);
        Button btn_zarez = (Button) findViewById(R.id.btn_zarez);
        btn_zarez.setOnClickListener(btnListener);
        Button btn_kvad = (Button) findViewById(R.id.btn_kvad);
        btn_kvad.setOnClickListener(btnListener);
        Button btn_pot = (Button) findViewById(R.id.btn_pot);
        btn_pot.setOnClickListener(btnListener);
    }

    boolean eval = false;
    View.OnClickListener btnListener= new View.OnClickListener() {
        @Override
        public void onClick (View v){


            TextView rezultat = (TextView) findViewById(R.id.result_txt);
            Button btn = (Button) v;

            String vrijednost = btn.getText().toString();


            double dobivena_vrijednost = 0;

            if (vrijednost.equals("="))
            {
                Calculable calc = null;

                try {
                    calc = new ExpressionBuilder(rezultat.getText().toString()).build();
                    dobivena_vrijednost = calc.calculate();
                } catch (UnparsableExpressionException e) {
                    e.printStackTrace();
                } catch (UnknownFunctionException e) {
                    e.printStackTrace();
                }

                eval = true;
                rezultat.setText(String.valueOf(dobivena_vrijednost));}

            else if (vrijednost.equals("C"))
            {

                rezultat.setText("");

            }

            else {

                if (eval)
                {

                    rezultat.setText("");
                    eval = false;
                }
                rezultat.setText( new StringBuilder().append(rezultat.getText().toString()).append(vrijednost).toString());

            }



        }




    };

}
