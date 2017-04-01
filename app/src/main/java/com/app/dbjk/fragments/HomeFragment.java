package com.app.dbjk.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.dbjk.R;
import com.app.dbjk.activities.MainActivity;
import com.app.dbjk.model.NavItem;
import com.app.dbjk.utils.ConnectionDetector;


public class HomeFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();

    View rootView;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    private EditText inputSearch;
    private TextInputLayout inputLayoutSearch;

    Boolean isInternetPresent = false;
    ConnectionDetector cd;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        pref = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE); // 0 - for private mode
        editor = pref.edit();

        checkInternet();

        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((MainActivity) getActivity()).loadDrawsHide();
        ((MainActivity) getActivity()).loadDrawsDisplay();

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "fonts/webfont.ttf");

        TextView title = (TextView) getActivity().findViewById(R.id.toolbar_title);
        title.setTypeface(face, Typeface.BOLD);
        title.setTextSize(18);
        title.setText("de Bijenkorf");

        NavItem nav = new NavItem();
        nav.setPage("HomePage");


        inputLayoutSearch = (TextInputLayout) rootView.findViewById(R.id.input_layout_search);

        inputSearch = (EditText) rootView.findViewById(R.id.input_search);

        inputSearch.addTextChangedListener(new MyTextWatcher(inputSearch));

        final Drawable img = this.getResources().getDrawable(R.drawable.ic_action_close);

        inputSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    inputSearch.setCompoundDrawablesWithIntrinsicBounds(null, null, img, null);
                    inputSearch.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {


                            if (inputSearch.getCompoundDrawables()[2] == null)
                                return false;

                            if (event.getAction() != MotionEvent.ACTION_UP)
                                return false;

                            if (event.getX() > inputSearch.getWidth() - inputSearch.getPaddingRight() - img.getIntrinsicWidth()) {
                                inputSearch.setText("");

                            }


                            return false;
                        }
                    });


                } else {

                    inputSearch.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                }
            }
        });

        Button submit = (Button) rootView.findViewById(R.id.rg_send);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });


        return rootView;
    }

    /**
     * Validating form
     */
    private void submitForm() {

        if (!validateSearch()) {
            return;
        }


        String search = inputSearch.getText().toString().trim();

        editor.putString("SearchText", search);
        editor.apply();

        closeKeyBoard();

        ((MainActivity) getActivity()).displayView(1);

    }

    public void closeKeyBoard() {

        try {

            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(new View(getActivity()).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus()
                    .getWindowToken(), 0);

        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {

                case R.id.input_search:
                    validateSearch();
                    break;
            }
        }
    }

    private boolean validateSearch() {
        String name = inputSearch.getText().toString().trim();

        if (name.isEmpty()) {
            inputLayoutSearch.setError(getString(R.string.err_msg_search));
            requestFocus(inputSearch);
            return false;
        } else {
            inputLayoutSearch.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void checkInternet() {

        try {
            cd = new ConnectionDetector(getActivity());

            // Check if Internet present
            isInternetPresent = cd.isConnectingToInternet();

            if (!isInternetPresent) {
                RelativeLayout RelativeLayout = (android.widget.RelativeLayout) rootView.findViewById(R.id
                        .main_content);
                Snackbar snackbar = Snackbar
                        .make(RelativeLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setDuration(10000)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                ((MainActivity) getActivity()).displayView(0);
                            }
                        });

                // Changing message text color
                snackbar.setActionTextColor(Color.RED);

                // Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);

                snackbar.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onResume() {
        super.onResume();
        checkInternet();
    }

}
