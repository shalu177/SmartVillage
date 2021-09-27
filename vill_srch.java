package com.example.dellpc.smartvillage;
import android.app.Activity;
        import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.PopupWindow;
public class vill_srch extends AppCompatActivity {
    Button btnCancelPopup;
    Button btnCreatePopup;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vill_srch);
        b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(vill_srch.this, Village_reg.class);
                vill_srch.this.startActivity(mainIntent);
                vill_srch.this.finish();

            }
        });
        btnCreatePopup = (Button) findViewById(R.id.srchbtn);
        btnCreatePopup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                initiatePopupWindow();
            }
        });

    }

    private PopupWindow pwindo;

    private void initiatePopupWindow() {
        try {
// We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) vill_srch.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.activity_pop_up_reg,(ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout,700 , 900, true);
            pwindo.showAtLocation(layout, Gravity.LEFT, 0, 0);

            btnCancelPopup = (Button) layout.findViewById(R.id.btn_reg);
            btnCancelPopup.setOnClickListener(cancel_button_click_listener);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener cancel_button_click_listener = new View.OnClickListener() {
        public void onClick(View v) {

            pwindo.dismiss();
        }
    };

}
