package com.example.yourgod.lab2;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
   // ArrayAdapter<CharSequence> adapter;

    public String cl="Black";
    public String _textss;
    public EditText ed_text;
    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        /*
        View view = inflater.inflate(R.layout.fragment_fragment2,container,false);
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity().getBaseContext() , android.R.layout.simple_spinner_item, _color);

        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spColor= (Spinner) view.findViewById(R.id.spinnerColor);

        spColor.setAdapter(colorAdapter);


        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(null,android.R.layout.simple_spinner_item, _color);

        colorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spColor= (Spinner) findViewById(R.id.spinnerColor);

        spColor.setAdapter(colorAdapter);


        spColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getSelectedItem().toString()=="Red")
                    cl="Red";
                    // text_v.setTextColor(Color.RED);
                else if (parent.getSelectedItem().toString()=="Green")
                    cl="Green";

                    // text_v.setTextColor(Color.GREEN);
                else if (parent.getSelectedItem().toString()=="Blue")
                    cl="Blue";
                    //text_v.setTextColor(Color.BLUE);
                else if (parent.getSelectedItem().toString()=="Black")
                    cl="Black";
                //text_v.setTextColor(Color.BLACK);
                //Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2,container,false);
        Button buttonOk = (Button) view.findViewById(R.id.button);
        Button buttonCancel = (Button) view.findViewById(R.id.button2);
         ed_text = (EditText) view.findViewById(R.id.editText);


         String[] _color = {"Red", "Green", "Blue", "Black"};
        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerColor);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, _color);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if (parent.getSelectedItem().toString()=="Red")
                    cl="Red";
                    // text_v.setTextColor(Color.RED);
                else if (parent.getSelectedItem().toString()=="Green")
                    cl="Green";

                    // text_v.setTextColor(Color.GREEN);
                else if (parent.getSelectedItem().toString()=="Blue")
                    cl="Blue";
                    //text_v.setTextColor(Color.BLUE);
                else if (parent.getSelectedItem().toString()=="Black")
                    cl="Black";
                //text_v.setTextColor(Color.BLACK);
                //Toast.makeText(getBaseContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }

        });



        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View v){

                    _textss = ed_text.getText().toString();
                    ed_text.setText(" ");
                    setColor();
                }

        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){

                _textss = " ";
                ed_text.setText(" ");
                setColor();
            }

        });

        // Inflate the layout for this fragment
        return view;
    }

    interface OnFragmentInteractionListener {

        void onFragmentInteraction(String _text, String _color);
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }



   public void setColor(){
       mListener.onFragmentInteraction(_textss, cl);
   }
  /*  @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
