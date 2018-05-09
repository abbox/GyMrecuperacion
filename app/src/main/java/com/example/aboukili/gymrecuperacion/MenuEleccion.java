package com.example.aboukili.gymrecuperacion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuEleccion extends Fragment {

    Button rutinas;
    Button ejercicios;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Eleccion");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.rutinas,container,false);

        View v = inflater.inflate(R.layout.menu_eleccion, container, false);

        rutinas = (Button) v.findViewById(R.id.btn_Rutinas);
        ejercicios = (Button) v.findViewById(R.id.btn_Ejercicios);

        rutinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new Rutinas();

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.content_main, fragment).addToBackStack(null);
                ft.commit();

            }
        });
    return v;
    }
}
