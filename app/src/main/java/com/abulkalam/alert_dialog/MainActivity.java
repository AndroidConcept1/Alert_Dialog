package com.abulkalam.alert_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        //Creating Instance for AlertDialog
        builder = new AlertDialog.Builder(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1st method:- Setting the message
                //  builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                //2nd method:- Setting message manually and performing action on button click
                builder.setMessage("Do you want to close this application?") //using the object of the AlertDialog box we are displaying the message in the Box
                        .setCancelable(false)  //Initially it is set no false so that the app does'nt close

                        //For closing the app on clicking the text for it(here on clicking "Yes")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() { //Creates "Yes" option in the dialog box
                    @Override
                    //On clicking "Yes"
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); //when we want the activity to be closed(here Closing the app)
                        Toast.makeText(getApplicationContext(),"You choose YES action for alertbox", Toast.LENGTH_SHORT).show();
                    }
                })   //don't give semi-colon here continue for 2nd option

                        //For the app to remain open on clicking the text for it(here on clicking "No")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() { //Creates "No" option in the dialog box
                            @Override
                            //Action for "NO" button click
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel(); //cancel the Dialog
                                Toast.makeText(getApplicationContext(), "You choose NO for alertbox", Toast.LENGTH_SHORT).show();
                            }
                        });

                //Creating Dialog Box(by creating its object)
                AlertDialog alertDialog = builder.create(); //Creates an AlertDialog with the arguments supplied(above) to this builder.
                
                //Calling this method(create()) does not display the dialog. If no additional processing is needed, show() may be
                // called instead to both create and display the dialog.

                //Setting the title manually
                alertDialog.setTitle("Alert_Dialog_Example");
                alertDialog.show();
            }
        });
    }
}