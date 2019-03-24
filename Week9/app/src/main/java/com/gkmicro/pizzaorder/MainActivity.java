package com.gkmicro.pizzaorder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    private Button button;
    private EditText name, email, address;
    private String size = "", special ="", extra="";
    private double price, specialPrice, extraPrice, total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        button = (Button) findViewById(R.id.order_button);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);


        // add button listener
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Check fields are empty
                if (isEmpty(name) == true || isEmpty(email) == true || isEmpty(address)==true) {
                    emptyErrorMessage();
                }
                else
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            context);

                    // set title
                    alertDialogBuilder.setTitle("Your Order");

                    calcTotal();

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Your Order is: " + size + special  + extra
                                    + "\nTotal $" + total)
                            .setCancelable(false)
                            .setPositiveButton("Confirm & Exit", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MainActivity.this.finish();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.pizza_small:
                if (checked)
                    size = "\nSmall";
                    price = 8;
                    break;
            case R.id.pizza_med:
                if (checked)
                    size = "\nMedium";
                    price = 10;
                    break;
            case R.id.pizza_large:
                if (checked)
                    size = "\nLarge";
                    price = 15;
                    break;
            case R.id.pizza_xlarge:
                if (checked)
                    size = "\nExtra Large";
                    price = 18;
                    break;
        }

    }

    public void onRadioButtonSpecialsClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.pizza_cheese:
                if (checked)
                    special = "\nSuper Cheese";
                    specialPrice = 3;
                    break;
            case R.id.pizza_meaty:
                if (checked)
                    special = "\nSuper Meaty";
                    specialPrice = 5;
                    break;
            case R.id.pizza_veggy:
                if (checked)
                    special = "\nSuper Veggy";
                    specialPrice =2;
                    break;
        }

    }

    public void onCheckBoxClicked (View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.xcheese:
                if (checked)
                {
                    extra += "\nExtra Cheese";
                    extraPrice += 1.50;
                }
                else
                {
                    extra += "";
                    extraPrice += 0;
                }

                break;
            case R.id.xpepp:
                if (checked)
                {
                    extra += "\nExtra Pepperoni";
                    extraPrice += 1.50;
                }
                else
                {
                    extra += "";
                    extraPrice += 0;
                }
                break;
            case R.id.xshroom:
                if (checked)
                {
                    extra += "\nExtra Mushroom";
                    extraPrice += 1.50;
                }
                else
                {
                    extra += "";
                    extraPrice += 0;
                }
                break;
            case R.id.xbacon:
                if (checked)
                {
                    extra += "\nExtra Bacon";
                    extraPrice += 1.50;
                }
                else
                {
                    extra += "";
                    extraPrice += 0;
                }
                break;
        }

    }

    public double calcTotal()
    {
        total = price + specialPrice + extraPrice;
        return total;
    }

    public boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void emptyErrorMessage()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder.setTitle("Fields Empty");

        alertDialogBuilder
                .setMessage("Must enter in name, email and address! ")
                .setCancelable(false)
                .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}


