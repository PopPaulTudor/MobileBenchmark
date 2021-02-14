package com.example.benchmark.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.benchmark.R;
import com.example.benchmark.utills.DeviceInfo;

public class DeviceFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
;
        View root = inflater.inflate(R.layout.fragment_device, container, false);
        TextView chipset = root.findViewById(R.id.chipset_field);
        TextView nrOfCPUs = root.findViewById(R.id.nr_of_cpu_field);
        TextView  manufacturer = root.findViewById(R.id.manufacturer_field);
        TextView model = root.findViewById(R.id.model_field);
        TextView resolution = root.findViewById(R.id.resolution_field);
        TextView density = root.findViewById(R.id.density_field);

        chipset.setText(DeviceInfo.getCPUName());
        nrOfCPUs.setText(DeviceInfo.getCPUNumbers() + " cores");
        manufacturer.setText(DeviceInfo.getManufacturer());
        model.setText(DeviceInfo.getModel());
        resolution.setText(DeviceInfo.getMetrics(getContext())[1] + " x " + DeviceInfo.getMetrics(getContext())[0]);
        density.setText(DeviceInfo.getMetrics(getContext())[2] + " ppi");


        return root;
    }
}