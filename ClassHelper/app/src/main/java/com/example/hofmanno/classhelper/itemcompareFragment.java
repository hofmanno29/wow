package com.example.hofmanno.classhelper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link itemcompareFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link itemcompareFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class itemcompareFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public itemcompareFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment itemcompareFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static itemcompareFragment newInstance(String param1, String param2) {
        itemcompareFragment fragment = new itemcompareFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_itemcompare, container, false);

        ArrayAdapter<CharSequence> adapter_class = ArrayAdapter.createFromResource(this.getContext(), R.array.class_array, android.R.layout
                .simple_spinner_item);
        adapter_class.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner_class = (Spinner) view.findViewById(R.id.spinner_class);
        spinner_class.setAdapter(adapter_class);
        final Spinner spinner_role = (Spinner) view.findViewById(R.id.spinner_role);

        spinner_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String current_class;
            ArrayAdapter<CharSequence> adapter_role = null;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                current_class = spinner_class.getSelectedItem().toString();

                switch (current_class) {
                    case "Death Knight":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.super.getContext(), R.array.tankmelee_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Druid":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.super.getContext(), R.array.alround_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Hunter":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.ranged_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Mage":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.ranged_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Paladin":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.tankmeleeheal_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Priest":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.rangedheal_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Rogue":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.melee_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Shaman":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.meleerangedheal_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Warlock":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.ranged_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    case "Warrior":
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.tankmelee_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                    default:
                        adapter_role = ArrayAdapter.createFromResource(itemcompareFragment.this.getActivity(), R.array.alround_array, android.R.layout
                                .simple_spinner_item);
                        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner_role.setAdapter(adapter_role);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_role.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
